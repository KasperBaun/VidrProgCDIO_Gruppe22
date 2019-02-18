package gruppe22.cdio.dal;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }

    //My Temporary DataBase
    private DummyData data = new DummyData();

    // Methods.
    public UserDTO getUser(int userId) throws IUserDAO.DALException{

        User u = data.getUser(userId);
        UserDTO user = new UserDTO();
        // set data
        user.setIni(u.getIni());
        user.setUserId(u.getUserId());
        user.setUserName(u.getUserName());

        return user;
    }
    public List<UserDTO> getUserList() throws IUserDAO.DALException{
        List<UserDTO> users = new ArrayList<UserDTO>();
        User u = data.getUser(0);

        // todo - her den skal være
        int i = 0;
        try {
            while (u != null) {
                UserDTO user = new UserDTO();
                user.setIni(u.getIni());
                user.setUserName(u.getUserName());
                user.setUserId(u.getUserId());
                users.add(user);
                i++;
                u = data.getUser(i);
            }
        }
        catch(IndexOutOfBoundsException e){
            return users;
        }
        return users;
    }

    public void createUser(UserDTO user) throws IUserDAO.DALException{}
    public void updateUser(UserDTO user) throws IUserDAO.DALException{}
    public void deleteUser(int userId) throws IUserDAO.DALException{}

}