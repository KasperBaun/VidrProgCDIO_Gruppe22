package gruppe22.cdio;

import gruppe22.cdio.business.*;
import gruppe22.cdio.controller.*;
import gruppe22.cdio.ui.*;
import gruppe22.cdio.dal.IUserDAO.DALException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws DALException, IOException, ClassNotFoundException {
        IUserLogic logic = new UserLogic();
        IUserInterface tui = new TUI();
        IUserController controller = new UserController();
        controller.setLogic(logic);
        controller.setInterface(tui);
        controller.start();
    }
}