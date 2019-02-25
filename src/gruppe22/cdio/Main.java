package gruppe22.cdio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDAO;
import gruppe22.cdio.dal.UserDTO;
import gruppe22.cdio.ui.IUserInterface;

public class Main {

    public static void main(String[] args) {
       /* IUserDAO userDao = new UserDAO();
        IBusinessLogic logic;
        IUserInterface tui;

        List<UserDTO> users = null;
        try {
            users = userDao.getUserList();
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i));
        }*/

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        UserDAO db = new UserDAO();

        //Se en Specifik bruger fra data basen

        UserDTO user = db.getUser(2);
        System.out.println(ANSI_GREEN + "Se En Specifik Bruger Fra dataBasen \n " +ANSI_RESET+ user + " \n");

        //Rediger den samme Bruger

        user.setUserName("Henrik Audeli");
        user.setIni("CB");
            List<String> roles = new ArrayList<String>();
            roles.add("personlig Chaufør ");
            roles.add("personlig kok");
        user.setRoles(roles);
        db.updateUser(user);
        System.out.println(ANSI_GREEN + "Redigere bruger nr 2. til at være Henrik Audeli, med noget passende info \n" +ANSI_RESET+ user + "\n" );

        // henter Ham Igen fra Databasen for at se at den er opdateret. .
        user = db.getUser(2);
        System.out.println(ANSI_GREEN + "vi henter ham ud igen fra databasen for at se at den har opdateret ham \n" +ANSI_RESET+ user + "\n");

        // Se Hele Databasen bekræftning af at han eksistere bland andre.
        List<UserDTO> myUsers = db.getUserList();
        String userStringList = " ";
        for(UserDTO users: myUsers){
            userStringList = userStringList + "\n " + users.toString();
        }
        System.out.println(ANSI_GREEN + "nu ser vi på hele databasens indhold, for at se alt, men også for at vise han er der opdateret."+ANSI_RESET + userStringList + "\n" );

        // Sletter ham igen fra Tingen

        db.deleteUser(user);

        // Se Hele Databasen bekræftning af han er fjernet.
        myUsers = db.getUserList();
        userStringList = " ";
        for(UserDTO users: myUsers){
            userStringList = userStringList + "\n " + users.toString();
        }
        System.out.println(ANSI_GREEN + "så sletter vi ham fra databasen og printer hele listen ud igen for at se han mangler " +ANSI_RESET+ userStringList);

        // Laver en igen på userID = 2. sådan at man kan køre koden igen
        user.setUserName("standard");
        user.setIni("s");
        roles.clear();
        roles.add("none");
        user.setRoles(roles);
        db.createUser(user);
        System.out.println("\n"+ANSI_GREEN + " Opretter en Ny på Hans Plads så koden kan køre igen.");
    }
}
