package gruppe22.cdio.controller;

import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.ui.IUserInterface;

public interface IController {

    void setInterface(IUserInterface ui);
    void setLogic(IBusinessLogic logic);
    void start();

    //Todo: methods for program flow here..
}
