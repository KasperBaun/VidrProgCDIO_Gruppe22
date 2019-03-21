package gruppe22.cdio.controller;

import gruppe22.cdio.business.IUserLogic;
import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.dal.dao.IUserDAO;
import gruppe22.cdio.dal.dao.UserDAO;
import gruppe22.cdio.dal.dto.UserDTO;
import gruppe22.cdio.io.IUserInterface;
import gruppe22.cdio.io.IWeight;

import java.io.IOException;
import java.util.StringTokenizer;

public class WeightController implements IWeightController{

    private IWeight weight;
    private IWeightLogic weightLogic;
    private IUserLogic userLogic;

    @Override
    public void setInterface(IWeight weight) {
        this.weight = weight;
    }

    @Override
    public void setWeightLogic(IWeightLogic logic) {
        this.weightLogic = logic;
    }

    @Override
    public void setUserLogic(IUserLogic userLogic) {
        this.userLogic = userLogic;
    }

    @Override
    public void getOperatorID() {

    }

    @Override
    public void getBatchNumber() {

    }

    @Override
    public void start() {
        String input = weight.sendAndAwaitReturn("Indtast op. nummer");

        String operatorNumber = test(input,"\"", "\"", "");

        System.out.println(operatorNumber);

        try {
            UserDTO user = userLogic.getUser(Integer.parseInt(operatorNumber));
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }

        System.out.println(userLogic.toString());
    }

    @Override
    public void getNetWeight() {

    }

    @Override
    public void getBruttoWeight() {

    }

    private String test(String test, String s, String e, String delimeter) {
        int opening = test.indexOf(s);
        int closing = test.indexOf(e, opening + 1);

        StringTokenizer tokenizer = new StringTokenizer(test, "");
        return test;
    }
}