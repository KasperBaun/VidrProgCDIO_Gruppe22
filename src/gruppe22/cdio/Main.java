package gruppe22.cdio;

import gruppe22.cdio.business.*;
import gruppe22.cdio.controller.*;
import gruppe22.cdio.io.*;
import gruppe22.cdio.dal.IUserDAO.DALException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DALException, IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tast 1 for brugeradministration");
        System.out.println("Tast 2 for afvegning på vægt");

        int input = scanner.nextInt();

        if (input == 1) {
            IUserLogic logic = new UserLogic();
            IUserInterface tui = new TUI();
            IController controller = new UserController();
            controller.setLogic(logic);
            controller.setInterface(tui);
            controller.start();
        }
        else if (input == 2) {
            IWeightLogic logic = new WeightLogic();
            IWeight weight = new MettlerWeight();
            IController controller = new WeightController();
        }

    }
}