package gruppe22.cdio.controller;

import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.io.IWeight;

public interface IWeightController {
    public void setInterface(IWeight weight);
    public void setLogic(IWeightLogic logic);
    public void getOperatorID();
    public void getBatchNumber();
    public void start();
    public void getNetWeight();
    public void getBruttoWeight();
    


}
