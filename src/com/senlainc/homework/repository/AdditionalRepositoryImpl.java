package com.senlainc.homework.repository;

import com.senlainc.homework.entity.Additional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdditionalRepositoryImpl implements AdditionalRepository, Serializable {

    private static AdditionalRepositoryImpl additionalRepositoryInstance;
    private List<Additional> additionalList;

    private AdditionalRepositoryImpl() {
        this.additionalList = new ArrayList<>();
    }

    public static AdditionalRepositoryImpl getAdditionalRepository() {
        if (additionalRepositoryInstance == null) {
            additionalRepositoryInstance = new AdditionalRepositoryImpl();
        }
        return additionalRepositoryInstance;
    }


    @Override
    public void addAdditional(Additional additional) {
        additionalList.add(additional);
        System.out.println("Additional service successfully added");
    }


    @Override
    public Additional getAdditionalById(int id) {
        return additionalList.get(id);
    }


    @Override
    public List<Additional> getAdditionalList() {
        return additionalList;
    }

    @Override
    public void setAdditionalList(List<Additional> list) {
        additionalList = list;
    }
}
