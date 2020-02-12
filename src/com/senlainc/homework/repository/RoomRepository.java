package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Room;

import java.util.List;


public interface RoomRepository {
    void addRoom(Room room);

    Room getRoomByRoomNumber(int idRoom);

    List<Room> getRoomList();

    void setRoomList(List<Room> roomList);

    List<Room> getFreeRoomList();

    void setFreeRoomList(List<Room> list);

    void setFreeRoomList();


}
