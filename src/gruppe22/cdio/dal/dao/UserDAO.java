package gruppe22.cdio.dal.dao;

import gruppe22.cdio.dal.DummyData;
import gruppe22.cdio.dal.User;
import gruppe22.cdio.dal.dto.UserDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    public UserDAO() throws IOException, ClassNotFoundException {
    }

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
            User myData = data.getUser(userId);
            UserDTO user = new UserDTO(myData.getUserId(), myData.getUserName(), myData.getIni(), myData.getCpr(), myData.getPassword(), myData.getRole() );
        return user;
    }
    public List<UserDTO> getUserList() throws IUserDAO.DALException{
        List<UserDTO> users = new ArrayList<UserDTO>();
        User u;

        for (int i = 0; i < data.getUserListSize(); i++) {
            u = data.getUser(i);
            UserDTO user = new UserDTO (u.getUserId(), u.getUserName(), u.getIni(), u.getCpr(),
                    u.getPassword(), u.getRole());
            users.add(user);
        }
        return users;

    }

    public void createUser(UserDTO user) throws IUserDAO.DALException{
        data.createUser(user);
    }
    public void updateUser(UserDTO user) throws IUserDAO.DALException{
        data.updateUser(user);
    }
    public void deleteUser(UserDTO user) throws IUserDAO.DALException{
        data.deleteUser(user);
    }

    public void saveData(String fileName) throws IOException {
        data.saveToDisk(fileName);
    }
}