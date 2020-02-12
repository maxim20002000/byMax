package com.senlainc.homework.service;


import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;

public interface RoomService {
    void addRoom(Room room);

    void changeRoomStatus(int id, RoomStatus roomStatus);

    void changePriceRoom(int idRoom, double price);

    void sortByPrice();

    void sortByStarCount();

    void sortByNumberOfBed();

    void sortFreeByPrice();

    void sortFreeByStarCount();

    void sortFreeByNumberOfBed();

    void showRoomList();

    void showFreeRoomList();

    void showNumberOfFreeRoom();

    void showRoomDetails(int idRoom);

    void updateFreeRoomList();
}
