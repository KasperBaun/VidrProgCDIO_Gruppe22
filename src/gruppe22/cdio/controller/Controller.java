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
    ui.clearScreen();
    showMenu();
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showMenu() {
        showUserContext();
    ui.printLine("Hovedmenu");
    ui.printLine("1. Opret ny bruger");
    ui.printLine("2. List brugere");
    ui.printLine("3. Ret bruger");
    ui.printLine("4. Slet bruger");
    ui.printLine("5. Afslut program");
    int choice = Integer.parseInt(ui.getInput());
    showSubMenu(choice);
    }

    @Override
    public void showSubMenu(int userChoice) {
        ui.clearScreen();
        showUserContext();
        switch (userChoice){
            case 1:
                subCreateUser();
                break;
            case 2:
                subListUsers();
                break;
            case 5:
                subCloseProgram();
                break;
        }
    }

    private void subCreateUser() {
        if (logic.getPermissionLevel() == 1) {

        } else {
            showPermissionDenied();
        }
    }

    private void subListUsers() {
        ui.printList(logic.getUserList());
    }

    private void subCloseProgram() {
        System.exit(0);
    }

    private void showUserContext() {
        ui.printLine("Du er logget på som:");
        ui.printLine("Navn"   + logic.getUsername());
        ui.printLine("ID:"    + logic.getUserId());
        ui.printLine("Rolle:" + logic.getRole());
    }

    private void showPermissionDenied() {
        ui.clearScreen();
        ui.printLine("Du har ikke de nødvendige rettigheder.");
        showMenu();
    }
}
