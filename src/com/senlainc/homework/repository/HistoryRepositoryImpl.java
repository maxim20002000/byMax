package com.senlainc.homework.repository;

import com.senlainc.homework.entity.History;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryRepositoryImpl implements HistoryRepository, Serializable {
    private static HistoryRepositoryImpl historyRepositoryInstance;
    private List<History> historyList;

    private HistoryRepositoryImpl() {
        this.historyList = new ArrayList<>();
    }

    public static HistoryRepositoryImpl getHistoryRepository() {
        if (historyRepositoryInstance == null) {
            historyRepositoryInstance = new HistoryRepositoryImpl();
        }
        return historyRepositoryInstance;
    }


    @Override
    public void addToHistory(History history) {
        historyList.add(history);
    }


    @Override
    public List<History> getHistoryListForRoom(int roomNumber) {
        return historyList
                .stream()
                .filter(history -> history.getRoom().getRoomNumber() == roomNumber)
                .collect(Collectors.toList());
    }

    @Override
    public List<History> getHistoryList() {
        return historyList;
    }

    @Override
    public void setHistoryList(List<History> list) {
        historyList = list;
    }
}
