package com.senlainc.homework.service;


import java.util.Calendar;

public interface CheckInService {
    void checkInPerson(int idPerson, int idRoom, int days);

    void showCheckIn();

    void evictFromRoom(int idRoom);

    void sortByLastName();

    void sortByEvictDay();

    void showNumberOfResident();

    void showFreeRoomsByDate(Calendar date);

    void calculateCostOfLiving(int idPerson);
}
