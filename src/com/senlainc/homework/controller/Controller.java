package com.senlainc.homework.controller;

import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;

import java.util.Calendar;

public interface Controller {
    void addPerson(Person person);

    void addRoom(Room room);

    void addAdditional(Additional additional);

    void checkInPerson(int idPerson, int roomNumber, int days);

    void showCheckIn();

    void evictFromRoom(int roomNumber);

    void changeRoomStatus(int roomNumber, RoomStatus roomStatus);

    void changePriceRoom(int roomNumber, double price);

    void changePriceAdditional(int idAdditional, double price);

    void sortRoomByPrice();

    void sortRoomByStarCount();

    void sortRoomByNumberOfBed();

    void sortFreeRoomByPrice();

    void sortFreeRoomByStarCount();

    void sortFreeRoomByNumberOfBed();

    void showRoomList();

    void showFreeRoomList();

    void showPersonListById();

    void sortCheckInByLastName();

    void sortCheckInByEvictDay();

    void showNumberOfFreeRoom();

    void showNumberOfResident();

    void showFreeRoomsByDate(Calendar date);

    void calculateCostOfLiving(int idPerson);

    void showLastResidents(int roomNumber);

    void addAdditionalToPerson(int idAdditional, int idPerson);

    void showPersonAdditionalService(int idPerson);

    void sortPersonAdditionalListByDate(int idPerson);

    void sortPersonAdditionalListByPrice(int idPerson);

    void showRoomDetails(int idRoom);

    void showAdditional();

    void updateFreeRoomList();
}
