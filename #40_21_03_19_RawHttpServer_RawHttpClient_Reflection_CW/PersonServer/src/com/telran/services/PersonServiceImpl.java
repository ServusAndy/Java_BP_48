package com.telran.services;

import com.telran.dto.PersonDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService {
    private Map<Integer,PersonDto> persons;

    public PersonServiceImpl() {
        persons = new HashMap<>();
    }

    @Override
    public boolean add(PersonDto person) {
        //Todo return false if person already exist
        persons.put(person.getId(),person);
        return true;
    }

    @Override
    public boolean delete(int id) {
        //Todo remove and return true if person with {id} exist
        //    return false if person with {id} don't exist
        return false;
    }

    @Override
    public List<PersonDto> getAll() {
        return List.copyOf(persons.values());
    }

    @Override
    public PersonDto getById(int id) {
        return persons.get(id);
    }

    @Override
    public boolean update(PersonDto person) {
        //Todo update person if exist and return true
        //    return false if person don't exist
        return false;
    }
}
