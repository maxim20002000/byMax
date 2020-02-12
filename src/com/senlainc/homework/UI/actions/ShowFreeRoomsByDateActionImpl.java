package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowFreeRoomsByDateActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            System.out.println("Input date (DD MM YYYY): ");
            Scanner scanner = new Scanner(System.in);
            int dd = scanner.nextInt();
            int mm = scanner.nextInt() + 1;
            int yyyy = scanner.nextInt();
            Calendar calendar = new GregorianCalendar(yyyy, mm, dd);
            ControllerImpl.getInstance().showFreeRoomsByDate(calendar);
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Input exception");
        } catch (Exception e) {
            System.out.println("Error. Check date");
            logger.error(this, "Other exception");
        }
    }
}
