package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RoomRepositoryImpl implements RoomRepository, Serializable {
    private static RoomRepositoryImpl roomRepositoryInstance;
    private List<Room> roomsList;
    private List<Room> freeRoomsList;

    private RoomRepositoryImpl() {
        this.roomsList = new ArrayList<>();
        this.freeRoomsList = new ArrayList<>();

    }

    public static RoomRepositoryImpl getRoomRepository() {
        if (roomRepositoryInstance == null) {
            roomRepositoryInstance = new RoomRepositoryImpl();
        }
        return roomRepositoryInstance;
    }


    @Override
    public void addRoom(Room room) {
        boolean isRoom = false;
        for (Room room1 : roomsList) {
            if (room1.getRoomNumber() == room.getRoomNumber()) {
                isRoom = true;
                System.out.println("Room already exists");
                break;
            }
        }
        if (!isRoom) {
            roomsList.add(room);
            System.out.println("Room added");
        }


    }

    @Override
    public Room getRoomByRoomNumber(int roomNumber) {
        return roomsList.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Room> getRoomList() {
        return roomsList;
    }

    @Override
    public void setRoomList(List<Room> roomList) {
        roomsList = roomList;
    }

    @Override
    public List<Room> getFreeRoomList() {
        if (freeRoomsList != null) {
            return freeRoomsList;
        }
        return null;
    }

    @Override
    public void setFreeRoomList(List<Room> list) {
        freeRoomsList = list;
    }

    @Override
    public void setFreeRoomList() {
        freeRoomsList = roomsList
                .stream()
                .filter(room -> room.getRoomStatus() == RoomStatus.FREE)
                .collect(Collectors.toList());
    }


}
