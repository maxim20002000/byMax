package com.senlainc.homework.entity;

import java.io.Serializable;

public class Room implements Serializable {

    private RoomStatus roomStatus;
    private double priceOfRoom;
    private int roomNumber;
    private int numberOfBeds;
    private int starCount;

    public Room(RoomStatus roomStatus, double priceOfRoom, int roomNumber, int numberOfBeds, int starCount) {
        this.roomStatus = roomStatus;
        this.priceOfRoom = priceOfRoom;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.starCount = starCount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }


    public int getStarCount() {
        return starCount;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }


    public double getPriceOfRoom() {
        return priceOfRoom;
    }


    public void setPriceOfRoom(double priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
    }


    @Override
    public String toString() {
        return "| RoomNumber=" + roomNumber +
                "| roomStatus=" + roomStatus +
                "| priceOfRoom=" + priceOfRoom +
                "| numberOfBeds=" + numberOfBeds +
                "| starCount=" + starCount;
    }
}

