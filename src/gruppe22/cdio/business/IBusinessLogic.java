package gruppe22.cdio.business;

public interface IBusinessLogic {

    //Todo: methods for logic and interaction with domain (DTO) goes here..

    public String getRole();
    public int getPermissionLevel();

    void setUserDTO(int userId);

}
