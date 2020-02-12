package com.senlainc.homework.repository;

import com.senlainc.homework.entity.History;

import java.util.List;

public interface HistoryRepository {
    void addToHistory(History history);

    List<History> getHistoryListForRoom(int roomNumber);

    List<History> getHistoryList();

    void setHistoryList(List<History> list);
}
