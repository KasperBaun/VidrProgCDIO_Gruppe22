package gruppe22.cdio.business;

import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDAO;
import gruppe22.cdio.dal.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic implements IBusinessLogic {
    private IUserDAO userDao;
    private UserDTO userDto;

    public  BusinessLogic() {
        userDao = new UserDAO();
    }

    @Override
    public String getRole() {
        return null;
    }

    @Override
    public int getPermissionLevel() {
        List<String> roles = userDto.getRoles();

        // Todo: should loop through the list - but as long as users only have one role index 0 is fine
        if (roles.get(0).contains("Admin"))
            return 1;
        else if (roles.get(0).contains("Operator"))
            return 2;
        else if (roles.get(0).contains("Pharmacist"))
            return 3;
        else if (roles.get(0).contains("Foreman"))
            return 4;
        else
            return 0;
    }

    @Override
    public void setUserDTO(int userId) {
        try {
            userDto = userDao.getUser(userId);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getUserList() {
        List<String> list = new ArrayList<>();
        try {
            List<UserDTO> userList = userDao.getUserList();

            for (int i = 0; i < userList.size(); i++) {
                list.add("ID: " + userList.get(i).getUserId()
                        + ", Navn: " + userList.get(i).getUserName()
                        + ", Initialer: " + userList.get(i).getIni()
                );
            }
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void createUser(int userId, String userName, String ini, int cpr, String role) {

        List<String> roles = new ArrayList<>();
        roles.add(role);
        String password = generatePassword();

        UserDTO user = new UserDTO(userId, userName, ini, cpr, password, roles);

        try {
            userDao.createUser(user);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUsername() {
        return userDto.getUserName();
    }

    @Override
    public int getUserId() {
        return userDto.getUserId();
    }

    /*
     * 8 characters, minimum three of the following types: small, capital, numbers and special* characters.
     * * '.', '-', '_', '+', '!', '?', '='
     * Password can't include userName or initials.
     */
    private String generatePassword() {
        //Random random = new SecureRandom();
        String password = "";
        return password;
    }
}
