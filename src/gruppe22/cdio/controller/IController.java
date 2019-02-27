package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.ui.IUserInterface;

import java.io.IOException;

public interface IController {

    void setInterface(IUserInterface ui);
    void setLogic(IBusinessLogic logic);
    void start() throws IUserDAO.DALException, IOException;
    void showLogin();
    void showMenu() throws IUserDAO.DALException, IOException;
    void showSubMenu(int userChoice) throws IUserDAO.DALException, IOException;

    //Todo: methods for program flow here..
}
