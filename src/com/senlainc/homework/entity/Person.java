package com.senlainc.homework.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static int counter = 0;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passportNumber;
    private int idPerson;
    private List<Additional> additionalService;

    public Person(String firstName, String lastName, String phoneNumber, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.idPerson = counter;
        this.additionalService = new ArrayList<>();
        counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void addAdditionalToList(Additional additional) {
        additionalService.add(additional);
    }

    public List<Additional> getAdditionalList() {
        return additionalService;
    }

    public void cleanAdditional() {
        additionalService.clear();
    }

    public void setAdditionalService(List<Additional> additionalService) {
        this.additionalService = additionalService;
    }

    @Override
    public String toString() {
        return "| ID=" + idPerson +
                "| firstName=" + firstName +
                "| lastName=" + lastName +
                "| phoneNumber=" + phoneNumber +
                "| passportNumber=" + passportNumber;
    }
}
