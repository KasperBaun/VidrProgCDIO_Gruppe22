package gruppe22.cdio.dal.dao;

import gruppe22.cdio.dal.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserDAO {

// Private Attributes.
    static final long serialVersionUID = 7355418246336739229L;



    // Constructor.
    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }

// Methods.
    UserDTO getUser(int userId) throws DALException;
    List<UserDTO> getUserList() throws DALException;

    void createUser(UserDTO user) throws DALException;
    void updateUser(UserDTO user) throws DALException;
    void deleteUser(UserDTO user) throws DALException;
    void saveData(String fileName) throws IOException;
}