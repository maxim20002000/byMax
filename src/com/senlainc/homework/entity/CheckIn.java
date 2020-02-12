package com.senlainc.homework.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CheckIn implements Serializable {
    private int roomNumber;
    private int idPerson;
    private Calendar checkinDate;
    private Calendar evictDate;

    public CheckIn(int roomNumber, int idPerson, Calendar evictDate) {
        this.roomNumber = roomNumber;
        this.idPerson = idPerson;
        this.evictDate = evictDate;
        this.checkinDate = new GregorianCalendar();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public Calendar getCheckinDate() {
        return checkinDate;
    }

    public Calendar getEvictDate() {
        return evictDate;
    }

    @Override
    public String toString() {
        return "| Room Number=" + roomNumber +
                "| Id Person=" + idPerson +
                "| CheckinDate=" + checkinDate.getTime() +
                "| EvictDate=" + evictDate.getTime();
    }
}
