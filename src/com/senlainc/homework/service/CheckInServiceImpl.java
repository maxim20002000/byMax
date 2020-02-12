package com.senlainc.homework.service;

import by.karnaukh.maksim.lib.annotation.ConfigClass;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.entity.CheckIn;
import com.senlainc.homework.entity.History;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.repository.CheckInRepositoryImpl;
import com.senlainc.homework.repository.HistoryRepositoryImpl;
import com.senlainc.homework.repository.PersonRepositoryImpl;
import com.senlainc.homework.repository.RoomRepositoryImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@ConfigClass
public class CheckInServiceImpl implements CheckInService {
    private static LoggerService logger;

    public CheckInServiceImpl() {
        logger = new LoggerServiceImpl();
    }

    @Override
    public void checkInPerson(int idPerson, int roomNumber, int days) {
        try {
            Calendar evictDate = new GregorianCalendar();
            evictDate.add(Calendar.DAY_OF_MONTH, days);
            Room room = RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber);
            if (room.getRoomStatus() == RoomStatus.FREE) {
                CheckInRepositoryImpl.getCheckInRepository().checkInPerson(new CheckIn(roomNumber, idPerson, evictDate));
                room.setRoomStatus(RoomStatus.BUSY);
                System.out.println("Successfully checkin");
            } else {
                System.out.println("Room not available, try another");
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person / room Number");
            logger.error(this, "NPE/Incorrect id person or roomNumber");
        }
    }

    @Override
    public void evictFromRoom(int roomNumber) {
        try {
            int sizeList = CheckInRepositoryImpl.getCheckInRepository().getSize();
            for (int i = 0; i < sizeList; i++) {
                CheckIn checkIn = CheckInRepositoryImpl.getCheckInRepository().getCheckIn(i);
                if (checkIn.getRoomNumber() == roomNumber) {
                    Room room = RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber);
                    int idPerson = checkIn.getIdPerson();
                    Person person = PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson);
                    Calendar checkInDate = checkIn.getCheckinDate();
                    Calendar evictDate = new GregorianCalendar();

                    History history = new History(room, person, checkInDate, evictDate);
                    HistoryRepositoryImpl.getHistoryRepository().addToHistory(history);
                    System.out.println("//////////////////////////////////");
                    System.out.println("**Add new info to history**");

                    RoomRepositoryImpl.getRoomRepository().getRoomByRoomNumber(roomNumber).setRoomStatus(RoomStatus.FREE);
                    CheckInRepositoryImpl.getCheckInRepository().removeCheckInById(i);
                    PersonRepositoryImpl.getPersonRepository().getPersonById(idPerson).cleanAdditional();
                    System.out.println("**Evict from room successfully**");
                    System.out.println("//////////////////////////////////");
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect room number");
            logger.error(this, "NPE/Incorrect room number");
        }
    }

    @Override
    public void showCheckIn() {
        List<CheckIn> checkInList = CheckInRepositoryImpl.getCheckInRepository().getCheckInList();
        System.out.println("-------------------------Check in list---------------------------");
        checkInList.forEach(checkIn -> System.out.println(checkIn.toString()));
        System.out.println("-----------------------------------------------------------------");
    }

    @Override
    public void sortByLastName() {
        List<CheckIn> nonSortedList = CheckInRepositoryImpl.getCheckInRepository().getCheckInList();
        nonSortedList = nonSortedList
                .stream()
                .sorted(Comparator.comparing(o -> PersonRepositoryImpl.getPersonRepository().getPersonById(o.getIdPerson()).getLastName()))
                .collect(Collectors.toList());
        CheckInRepositoryImpl.getCheckInRepository().setCheckInList(nonSortedList);
        System.out.println("CheckIn sorted By Last Name person");
    }

    @Override
    public void sortByEvictDay() {
        List<CheckIn> nonSortedList = CheckInRepositoryImpl.getCheckInRepository().getCheckInList();
        nonSortedList = nonSortedList
                .stream()
                .sorted(Comparator.comparing(CheckIn::getEvictDate))
                .collect(Collectors.toList());
        CheckInRepositoryImpl.getCheckInRepository().setCheckInList(nonSortedList);
        System.out.println("CheckIn sorted By evict day");
    }

    @Override
    public void showNumberOfResident() {
        System.out.println("Number of resident = " + CheckInRepositoryImpl.getCheckInRepository().getSize());
    }

    @Override
    public void showFreeRoomsByDate(Calendar date) {
        List<CheckIn> checkInList = CheckInRepositoryImpl.getCheckInRepository().getCheckInList();
        System.out.println("Free room number after: " + date.getTime());
        checkInList.stream()
                .filter(checkIn -> date.after(checkIn.getEvictDate()))
                .forEach(checkIn -> System.out.println(checkIn.getRoomNumber()));

    }

    @Override
    public void calculateCostOfLiving(int idPerson) {
        try {
            int size = CheckInRepositoryImpl.getCheckInRepository().getSize();
            for (int i = 0; i < size; i++) {
                CheckIn checkIn = CheckInRepositoryImpl.getCheckInRepository().getCheckIn(i);
                if (checkIn.getIdPerson() == idPerson) {
                    int days = checkIn.getEvictDate().get(Calendar.DAY_OF_MONTH)
                            - checkIn.getCheckinDate().get(Calendar.DAY_OF_MONTH);
                    double costLiving = days * RoomRepositoryImpl.getRoomRepository().
                            getRoomByRoomNumber(checkIn.getRoomNumber()).getPriceOfRoom();

                    List<Additional> additionals = PersonRepositoryImpl
                            .getPersonRepository()
                            .getPersonById(idPerson).getAdditionalList();
                    double costService = 0;
                    for (Additional additional : additionals) {
                        costService += additional.getPrice();
                    }
                    System.out.println("Cost of living: " + costLiving + "| Cost additional service: " + costService +
                            "| Total: " + (costLiving + costService));
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect id person");
            logger.error(this, "NPE/Incorrect id person");
        }
    }
}
