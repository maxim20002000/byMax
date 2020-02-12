package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortPersonAdditionalListByDateActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {

        try {
            System.out.println("Input id person: ");
            Scanner scanner = new Scanner(System.in);
            ControllerImpl.getInstance().sortPersonAdditionalListByDate(scanner.nextInt());
        } catch (InputMismatchException e) {
            logger.error(this, "Input exception");
        }
    }
}
