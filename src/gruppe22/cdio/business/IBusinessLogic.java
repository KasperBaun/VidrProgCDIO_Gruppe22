package gruppe22.cdio.business;

import gruppe22.cdio.dal.UserDTO;

public interface IBusinessLogic {

    //Todo: methods for logic and interaction with domain (DTO) goes here..

    public String getRole();
    public int getPermissionLevel();

    void setUserDTO(int userId);
    String getUsername();
    int getUserId();

}
