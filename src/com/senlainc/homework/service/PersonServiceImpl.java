package com.senlainc.homework.service;

import by.karnaukh.maksim.lib.annotation.ConfigClass;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.repository.AdditionalRepositoryImpl;
import com.senlainc.homework.repository.PersonRepositoryImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ConfigClass
public class PersonServiceImpl implements PersonService {
    private static LoggerService logger;

    public PersonServiceImpl() {
        logger = new LoggerServiceImpl();
    }

    @Override
    public void addPerson(Person person) {
        PersonRepositoryImpl.getPersonRepository().addPerson(person);
    }

    @Override
    public void showPersonListById() {
        List<Person> persons = PersonRepositoryImpl.getPersonRepository().getPersonList();
        System.out.println("---------------------Person list--------------------");
        persons.forEach(person -> System.out.println(person.toString()));
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void addAdditional(int idAdditional, int idPerson) {
        try {
            Person person = PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson);
            Additional additional = AdditionalRepositoryImpl.getAdditionalRepository().getAdditionalById(idAdditional);
            person.addAdditionalToList(additional);
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person");
            logger.error(this, "NPE/Incorrect id person");
        }
    }

    @Override
    public void showAdditional(int idPerson) {
        try {
            Person person = PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson);
            List<Additional> additionals = person.getAdditionalList();
            System.out.println("--------------Service for person---------------");
            additionals.forEach(additional -> System.out.println(additional.toString()));
            System.out.println("------------------------------------------------");
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person");
            logger.error(this, "NPE/Incorrect id person");
        }
    }

    @Override
    public void sortAdditionalByDate(int idPerson) {
        try {
            Person person = PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson);
            List<Additional> nonSortedList = person.getAdditionalList();
            nonSortedList = nonSortedList
                    .stream()
                    .sorted(Comparator.comparing(Additional::getDateUse))
                    .collect(Collectors.toList());
            person.setAdditionalService(nonSortedList);
            System.out.println("Additional for person " + person.getLastName() + " sorted by Date");
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person");
            logger.error(this, "NPE/Incorrect id person");
        }
    }

    @Override
    public void sortAdditionalByPrice(int idPerson) {
        try {
            Person person = PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson);
            List<Additional> nonSortedList = person.getAdditionalList();
            nonSortedList = nonSortedList
                    .stream()
                    .sorted(Comparator.comparing(Additional::getPrice))
                    .collect(Collectors.toList());
            person.setAdditionalService(nonSortedList);
            System.out.println("Additional for person " + person.getLastName() + " sorted by Price");
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person");
            logger.error(this, "NPE/Incorrect id person");
        }
    }
}
