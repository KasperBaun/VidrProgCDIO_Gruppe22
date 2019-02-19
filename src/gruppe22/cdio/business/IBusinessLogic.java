package gruppe22.cdio.business;

import java.util.List;

public interface IBusinessLogic {

    //Todo: methods for logic and interaction with domain (DTO) goes here..

    String getRole();
    int getPermissionLevel();

    void setUserDTO(int userId);
    String getUsername();
    int getUserId();
    List<String> getUserList();
    void createUser(String userName, String ini);
}
