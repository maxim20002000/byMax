package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Person;

import java.util.List;

public interface PersonRepository {
    void addPerson(Person person);

    Person findByPassport(String passportNumber);

    Person getPersonById(int id);

    List<Person> getPersonList();

    void setPersonList(List<Person> list);
}
