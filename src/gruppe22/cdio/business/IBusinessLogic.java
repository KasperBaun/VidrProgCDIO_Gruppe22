package gruppe22.cdio.business;

import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDTO;

import java.util.List;

public interface IBusinessLogic {

    //Todo: methods for logic and interaction with domain (DTO) goes here..

    String getRole();
    int getPermissionLevel();

    void setUserDTO(int userId);
    String getUsername();
    int getUserId();
    List<String> getUserList();
}
