package com.senlainc.homework.UI;

import com.senlainc.homework.UI.actions.AddAdditionalActionImpl;
import com.senlainc.homework.UI.actions.AddAdditionalToPersonActionImpl;
import com.senlainc.homework.UI.actions.AddPersonActionImpl;
import com.senlainc.homework.UI.actions.AddRoomActionImpl;
import com.senlainc.homework.UI.actions.CalculateCostOfLivingActionImpl;
import com.senlainc.homework.UI.actions.ChangePriceAdditionalActionImpl;
import com.senlainc.homework.UI.actions.ChangePriceRoomActionImpl;
import com.senlainc.homework.UI.actions.ChangeRoomStatusActionImpl;
import com.senlainc.homework.UI.actions.CheckInPersonActionImpl;
import com.senlainc.homework.UI.actions.EvictFromRoomActionImpl;
import com.senlainc.homework.UI.actions.ShowAdditionalImpl;
import com.senlainc.homework.UI.actions.ShowCheckInActionImpl;
import com.senlainc.homework.UI.actions.ShowFreeRoomListActionImpl;
import com.senlainc.homework.UI.actions.ShowFreeRoomsByDateActionImpl;
import com.senlainc.homework.UI.actions.ShowLastResidentsActionImpl;
import com.senlainc.homework.UI.actions.ShowNumberOfFreeRoomActionImpl;
import com.senlainc.homework.UI.actions.ShowNumberOfResidentActionImpl;
import com.senlainc.homework.UI.actions.ShowPersonAdditionalServiceActionImpl;
import com.senlainc.homework.UI.actions.ShowPersonListByIdActionImpl;
import com.senlainc.homework.UI.actions.ShowRoomDetailsActionImpl;
import com.senlainc.homework.UI.actions.ShowRoomListActionImpl;
import com.senlainc.homework.UI.actions.SortCheckInByEvictDayActionImpl;
import com.senlainc.homework.UI.actions.SortCheckInByLastNameActionImpl;
import com.senlainc.homework.UI.actions.SortFreeRoomByNumberOfBedActionImpl;
import com.senlainc.homework.UI.actions.SortFreeRoomByPriceActionImpl;
import com.senlainc.homework.UI.actions.SortFreeRoomByStarCountActionImpl;
import com.senlainc.homework.UI.actions.SortPersonAdditionalListByDateActionImpl;
import com.senlainc.homework.UI.actions.SortPersonAdditionalListByPriceActionImpl;
import com.senlainc.homework.UI.actions.SortRoomByNumberOfBedActionImpl;
import com.senlainc.homework.UI.actions.SortRoomByPriceActionImpl;
import com.senlainc.homework.UI.actions.SortRoomByStarCountActionImpl;
import com.senlainc.homework.UI.actions.UpdateFreeRoomActionImpl;

public class Builder {
    private static Builder builderInstance;
    private Menu rootMenu;
    private Menu roomMenu;
    private Menu personMenu;
    private Menu checkInMenu;
    private Menu historyMenu;
    private Menu additionalMenu;

    private Builder() {
        this.rootMenu = new Menu("Root Menu");
        this.additionalMenu = new Menu("Additional menu");
        this.checkInMenu = new Menu("CheckIn menu");
        this.historyMenu = new Menu("History menu");
        this.personMenu = new Menu("Person menu");
        this.roomMenu = new Menu("Room menu");
    }

    public static Builder getBuilder() {
        if (builderInstance == null) {
            builderInstance = new Builder();
        }
        return builderInstance;
    }

    public void buildRootMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Room menu", roomMenu);
        rootMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Person menu", personMenu);
        rootMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("CheckIn menu", checkInMenu);
        rootMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("History menu", historyMenu);
        rootMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Additional service menu", additionalMenu);
        rootMenu.addMenuItem(menuItem);

    }

    public void buildRoomMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Show room list", new ShowRoomListActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Add new room", new AddRoomActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Change room price", new ChangePriceRoomActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Change room status", new ChangeRoomStatusActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show free room list", new ShowFreeRoomListActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Update free room list", new UpdateFreeRoomActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show number of free room", new ShowNumberOfFreeRoomActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Free Room By Number Of Bed ", new SortFreeRoomByNumberOfBedActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Free Room By Price ", new SortFreeRoomByPriceActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Free Room By star count", new SortFreeRoomByStarCountActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Room By number of bed", new SortRoomByNumberOfBedActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Room By price", new SortRoomByPriceActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Room By star count", new SortRoomByStarCountActionImpl());
        roomMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show room details", new ShowRoomDetailsActionImpl());
        roomMenu.addMenuItem(menuItem);

    }

    public void buildAdditionalMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Add additional service", new AddAdditionalActionImpl());
        additionalMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Change price additional service", new ChangePriceAdditionalActionImpl());
        additionalMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show additional service", new ShowAdditionalImpl());
        additionalMenu.addMenuItem(menuItem);
    }

    public void buildPersonMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Add person", new AddPersonActionImpl());
        personMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show person list", new ShowPersonListByIdActionImpl());
        personMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Add additional to person ", new AddAdditionalToPersonActionImpl());
        personMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show additional for person ", new ShowPersonAdditionalServiceActionImpl());
        personMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Person Additional List By Date ", new SortPersonAdditionalListByDateActionImpl());
        personMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort Person Additional List By Price ", new SortPersonAdditionalListByPriceActionImpl());
        personMenu.addMenuItem(menuItem);


    }

    public void buildHistoryMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Show last residents", new ShowLastResidentsActionImpl());
        historyMenu.addMenuItem(menuItem);
    }

    public void buildCheckInMenu() {
        MenuItem menuItem;

        menuItem = new MenuItem("Check in person", new CheckInPersonActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show check-in list", new ShowCheckInActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Evict from room", new EvictFromRoomActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort list by last name", new SortCheckInByLastNameActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Sort list by evict date", new SortCheckInByEvictDayActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show count of resident", new ShowNumberOfResidentActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Show free room by date", new ShowFreeRoomsByDateActionImpl());
        checkInMenu.addMenuItem(menuItem);

        menuItem = new MenuItem("Calculate cost of living", new CalculateCostOfLivingActionImpl());
        checkInMenu.addMenuItem(menuItem);


    }


    public Menu getRootMenu() {
        return rootMenu;
    }


}
