package com.senlainc.homework.UI;

import com.senlainc.homework.UI.actions.Action;

public class MenuItem {
    private String title;
    private Menu nextMenu;
    private Action action;


    public MenuItem(String title, Menu nextMenu) {
        this.title = title;
        this.nextMenu = nextMenu;
    }

    public MenuItem(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasNextMenu() {
        return nextMenu != null;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void executeAction() {
        action.execute();
    }


}
