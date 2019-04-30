package com.telran.dao;

import com.telran.comparators.PersonAgeComparator;
import com.telran.comparators.PersonNameComparator;
import com.telran.interfaces.IManager;
import com.telran.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class ConcurrentPersonManager implements IManager {
    private final List<Person> idList;
    private final List<Person> nameList;
    private final List<Person> ageList;
    private final PersonAgeComparator ageComparator;
    private final PersonNameComparator nameComparator;
    private final Lock writeLock;
    private final Lock readLock;

    public ConcurrentPersonManager() {
        idList = new ArrayList<>();
        nameList = new ArrayList<>();
        ageList = new ArrayList<>();
        ageComparator = new PersonAgeComparator();
        nameComparator = new PersonNameComparator();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        writeLock = lock.writeLock();
        readLock = lock.readLock();
    }

    @Override
    public boolean add(Person person) {
        writeLock.lock();
        try {
            int indx = Collections.binarySearch(idList,person);
            if(indx < 0){
                idList.add(-indx-1,person);
                indx = -Collections.binarySearch(ageList,person,ageComparator)-1;
                ageList.add(indx,person);
                indx = -Collections.binarySearch(nameList,person,nameComparator)-1;
                nameList.add(indx,person);
                return true;
            }
            return false;
        }finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean remove(int id) {
        writeLock.lock();
        try {
            Person tmp = new Person(id,"",0);
            int indx = Collections.binarySearch(idList,tmp);
            if(indx >= 0){
                tmp = idList.remove(indx);
                indx = Collections.binarySearch(nameList,tmp,nameComparator);
                nameList.remove(indx);
                indx = Collections.binarySearch(ageList,tmp,ageComparator);
                ageList.remove(indx);
                return true;

            }
            return false;
        }finally {
            writeLock.unlock();
        }
    }

    @Override
    public Person find(int id) {
        readLock.lock();
        try {
            Person tmp = new Person(id,"",0);
            int indx = Collections.binarySearch(idList,tmp);
            if(indx >= 0){
                return idList.get(indx);
            }
            return null;
        }finally {
            readLock.unlock();
        }
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        readLock.lock();
        try {
            Person left = new Person(Integer.MIN_VALUE,"",minAge);
            Person right = new Person(Integer.MAX_VALUE,"",maxAge);
            int indxL = -Collections.binarySearch(ageList,left,ageComparator)-1;
            int indxR = -Collections.binarySearch(ageList,right,ageComparator)-1;
            return ageList.subList(indxL,indxR).stream().collect(Collectors.toUnmodifiableList());
        }finally {
            readLock.unlock();
        }
    }

    @Override
    public Iterable<Person> find(String name) {
        readLock.lock();
        try {
            Person left = new Person(Integer.MIN_VALUE,name,0);
            Person right = new Person(Integer.MAX_VALUE,name,0);
            int indxL = -Collections.binarySearch(nameList,left,nameComparator)-1;
            int indxR = -Collections.binarySearch(nameList,right,nameComparator)-1;

            return nameList.subList(indxL,indxR).stream().collect(Collectors.toUnmodifiableList());
        }finally {
            readLock.unlock();
        }
    }
}
