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
            var userList = userDao.getUserList();

            for (int i = 0; i < userList.size(); i++) {
                list.add(userList.get(i).toString());
            }
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
        return list;
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
