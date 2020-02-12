package com.senlainc.homework.service;


import by.karnaukh.maksim.lib.annotation.ConfigClass;
import by.karnaukh.maksim.lib.annotation.ConfigProperty;
import com.senlainc.homework.entity.History;
import com.senlainc.homework.repository.HistoryRepositoryImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.Comparator;
import java.util.List;

@ConfigClass
public class HistoryServiceImpl implements HistoryService {
    private static LoggerService logger;

    @ConfigProperty(configName = "showHistoryLimit")
    private int historyLimit;

    public HistoryServiceImpl() {
        logger = new LoggerServiceImpl();
    }

    @Override
    public void showLastResidents(int idRoom) {
        try {
            System.out.println("-----------------------History---------------------");
            /*File file = new File("./data.property");
            file.getAbsolutePath();
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            int showHistoryLimit = Integer.parseInt(properties.getProperty("showHistoryLimit"));*/
            List<History> historyList = HistoryRepositoryImpl.getHistoryRepository().getHistoryListForRoom(idRoom);
            historyList
                    .stream()
                    .sorted(Comparator.comparing(History::getEvictDate).reversed())
                    .limit(historyLimit)
                    .forEach(history -> System.out.println(history.toString()));
            System.out.println("----------------------------------------------------");
        } catch (NumberFormatException e) {
            logger.error(this, "Wrong Int number in property");
        }

    }

    public int getHistoryLimit() {
        return historyLimit;
    }
}

