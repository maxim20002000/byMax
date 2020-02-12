package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository, Serializable {
    private static PersonRepositoryImpl personRepositoryInstance;
    private List<Person> personsList;

    private PersonRepositoryImpl() {
        this.personsList = new ArrayList<>();
    }

    public static PersonRepositoryImpl getPersonRepository() {
        if (personRepositoryInstance == null) {
            personRepositoryInstance = new PersonRepositoryImpl();
        }
        return personRepositoryInstance;
    }


    @Override
    public Person findByPassport(String passportNumber) {
        return personsList.stream()
                .filter(p -> p.getPassportNumber() == passportNumber)
                .findAny()
                .orElse(null);
    }

    @Override
    public void addPerson(Person person) {
        if (findByPassport(person.getPassportNumber()) == null) {
            personsList.add(person);
            System.out.println("Person successfully added");
        } else {
            System.out.println("Person already exists");
        }

    }

    @Override
    public Person getPersonById(int id) {
        return personsList.stream().filter(p -> p.getIdPerson() == id).findAny().orElse(null);
    }


    @Override
    public List<Person> getPersonList() {
        return personsList;
    }

    @Override
    public void setPersonList(List<Person> list) {
        personsList = list;
    }
}
