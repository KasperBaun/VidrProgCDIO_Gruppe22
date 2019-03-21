package gruppe22.cdio.controller;

import gruppe22.cdio.business.IUserLogic;
import gruppe22.cdio.business.IWeightLogic;
import gruppe22.cdio.dal.dao.IBatchDAO;
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
    public void start() throws IBatchDAO.DALException {
        String material;
        double netweight;
        double bruttoweight;
        String input = weight.sendAndAwaitReturn("Indtast op. nummer");
        String operatorNumber = SubStringGenerator(input, "\"", "\"", 1);
        UserDTO user = null;

        try {
            user = userLogic.getUser(Integer.parseInt(operatorNumber));
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }

        input = weight.sendAndAwaitReturn(user.getUserName() + " - Er dette korrekt (1:Y, 2:N)");
        if (SubStringGenerator(input, "\"", "\"", 1).equals("1")) {
            input = weight.sendAndAwaitReturn("Indtast materialenummer: ");
            int batchid =  Integer.parseInt(SubStringGenerator(input, "\"", "\"", 1));
            material = getMaterial(batchid);
            weight.sendAndAwaitReturn("Vaegten skal vaere ubelastet.");
            weight.tareWeight();
            weight.sendAndAwaitReturn("Placer venligst tara på vaegten.");
            double taraweight = Double.parseDouble(SubStringGenerator(weight.readWeight(), "S", " ", 9));
            weight.tareWeight();
            weight.sendAndAwaitReturn("Placer netto på vaegten");
            netweight = getNetWeight(weight.readWeight());
            weight.tareWeight();
            weight.sendAndAwaitReturn("Fjern venligst brutto fra vaegten");
            bruttoweight = getBruttoWeight(netweight, weight.readWeight());
            input = weight.sendAndAwaitReturn("OK (1) eller Kasseret (2) ?");
            if (SubStringGenerator(input, "\"", "\"", 1).equals("1")) {
                saveBatch(taraweight, netweight, bruttoweight, batchid, user);
            }
            else {
                start();
            }
        }
        else {
            start();
        }

    }

    @Override
    public String getMaterial(int batchnumber) {
        return weightLogic.getMaterial(batchnumber).getMaterial();
    }

    @Override
    public double getNetWeight(String netweightresult) {
        double netweight = Double.parseDouble(SubStringGenerator(netweightresult, "S", " ", 9));
        return netweight;
    }

    @Override
    public double getBruttoWeight(double net, String bruttoweightresult) {
        double bruttoweight = net + Double.parseDouble(SubStringGenerator(bruttoweightresult, "S", " ", 9));
        return bruttoweight;


    }

    private String SubStringGenerator(String source, String s, String e, int offset) {
        int opening = source.indexOf(s) + offset;
        int closing = source.indexOf(e, opening + 1);

        String returnString = source.substring(opening, closing);
        return returnString;
    }

    public void saveBatch(double tareweight, double netweight, double bruttoweight, int batchid, UserDTO user) throws IBatchDAO.DALException {
        weightLogic.saveBatch(tareweight, netweight, bruttoweight, batchid, user);
    }
}