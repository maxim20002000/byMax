package com.senlainc.homework.UI;

import java.util.List;

public class Navigator {
    private static Navigator navigatorInstance;
    private Menu currentMenu;

    public Navigator() {
        this.currentMenu = Builder.getBuilder().getRootMenu();
    }

    public static Navigator getNavigatorInstance() {
        if (navigatorInstance == null) {
            navigatorInstance = new Navigator();
        }
        return navigatorInstance;
    }

    public void printMenu() {
        int i = 0;
        System.out.println("***Current menu -- " + currentMenu.getName() + " ***");
        List<MenuItem> menuItems = currentMenu.getMenuItems();
        for (MenuItem menuItem : menuItems) {
            System.out.println(i + " " + menuItem.getTitle());
            i++;
        }
        System.out.println("********************************");

    }


    public boolean navigate(int selectPosition) {
        boolean stopIndicator = true;
        if (selectPosition == -1) {
            if (currentMenu == Builder.getBuilder().getRootMenu()) {
                stopIndicator = false;
                return stopIndicator;
            }
            currentMenu = Builder.getBuilder().getRootMenu();
        } else {
            MenuItem menuItem = currentMenu.getMenuItemById(selectPosition);
            if (menuItem.hasNextMenu()) {
                currentMenu = menuItem.getNextMenu();
            } else {
                menuItem.executeAction();
            }
        }

        return stopIndicator;
    }


}
