package gruppe22.cdio.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import gruppe22.cdio.business.IUserLogic;
import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.dal.dao.IUserDAO;
import gruppe22.cdio.dal.dao.UserDAO;
import gruppe22.cdio.dal.dto.MaterialDTO;
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
        String operatorNumber = SubStringGenerator(input,"\"", "\"");
        System.out.println(operatorNumber);
        UserDTO user = null;

        try {
            user = userLogic.getUser(Integer.parseInt(operatorNumber));
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }

        input = weight.sendAndAwaitReturn(user.getUserName() + " Er dette korrekt (1:Y, 2:N)");
        if (input == "1") {
            input = weight.sendAndAwaitReturn("Indtast batch nummer (1000 - 9999)");
        }
        else {
            start();
        }

    }

    public String getMaterial(int batchnumber) {
        return weightLogic.getMaterial(batchnumber).getMaterial();
    }

    @Override
    public void getNetWeight() {

    }

    @Override
    public void getBruttoWeight() {

    }

    private String SubStringGenerator(String source, String s, String e) {
        int opening = source.indexOf(s) + 1;
        int closing = source.indexOf(e, opening + 1);

        return source.substring(opening, closing);
    }
}