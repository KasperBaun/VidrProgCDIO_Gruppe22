package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.ui.IUserInterface;

public class Controller implements IController {
    private IUserInterface ui;
    private IBusinessLogic logic;


    @Override
    public void setInterface(IUserInterface ui) {
    this.ui = ui;

    }

    @Override
    public void setLogic(IBusinessLogic logic) {
    this.logic = logic;
    }

    @Override
    public void start() {
    ui.printLine("Velkommen");
    ui.printLine("Indtast bruger-id:");
    int userId = Integer.parseInt(ui.getInput());

    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showMenu() {

    }

    @Override
    public void showSubMenu() {

    }
}
