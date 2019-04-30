package com.telran;

import com.telran.dao.ConcurrentManagerMaps;
import com.telran.dao.ConcurrentPersonManager;
import com.telran.interfaces.IManager;
import com.telran.model.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.StreamSupport;

public class TestConcurrency {
    public static void main(String[] args) throws InterruptedException {
        IManager manager = new ConcurrentPersonManager();
        AtomicInteger addCount = new AtomicInteger();
        AtomicInteger removeCount = new AtomicInteger();
        AtomicInteger getIdCount = new AtomicInteger();

        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch removeLatch = new CountDownLatch(1);
        CountDownLatch readerLatch = new CountDownLatch(1);

        Runnable adder = ()->{
            try {
                latch.await();
                Random rnd = new Random();
                for (int i = 0; i < 1000; i++) {
                    int age = 18 + rnd.nextInt(90 - 18);
                    int id = addCount.incrementAndGet();
                    manager.add(new Person(id, "Person " + id, age));
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };

        Runnable remover = ()->{
            try {
                removeLatch.await();
                for (int i = 0; i < 1000; i++) {
                    int id = removeCount.incrementAndGet();
                    if(!manager.remove(id)){
                        System.out.println(id);
                    }
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        };

        Runnable getterById = ()->{
            try {
                readerLatch.await();

                for (int i = 0; i < 1000; i++) {
                    int id = getIdCount.incrementAndGet();
                    manager.find(id);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable getterByName = ()->{
            try {
                readerLatch.await();
                Random rnd = new Random();
                for (int i = 0; i < 1000; i++) {
                    manager.find("Person " + rnd.nextInt(10000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable getterByAge = ()->{
            try {
                readerLatch.await();
                Random rnd = new Random();
                for (int i = 0; i < 1000; i++) {
                    int minAge = 18 + rnd.nextInt(12);
                    int maxAge = 30 + rnd.nextInt(60);
                    manager.find(minAge,maxAge);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(adder);
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(remover);
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(getterById);
            t.start();
            threads.add(t);
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(getterByName);
            t.start();
            threads.add(t);
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(getterByAge);
            t.start();
            threads.add(t);
        }
        latch.countDown();
        Thread.sleep(100);
        readerLatch.countDown();
        removeLatch.countDown();
        for(Thread t : threads){
            t.join();
        }
        long count = StreamSupport
                .stream(manager.find(Integer.MIN_VALUE,Integer.MAX_VALUE).spliterator(),false)
                .count();
        System.out.println(count);
    }
}
