package com.telran;

import com.telran.dao.ConcurrentPersonManager;
import com.telran.interfaces.IManager;
import com.telran.model.Person;

import java.util.stream.StreamSupport;

public class TestSingleThread {
    public static void main(String[] args) {
        IManager manager = new ConcurrentPersonManager();
        manager.add(new Person(1,"Vasya",23));
        manager.add(new Person(2,"Petya",27));
        manager.add(new Person(3,"Petya",25));
        manager.add(new Person(4,"Sofa",18));
        manager.add(new Person(5,"David",27));
        manager.add(new Person(6,"Moshe",31));
        manager.add(new Person(6,"Empty",40));

        System.out.println(StreamSupport
                .stream(manager.find(Integer.MIN_VALUE,Integer.MAX_VALUE).spliterator(),false)
                .count()
        );

        manager.find(25,27).forEach(System.out::println);
        System.out.println("===============");
        manager.find("Petya").forEach(System.out::println);
        manager.remove(2);
        System.out.println("===============");
        manager.find("Petya").forEach(System.out::println);
        System.out.println("===============");
        System.out.println(manager.find(4));

    }
}
