package com.senlainc.homework.service;

import by.karnaukh.maksim.lib.annotation.ConfigClass;
import by.karnaukh.maksim.lib.annotation.ConfigProperty;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.repository.RoomRepositoryImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ConfigClass
public class RoomServiceImpl implements RoomService {

    private static LoggerService logger;

    @ConfigProperty(configName = "changeStatus")
    private boolean isChangeStatus;

    public RoomServiceImpl() {
        logger = new LoggerServiceImpl();
    }

    @Override
    public void addRoom(Room room) {
        RoomRepositoryImpl.getRoomRepository().addRoom(room);
    }

    @Override
    public void changeRoomStatus(int roomNumber, RoomStatus roomStatus) {
        try {
            if (RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber).getRoomStatus() == RoomStatus.BUSY) {
                System.out.println("Room is BUSY now to change room status. Please evict person");
            } else {
                if (isChangeStatus) {
                    RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber).setRoomStatus(roomStatus);
                    System.out.println("**Room status changed**");
                } else {
                    System.out.println("You can not change status!");
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect room number");
            logger.error(this, "NPE / Incorrect room number");
        }
    }

    @Override
    public void changePriceRoom(int roomNumber, double price) {
        try {
            if (RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber).getRoomStatus() == RoomStatus.BUSY) {
                System.out.println("Room is BUSY now to change price. Please evict person");
            } else {
                RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber).setPriceOfRoom(price);
                System.out.println("**Room price changed**");
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect room number");
            logger.error(this, "NPE /Incorrect room number");
        }
    }

    @Override
    public void sortByPrice() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getRoomList();
        notSortedList = notSortedList.stream()
                .sorted(Comparator.comparingDouble(Room::getPriceOfRoom))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setRoomList(notSortedList);
        System.out.println("**Room sorted by price**");
    }

    @Override
    public void sortByStarCount() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getRoomList();
        notSortedList = notSortedList.stream()
                .sorted(Comparator.comparingInt(Room::getStarCount))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setRoomList(notSortedList);
        System.out.println("**Room sorted by star count**");

    }

    @Override
    public void sortByNumberOfBed() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getRoomList();
        notSortedList = notSortedList.stream()
                .sorted(Comparator.comparingInt(Room::getNumberOfBeds))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setRoomList(notSortedList);
        System.out.println("**Room sorted by number of bed**");
    }

    @Override
    public void sortFreeByPrice() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getFreeRoomList();
        notSortedList = notSortedList.stream()
                .sorted(Comparator.comparingDouble(Room::getPriceOfRoom))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setFreeRoomList(notSortedList);
        System.out.println("**Free room sorted by price**");
    }

    @Override
    public void sortFreeByStarCount() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getFreeRoomList();
        notSortedList = notSortedList
                .stream()
                .sorted(Comparator.comparingInt(Room::getStarCount))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setFreeRoomList(notSortedList);
        System.out.println("**Free room sorted by star count**");

    }

    @Override
    public void sortFreeByNumberOfBed() {
        List<Room> notSortedList = RoomRepositoryImpl.getRoomRepository().getFreeRoomList();
        notSortedList = notSortedList
                .stream()
                .sorted(Comparator.comparingInt(Room::getNumberOfBeds))
                .collect(Collectors.toList());
        RoomRepositoryImpl.getRoomRepository().setFreeRoomList(notSortedList);
        System.out.println("**Free room sorted by number of bed**");
    }

    @Override
    public void showRoomList() {
        List<Room> rooms = RoomRepositoryImpl.getRoomRepository().getRoomList();
        System.out.println("------------Room list--------------------------------------------------");
        rooms.forEach(room -> System.out.println(room.toString()));
        System.out.println("-----------------------------------------------------------------------");
    }

    @Override
    public void showFreeRoomList() {
        System.out.println("------------Free room list-----------------------------------------------");
        RoomRepositoryImpl.getRoomRepository()
                .getFreeRoomList()
                .forEach(room -> System.out.println(room.toString()));
        System.out.println("-------------------------------------------------------------------------");
    }


    @Override
    public void showNumberOfFreeRoom() {
        List<Room> rooms = RoomRepositoryImpl.getRoomRepository().getRoomList();
        long counter = rooms.stream()
                .filter(room -> room.getRoomStatus() == RoomStatus.FREE)
                .count();
        System.out.println("Free room number = " + counter);
    }

    @Override
    public void showRoomDetails(int idRoom) {

        try {
            System.out.println("--------------Room--------------------------------------------");
            Room room = RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(idRoom);
            System.out.println(room.toString());
            System.out.println("--------------------------------------------------------------");
        } catch (NullPointerException e) {
            System.out.println("Room number is incorrect");
            logger.error(this, "NPE / Incorrect room number ");
        }
    }

    @Override
    public void updateFreeRoomList() {
        RoomRepositoryImpl.getRoomRepository().setFreeRoomList();
    }


}
