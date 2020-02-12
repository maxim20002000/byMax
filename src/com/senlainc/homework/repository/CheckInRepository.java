package com.senlainc.homework.repository;

import com.senlainc.homework.entity.CheckIn;

import java.util.List;

public interface CheckInRepository {
    void checkInPerson(CheckIn checkIn);

    CheckIn getCheckIn(int id);

    int getSize();

    void removeCheckInById(int id);

    List<CheckIn> getCheckInList();

    void setCheckInList(List<CheckIn> checkIn);

}
