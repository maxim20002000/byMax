package com.senlainc.homework.repository;

import com.senlainc.homework.entity.CheckIn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckInRepositoryImpl implements CheckInRepository, Serializable {
    private static CheckInRepositoryImpl checkInRepositoryInstance;
    private List<CheckIn> checkInList;

    private CheckInRepositoryImpl() {
        this.checkInList = new ArrayList<>();
    }

    public static CheckInRepositoryImpl getCheckInRepository() {
        if (checkInRepositoryInstance == null) {
            checkInRepositoryInstance = new CheckInRepositoryImpl();
        }
        return checkInRepositoryInstance;
    }


    @Override
    public void checkInPerson(CheckIn checkIn) {
        checkInList.add(checkIn);
    }

    @Override
    public CheckIn getCheckIn(int id) {
        return checkInList.get(id);
    }

    @Override
    public int getSize() {
        return checkInList.size();
    }

    @Override
    public void removeCheckInById(int id) {
        checkInList.remove(id);
    }

    @Override
    public List<CheckIn> getCheckInList() {
        return checkInList;
    }

    @Override
    public void setCheckInList(List<CheckIn> checkIn) {
        checkInList = checkIn;
    }

}

