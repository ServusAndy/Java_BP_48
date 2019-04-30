package com.telran.interfaces;

import com.telran.model.Person;

public interface IManager {
    boolean add(Person person);
    boolean remove(int id);
    Person find(int id);
    Iterable<Person> find(int minAge, int maxAge);
    Iterable<Person> find(String name);
}
