package com.senlainc.homework.UI;


import by.karnaukh.maksim.lib.service.AnnotationConfigService;
import by.karnaukh.maksim.lib.service.AnnotationConfigServiceImpl;
import com.senlainc.homework.controller.Controller;
import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.entity.CheckIn;
import com.senlainc.homework.entity.History;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.repository.AdditionalRepositoryImpl;
import com.senlainc.homework.repository.CheckInRepositoryImpl;
import com.senlainc.homework.repository.HistoryRepositoryImpl;
import com.senlainc.homework.repository.PersonRepositoryImpl;
import com.senlainc.homework.repository.RoomRepositoryImpl;
import com.senlainc.homework.service.SerializeService;
import com.senlainc.homework.service.SerializeServiceImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    public static void main(String[] args) {
        LoggerService logger = new LoggerServiceImpl();
        SerializeService serializeService = new SerializeServiceImpl();

        initializeBeanRegistering();
        AnnotationConfigService annotationConfigService = new AnnotationConfigServiceImpl<>();
        Controller controller = (Controller) annotationConfigService.getBean(ControllerImpl.class);

        Object object = serializeService.deserialize(RoomRepositoryImpl.getRoomRepository().getRoomList(), "RoomList");
        RoomRepositoryImpl.getRoomRepository().setRoomList((List<Room>) object);

        object = serializeService.deserialize(PersonRepositoryImpl.getPersonRepository().getPersonList(), "PersonList");
        PersonRepositoryImpl.getPersonRepository().setPersonList((List<Person>) object);

        object = serializeService.deserialize(HistoryRepositoryImpl.getHistoryRepository().getHistoryList(), "HistoryList");
        HistoryRepositoryImpl.getHistoryRepository().setHistoryList((List<History>) object);

        object = serializeService.deserialize(CheckInRepositoryImpl.getCheckInRepository().getCheckInList(), "CheckInList");
        CheckInRepositoryImpl.getCheckInRepository().setCheckInList((List<CheckIn>) object);

        object = serializeService.deserialize(AdditionalRepositoryImpl.getAdditionalRepository().getAdditionalList(), "AdditionalList");
        AdditionalRepositoryImpl.getAdditionalRepository().setAdditionalList((List<Additional>) object);


        Room room1 = null;
        Room room2 = null;
        Person person1 = null;
        Person person2 = null;
        Additional cleaning = null;
        Additional washCar = null;
        try {
            room1 = new Room(RoomStatus.FREE, 450, 123, 2, 5);
            room2 = new Room(RoomStatus.FREE, 700, 124, 3, 4);
            person1 = new Person("Maksim", "Karnaukh", "375295838280", "MC7897788");
            person2 = new Person("Ilon", "Mask", "3752988877889", "MC4855522");
            cleaning = new Additional("Cleaning room", 10);
            washCar = new Additional("Washing car", 15);
        } catch (Exception e) {
            logger.error(e, "Incorrect create objects");
        }

        controller.addRoom(room1);
        controller.addRoom(room2);
        controller.addPerson(person1);
        controller.addPerson(person2);
        controller.addAdditional(cleaning);
        controller.addAdditional(washCar);


        Builder.getBuilder().buildRootMenu();
        Builder.getBuilder().buildRoomMenu();
        Builder.getBuilder().buildAdditionalMenu();
        Builder.getBuilder().buildPersonMenu();
        Builder.getBuilder().buildHistoryMenu();
        Builder.getBuilder().buildCheckInMenu();


        try {
            boolean stopIndicator = true;
            while (stopIndicator) {
                Navigator.getNavigatorInstance().printMenu();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please input number(or -1 to up menu or stop program): ");
                int selectPosition = scanner.nextInt();
                stopIndicator = Navigator.getNavigatorInstance().navigate(selectPosition);
            }
        } catch (Exception e) {
            logger.error(e, "Main controller exception");
        }

        serializeService.serialize(PersonRepositoryImpl.getPersonRepository().getPersonList(), "PersonList");
        serializeService.serialize(RoomRepositoryImpl.getRoomRepository().getRoomList(), "RoomList");
        serializeService.serialize(HistoryRepositoryImpl.getHistoryRepository().getHistoryList(), "HistoryList");
        serializeService.serialize(CheckInRepositoryImpl.getCheckInRepository().getCheckInList(), "CheckInList");
        serializeService.serialize(AdditionalRepositoryImpl.getAdditionalRepository().getAdditionalList(), "AdditionalList");

    }

    private static void initializeBeanRegistering() {
        AnnotationConfigService annotationConfigService = new AnnotationConfigServiceImpl();
        annotationConfigService.configure("com.senlainc.homework",
                new String[]{"C:\\Users\\MAKS\\IdeaProjects\\Homework4\\data.property"});
    }

}
