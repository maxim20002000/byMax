package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.entity.RoomStatus;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeRoomStatusActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            RoomStatus roomStatus = RoomStatus.FREE;
            System.out.println("Write room number and status (F - FREE / B - BUSY / R - REPAIRED ): ");
            Scanner scanner = new Scanner(System.in);
            int roomNumber = scanner.nextInt();
            String letter = scanner.next();
            switch (letter) {
                case ("F"):
                    roomStatus = RoomStatus.FREE;
                    break;
                case ("B"):
                    roomStatus = RoomStatus.BUSY;
                    break;
                case ("R"):
                    roomStatus = RoomStatus.REPAIRED;
                    break;
                default:
                    System.out.println("Wrong letter!");
            }
            ControllerImpl.getInstance().changeRoomStatus(roomNumber, roomStatus);
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Error input");
        }
    }
}
