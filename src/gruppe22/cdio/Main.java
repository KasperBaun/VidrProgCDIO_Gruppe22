package gruppe22.cdio;

import gruppe22.cdio.business.BusinessLogic;
import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.controller.Controller;
import gruppe22.cdio.controller.IController;
import gruppe22.cdio.dal.IUserDAO.DALException;
import gruppe22.cdio.ui.IUserInterface;
import gruppe22.cdio.ui.TUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws DALException, IOException, ClassNotFoundException {
        IBusinessLogic logic = new BusinessLogic();
        IUserInterface tui = new TUI();
        IController controller = new Controller();
        controller.setLogic(logic);
        controller.setInterface(tui);
        controller.start();
    }
}