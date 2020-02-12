package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.entity.Person;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddPersonActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input 1st and last name, phone number, passport number");
            ControllerImpl.getInstance().addPerson(new Person(scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine()));
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Error with creating person");
        }
    }
}
