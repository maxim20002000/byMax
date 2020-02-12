package com.senlainc.homework.service;

import com.senlainc.homework.entity.Person;

public interface PersonService {
    void addPerson(Person person);

    void showPersonListById();

    void addAdditional(int idAdditional, int idPerson);

    void showAdditional(int idPerson);

    void sortAdditionalByDate(int idPerson);

    void sortAdditionalByPrice(int idPerson);
}
