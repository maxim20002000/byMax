package com.senlainc.homework.controller;


import by.karnaukh.maksim.lib.annotation.Autowired;
import by.karnaukh.maksim.lib.annotation.ConfigClass;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.service.AdditionalService;
import com.senlainc.homework.service.CheckInService;
import com.senlainc.homework.service.HistoryService;
import com.senlainc.homework.service.PersonService;
import com.senlainc.homework.service.RoomService;

import java.util.Calendar;

@ConfigClass
public class ControllerImpl implements Controller {

    private static ControllerImpl controllerImplInstance;

    @Autowired
    private PersonService personService;

    @Autowired
    private AdditionalService additionalService;

    @Autowired
    private CheckInService checkInService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private HistoryService historyService;

    private ControllerImpl() {
    }

    public static ControllerImpl getInstance() {
        if (controllerImplInstance == null) {
            controllerImplInstance = new ControllerImpl();
        }
        return controllerImplInstance;
    }


    public void addPerson(Person person) {
        personService.addPerson(person);
    }


    public void addRoom(Room room) {
        roomService.addRoom(room);
    }


    public void addAdditional(Additional additional) {
        additionalService.addAdditional(additional);
    }

    public void checkInPerson(int idPerson, int roomNumber, int days) {
        checkInService.checkInPerson(idPerson, roomNumber, days);
    }

    public void showCheckIn() {
        checkInService.showCheckIn();
    }

    public void evictFromRoom(int roomNumber) {
        checkInService.evictFromRoom(roomNumber);
    }

    public void changeRoomStatus(int roomNumber, RoomStatus roomStatus) {
        roomService.changeRoomStatus(roomNumber, roomStatus);
    }

    public void changePriceRoom(int roomNumber, double price) {
        roomService.changePriceRoom(roomNumber, price);
    }

    public void changePriceAdditional(int idAdditional, double price) {
        additionalService.changePriceAdditional(idAdditional, price);
    }

    public void sortRoomByPrice() {
        roomService.sortByPrice();
    }

    public void sortRoomByStarCount() {
        roomService.sortByStarCount();
    }

    public void sortRoomByNumberOfBed() {
        roomService.sortByNumberOfBed();
    }

    public void sortFreeRoomByPrice() {
        roomService.sortFreeByPrice();
    }

    public void sortFreeRoomByStarCount() {
        roomService.sortFreeByStarCount();
    }

    public void sortFreeRoomByNumberOfBed() {
        roomService.sortFreeByNumberOfBed();
    }

    public void showRoomList() {
        roomService.showRoomList();
    }

    public void showFreeRoomList() {
        roomService.showFreeRoomList();
    }

    public void showPersonListById() {
        personService.showPersonListById();
    }

    public void sortCheckInByLastName() {
        checkInService.sortByLastName();
    }

    public void sortCheckInByEvictDay() {
        checkInService.sortByEvictDay();
    }

    public void showNumberOfFreeRoom() {
        roomService.showNumberOfFreeRoom();
    }

    public void showNumberOfResident() {
        checkInService.showNumberOfResident();
    }

    public void showFreeRoomsByDate(Calendar date) {
        checkInService.showFreeRoomsByDate(date);
    }

    public void calculateCostOfLiving(int idPerson) {
        checkInService.calculateCostOfLiving(idPerson);
    }

    public void showLastResidents(int roomNumber) {
        historyService.showLastResidents(roomNumber);
    }

    public void addAdditionalToPerson(int idAdditional, int idPerson) {
        personService.addAdditional(idAdditional, idPerson);
    }

    public void showPersonAdditionalService(int idPerson) {
        personService.showAdditional(idPerson);
    }

    public void sortPersonAdditionalListByDate(int idPerson) {
        personService.sortAdditionalByDate(idPerson);
    }

    public void sortPersonAdditionalListByPrice(int idPerson) {
        personService.sortAdditionalByPrice(idPerson);
    }

    public void showRoomDetails(int idRoom) {
        roomService.showRoomDetails(idRoom);
    }

    public void showAdditional() {
        additionalService.showAdditionalList();
    }


    public void updateFreeRoomList() {
        roomService.updateFreeRoomList();
    }
}
