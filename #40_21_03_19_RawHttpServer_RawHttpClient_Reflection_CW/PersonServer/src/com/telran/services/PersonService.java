package com.telran.services;

import com.telran.dto.PersonDto;

import java.util.List;

public interface PersonService {
    boolean add(PersonDto person);
    boolean delete(int id);
    List<PersonDto> getAll();
    PersonDto getById(int id);
    boolean update(PersonDto person);
}
