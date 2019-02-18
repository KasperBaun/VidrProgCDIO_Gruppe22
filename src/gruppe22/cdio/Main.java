package gruppe22.cdio;
import java.util.List;
import gruppe22.cdio.business.IBusinessLogic;
import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDAO;
import gruppe22.cdio.dal.UserDTO;
import gruppe22.cdio.ui.IUserInterface;

public class Main {

    public static void main(String[] args) {
        IUserDAO userDao = new UserDAO();
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
        }
    }
}
