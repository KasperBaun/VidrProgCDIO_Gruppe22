package gruppe22.cdio.business;

import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDTO;

public class BusinessLogic implements IBusinessLogic {
    private IUserDAO userDao;
    private UserDTO userDto;

    private int currentUser;

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
        userDto = userDao.getUser(userId);
    }
}
