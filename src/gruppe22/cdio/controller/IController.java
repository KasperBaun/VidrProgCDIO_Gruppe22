package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.ui.IUserInterface;

public interface IController {

    void setInterface(IUserInterface ui);
    void setLogic(IBusinessLogic logic);
    void start() throws IUserDAO.DALException;
    void showLogin();
    void showMenu() throws IUserDAO.DALException;
    void showSubMenu(int userChoice) throws IUserDAO.DALException;

    //Todo: methods for program flow here..
}
