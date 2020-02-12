package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowLastResidentsActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input room number");
            ControllerImpl.getInstance().showLastResidents(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Input exception");
        }
    }
}
