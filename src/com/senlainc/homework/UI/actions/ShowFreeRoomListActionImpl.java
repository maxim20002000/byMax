package com.senlainc.homework.UI.actions;

import com.senlainc.homework.controller.ControllerImpl;

public class ShowFreeRoomListActionImpl implements Action {
    @Override
    public void execute() {
        ControllerImpl.getInstance().showFreeRoomList();
    }
}

