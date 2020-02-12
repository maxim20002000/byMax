package com.senlainc.homework.entity;

import java.io.Serializable;
import java.util.Calendar;

public class History implements Serializable {
    private Room room;
    private Person person;
    private Calendar checkInDate;
    private Calendar evictDate;

    public History(Room room, Person person, Calendar checkInDate, Calendar evictDate) {
        this.room = room;
        this.person = person;
        this.checkInDate = checkInDate;
        this.evictDate = evictDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Calendar getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Calendar checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Calendar getEvictDate() {
        return evictDate;
    }

    public void setEvictDate(Calendar evictDate) {
        this.evictDate = evictDate;
    }

    @Override
    public String toString() {
        return "| Room=" + room.getRoomNumber() +
                "| ID person=" + person.getIdPerson() +
                "| checkInDate=" + checkInDate.getTime() +
                "| evictDate=" + evictDate.getTime();
    }
}
