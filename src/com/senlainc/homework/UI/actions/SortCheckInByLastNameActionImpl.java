package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;

public class SortCheckInByLastNameActionImpl implements Action {

    @Override
    public void execute() {
        ControllerImpl.getInstance().sortCheckInByLastName();
    }
}
