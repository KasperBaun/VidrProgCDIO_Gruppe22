package gruppe22.cdio.controller;

import gruppe22.cdio.business.IUserLogic;
import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.io.IWeight;

public interface IWeightController {
    public void setInterface(IWeight weight);
    public void setWeightLogic(IWeightLogic weightLogic);
    public void setUserLogic(IUserLogic userLogic);
    public void getOperatorID();
    public void getBatchNumber();
    public void start();
    public void getNetWeight();
    public void getBruttoWeight();
    


}
