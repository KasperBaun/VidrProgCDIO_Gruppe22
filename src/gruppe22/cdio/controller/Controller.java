package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.ui.IUserInterface;

public class Controller implements IController {
    private IUserInterface ui;
    private IBusinessLogic logic;

    @Override
    public void setInterface(IUserInterface ui) {

    }

    @Override
    public void setLogic(IBusinessLogic logic) {

    }

    @Override
    public void start() {

    }
}
