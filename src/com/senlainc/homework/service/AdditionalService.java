package com.senlainc.homework.service;

import com.senlainc.homework.entity.Additional;

public interface AdditionalService {
    void addAdditional(Additional additional);

    void changePriceAdditional(int idAdditional, double price);

    void showAdditionalList();
}
