package gruppe22.cdio.business;

import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDTO;

import java.util.List;

public class BusinessLogic implements IBusinessLogic {
    private IUserDAO userDao;
    private UserDTO userDto;



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
        var userList = userDao.getUserList();
        List<String> list = null;

        for (int i = 0; i < userList.size(); i++) {
            list.add(userList.get(i).toString());
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
