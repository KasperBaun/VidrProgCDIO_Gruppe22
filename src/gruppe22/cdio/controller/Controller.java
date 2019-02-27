package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.dal.IUserDAO;
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
    public void start() throws IUserDAO.DALException {
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
    public void showMenu() throws IUserDAO.DALException {
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
    public void showSubMenu(int userChoice) throws IUserDAO.DALException {
        showUserContext();
        switch (userChoice){
            case 1:
                subCreateUser();
                break;
            case 2:
                subListUsers();
                break;
            case 3:
                subUpdateUser();
                break;
            case 4:
                subDeleteUser();
                break;
            case 5:
                subCloseProgram();
                break;
        }
    }

    private void subCreateUser() throws IUserDAO.DALException {
        if (logic.getPermissionLevel() == 1) {
            ui.printLine("Opret ny bruger");
            ui.printLine("\nIndtast bruger-ID (11-99):");
            int userId = Integer.parseInt(ui.getInput());
            ui.printLine("\nIndtast brugernavn:");
            String userName = ui.getInput();
            ui.printLine("\nIndtast initialer:");
            String ini = ui.getInput();
            ui.printLine("\nIndtast CPR-nummer:");
            int cprNumber = Integer.parseInt(ui.getInput());
            ui.printLine("\nIndtast rolle (Admin, Pharmacist, Foreman, Operator:");
            String role = ui.getInput();
            logic.createUser(userId, userName, ini, cprNumber, role);
            ui.clearScreen();
            showMenu();
        } else {
            showPermissionDenied();
        }
    }

    private void subUpdateUser() throws IUserDAO.DALException {
        if (logic.getPermissionLevel() == 1) {
            ui.printLine("Ret bruger");
            ui.printLine("\nIndtast bruger-ID, for bruger der skal rettes (11-99):");
            int userId = Integer.parseInt(ui.getInput());

            ui.printLine("\nBruger: " + logic.getUser(userId).toString());
            ui.printLine("Indtast (nye) brugernavn:");
            String userName = ui.getInput();
            ui.printLine("\nIndtast (nye) initialer:");
            String ini = ui.getInput();
            ui.printLine("\nIndtast CPR-nummer:");
            int cprNumber = Integer.parseInt(ui.getInput());
            logic.updateUser(userId, userName, cprNumber, ini, logic.getUser(userId).getPassword(),
                    logic.getUser(userId).getRoles());
            ui.clearScreen();
            showMenu();
        } else {
            showPermissionDenied();
        }
    }

    private void subDeleteUser() throws IUserDAO.DALException {
        if (logic.getPermissionLevel() == 1) {
            ui.printLine("Slet bruger");
            ui.printLine("\nIndtast bruger-ID (11-99:");
            int id = Integer.parseInt(ui.getInput());
            logic.deleteUser(id);
            ui.clearScreen();
            showMenu();
        } else {
            showPermissionDenied();
        }
    }

    private void subListUsers() throws IUserDAO.DALException {
        ui.printLine("Brugere:\n");
        ui.printList(logic.getUserList());
        ui.printLine("\nTast 1 for at gå til hovedmenu.");
        int i = Integer.parseInt(ui.getInput());
        while (i != 1) {
            i = Integer.parseInt(ui.getInput());
        }
        ui.clearScreen();
        showMenu();
    }

    private void subCloseProgram() {
        ui.clearScreen();
        ui.printLine("Du er nu logget ud!");
        System.exit(0);
    }

    private void showUserContext() {
        ui.printLine("Du er logget på som: " + logic.getUsername()
                + ", ID: " + logic.getUserId()
                + ", Rolle: " + logic.getRole()
                + "\n");
    }

    private void showPermissionDenied() throws IUserDAO.DALException {
        ui.clearScreen();
        ui.printLine("Fejl: manglende rettigheder!");
        showMenu();
    }
}
