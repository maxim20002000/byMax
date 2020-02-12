package com.senlainc.homework.UI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static Menu menuInstance;
    private String name;
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
    }

    public static Menu getMenu() {
        if (menuInstance == null) {
            menuInstance = new Menu();
        }
        return menuInstance;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public MenuItem getMenuItemById(int id) {
        return menuItems.get(id);
    }

    public String getName() {
        return name;
    }
}
