package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Additional;

import java.util.List;

public interface AdditionalRepository {
    void addAdditional(Additional additional);

    Additional getAdditionalById(int id);

    List<Additional> getAdditionalList();

    void setAdditionalList(List<Additional> list);
}
