package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.entity.Room;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddRoomActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            double priceOfRoom;
            int roomNumber;
            int numberOfBeds;
            int starCount;

            System.out.println("Input price, roomNumber, number of beds, star count");

            Scanner scanner = new Scanner(System.in);
            priceOfRoom = scanner.nextDouble();
            roomNumber = scanner.nextInt();
            numberOfBeds = scanner.nextInt();
            starCount = scanner.nextInt();
            Room room = new Room(RoomStatus.FREE, priceOfRoom, roomNumber, numberOfBeds, starCount);
            ControllerImpl.getInstance().addRoom(room);
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Error with creating room");
        }

    }
}
