package com.senlainc.homework.service;

import by.karnaukh.maksim.lib.annotation.ConfigClass;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.repository.AdditionalRepositoryImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.List;

@ConfigClass
public class AdditionalServiceImpl implements AdditionalService {
    private static LoggerService logger;

    public AdditionalServiceImpl() {
        logger = new LoggerServiceImpl();
    }

    @Override
    public void addAdditional(Additional additional) {
        AdditionalRepositoryImpl.getAdditionalRepository().addAdditional(additional);
    }

    @Override
    public void changePriceAdditional(int idAdditional, double price) {
        try {
            AdditionalRepositoryImpl.getAdditionalRepository().getAdditionalById(idAdditional).setPrice(price);
            System.out.println("**Additional service price changed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect id additional service");
            logger.error(this, "IOB/Incorrect id additional");
        }
    }

    @Override
    public void showAdditionalList() {
        List<Additional> additionals = AdditionalRepositoryImpl.getAdditionalRepository().getAdditionalList();
        System.out.println("------------Additional list--------------------------------------------------");
        additionals.forEach(additional -> System.out.println(additional.toString()));
        System.out.println("-----------------------------------------------------------------------");
    }
}
