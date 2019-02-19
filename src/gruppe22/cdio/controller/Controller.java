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
    logic.setUserDTO(Integer.parseInt(ui.getInput()));
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
    ui.printLine("\nIndtast valg:");
    int choice = Integer.parseInt(ui.getInput());
    ui.clearScreen();
    showSubMenu(choice);
    }

    @Override
    public void showSubMenu(int userChoice) {
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
            ui.printLine("Opret ny bruger");
            ui.printLine("\nIndtast brugernavn:");
            String userName = ui.getInput();
            ui.printLine("\nIndtast initialer:");
            String ini = ui.getInput();

        } else {
            showPermissionDenied();
        }
    }

    private void subListUsers() {
        ui.printLine("Brugere:\n");
        ui.printList(logic.getUserList());
        ui.printLine("\nTast enter for at gå til hovedmenu.");
        ui.getInput();
        showMenu();
    }

    private void subCloseProgram() {
        System.exit(0);
    }

    private void showUserContext() {
        ui.printLine("Du er logget på som: " + logic.getUsername()
                + ", ID: " + logic.getUserId()
                + ", Rolle: " + logic.getRole()
                + "\n");
    }

    private void showPermissionDenied() {
        ui.clearScreen();
        ui.printLine("Fejl: manglende rettigheder!");
        showMenu();
    }
}
