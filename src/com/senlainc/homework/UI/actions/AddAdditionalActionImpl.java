package com.senlainc.homework.UI.actions;


import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.entity.Additional;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;


public class AddAdditionalActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input name and price:");
            String name = scanner.nextLine();
            double price = scanner.nextDouble();
            ControllerImpl.getInstance().addAdditional(new Additional(name, price));
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Error with create additional");
        }

    }
}
