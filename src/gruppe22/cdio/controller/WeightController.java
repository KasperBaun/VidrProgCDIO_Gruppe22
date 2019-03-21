package gruppe22.cdio.controller;

import gruppe22.cdio.business.IUserLogic;
import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.dal.dao.IUserDAO;
import gruppe22.cdio.io.IUserInterface;
import gruppe22.cdio.io.IWeight;

import java.io.IOException;

public class WeightController implements IWeightController{

    private IWeight weight;
    private IWeightLogic weightLogic;

    @Override
    public void setInterface(IWeight weight) {
        this.weight = weight;
    }

    @Override
    public void setLogic(IWeightLogic logic) {
        this.weightLogic = logic;
    }

    @Override
    public void getOperatorID() {

    }

    @Override
    public void getBatchNumber() {

    }

    @Override
    public void start() {

    }

    @Override
    public void getNetWeight() {

    }

    @Override
    public void getBruttoWeight() {

    }
}