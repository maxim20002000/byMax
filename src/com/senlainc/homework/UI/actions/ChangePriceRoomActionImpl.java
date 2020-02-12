package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangePriceRoomActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            System.out.println("Input price: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input room number: ");
            double price = scanner.nextDouble();
            int roomNumber = scanner.nextInt();
            ControllerImpl.getInstance().changePriceRoom(roomNumber, price);
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Incorrect price/roomNumber in change price room");
        }
    }
}
