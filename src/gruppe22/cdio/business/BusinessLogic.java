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
        var roles = userDto.getRoles();

        //Todo: Waiting for UserDAO to be implemented
        // should loop through the list - but as long as users only have one role index 0 is fine
//        if (roles.get(0).contains("Admin"))
//            return 1;
//        else if (roles.get(0).contains("Operator"))
//            return 2;
//        else if (roles.get(0).contains("Pharmacist"))
//            return 3;
//        else if (roles.get(0).contains("Foreman"))
//            return 4;

        //Todo: remove hardcoded permissionLevel
        return 1;
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
            var userList = userDao.getUserList();

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
    public void createUser(String userName, String ini) {
        UserDTO user = new UserDTO();
        user.setUserName(userName);
        user.setIni(ini);
        //userDao.createUser(user);
    }

    @Override
    public String getUsername() {
        return userDto.getUserName();
    }

    @Override
    public int getUserId() {
        return userDto.getUserId();
    }
}
