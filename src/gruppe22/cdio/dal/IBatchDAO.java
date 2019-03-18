package gruppe22.cdio.dal;

import java.io.IOException;
import java.util.List;

public interface IBatchDAO {
    BatchDTO getUser(int userId) throws IUserDAO.DALException;
    List<UserDTO> getUserList() throws IUserDAO.DALException;

    void createUser(UserDTO user) throws IUserDAO.DALException;
    void updateUser(UserDTO user) throws IUserDAO.DALException;
    void deleteUser(UserDTO user) throws IUserDAO.DALException;
    void saveData(String fileName) throws IOException;
}
