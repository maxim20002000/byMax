package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;
import com.senlainc.homework.util.LoggerService;
import com.senlainc.homework.util.LoggerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangePriceAdditionalActionImpl implements Action {
    private static LoggerService logger = new LoggerServiceImpl();

    @Override
    public void execute() {

        try {
            System.out.println("Input id additional and price");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            int price = scanner.nextInt();
            ControllerImpl.getInstance().changePriceAdditional(id, price);
        } catch (InputMismatchException e) {
            System.out.println("Error. Check input data");
            logger.error(this, "Incorrect id/price in changePrice");
        }
    }
}
