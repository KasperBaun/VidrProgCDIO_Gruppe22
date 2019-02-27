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
    UserDTO getUser(int userId) throws IUserDAO.DALException;
    void createUser(int userId, String userName, String ini, int cpr, String role);
    void updateUser(int userId, String userName, int cprNumber, String ini, String pw, List<String> roles) throws IUserDAO.DALException;
    void deleteUser(int userId);
}
