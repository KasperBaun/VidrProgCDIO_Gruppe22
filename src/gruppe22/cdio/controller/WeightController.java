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
        String material;
        double netweight;
        double bruttoweight;
        String input = weight.sendAndAwaitReturn("Indtast op. nummer");
        String operatorNumber = SubStringGenerator(input);
        System.out.println(operatorNumber);
        UserDTO user = null;

        try {
            user = userLogic.getUser(Integer.parseInt(operatorNumber));
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }

        input = weight.sendAndAwaitReturn(user.getUserName() + " Er dette korrekt (1:Y, 2:N)");
        if (SubStringGenerator(input).equals("1")) {
            input = weight.sendAndAwaitReturn("Indtast materiale nummer: ");
            material = getMaterial(Integer.parseInt(SubStringGenerator(input)));
            weight.sendAndAwaitReturn("Vægten skal være ubelastet.");
            weight.tareWeight();
            weight.sendAndAwaitReturn("Placer venligst tara på vægten.");
            double taraweight = Double.parseDouble(SubStringGenerator(weight.readWeight()));
            weight.tareWeight();
            weight.sendAndAwaitReturn("Placer netto på vægten");
            netweight = getNetWeight(weight.readWeight());
            weight.tareWeight();
            weight.sendAndAwaitReturn("Fjern venligst brutto fra vægten");
            bruttoweight = getBruttoWeight(netweight, weight.readWeight());
            input = weight.sendAndAwaitReturn("OK (1) eller Kasseret (2) ?");
            if (SubStringGenerator(input).equals("1")) {
                saveBatch(taraweight, netweight, bruttoweight);
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
        double netweight = Double.parseDouble(SubStringGenerator(netweightresult));
        return netweight;
    }

    @Override
    public double getBruttoWeight(double net, String bruttoweightresult) {
        double bruttoweight = net - Double.parseDouble(SubStringGenerator(bruttoweightresult));
        return bruttoweight * -1.0;


    }

    private String SubStringGenerator(String source) {
        int opening = source.indexOf("\"") + 1;
        int closing = source.indexOf("\"", opening + 1);

        String returnString = source.substring(opening, closing);
        return returnString;
    }

    public void saveBatch(double tareweight, double netweight, double bruttoweight) {
        weightLogic.saveBatch(tareweight, netweight, bruttoweight);
    }
}