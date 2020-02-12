package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddAdditionalToPersonActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            System.out.println("Input id additional and id person");
            Scanner scanner = new Scanner(System.in);
            ControllerImpl.getInstance().addAdditionalToPerson(scanner.nextInt(), scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Error with adding additional to person");
        }
    }
}
