package gruppe22.cdio;

import gruppe22.cdio.business.*;
import gruppe22.cdio.controller.*;
import gruppe22.cdio.io.*;
import gruppe22.cdio.dal.dao.IUserDAO.DALException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DALException, IOException, ClassNotFoundException {
/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tast 1 for brugeradministration");
        System.out.println("Tast 2 for afvegning på vægt");

        int input = scanner.nextInt();

        if (input == 1) {
            IUserLogic logic = new UserLogic();
            IUserInterface tui = new TUI();
            IUserController controller = new UserController();
            controller.setLogic(logic);
            controller.setInterface(tui);
            controller.start();
        }
        else if (input == 2) {
            IWeightLogic logic = new WeightLogic();
            IWeight weight = new MettlerWeight();
            IUserController controller = new WeightController();
        }

    }
    */
    IWeight vægt = new MettlerWeight();
    IWeightController weightController = new WeightController();
    IWeightLogic logic = new WeightLogic();
    weightController.setInterface(vægt);
    weightController.setLogic(logic);

    weightController.start();

        System.out.println( vægt.readWeight());
        vægt.closeConnection();
}}