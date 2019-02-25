package gruppe22.cdio.business;

import gruppe22.cdio.dal.IUserDAO;
import gruppe22.cdio.dal.UserDAO;
import gruppe22.cdio.dal.UserDTO;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BusinessLogic implements IBusinessLogic {
    private IUserDAO userDao;
    private UserDTO userDto;

    public  BusinessLogic() {
        userDao = new UserDAO();
    }

    @Override
    public String getRole() {
        return userDto.getRoles().get(0);
    }

    @Override
    public int getPermissionLevel() {
        List<String> roles = userDto.getRoles();

        // Todo: should loop through the list - but as long as users only have one role index 0 is fine
        if (roles.get(0).contains("Admin"))
            return 1;
        else if (roles.get(0).contains("Operator"))
            return 2;
        else if (roles.get(0).contains("Pharmacist"))
            return 3;
        else if (roles.get(0).contains("Foreman"))
            return 4;
        else
            return 0;
    }

    @Override
    public void setUserDTO(int userId) {
        try {
            userDto = userDao.getUser(userId);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getUserList() {
        List<String> list = new ArrayList<>();
        try {
            List<UserDTO> userList = userDao.getUserList();

            for (int i = 0; i < userList.size(); i++) {
                list.add("ID: " + userList.get(i).getUserId()
                        + ", Navn: " + userList.get(i).getUserName()
                        + ", Initialer: " + userList.get(i).getIni()
                        + ", Rolle: " + userList.get(i).getRoles()
                );
            }
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void createUser(int userId, String userName, String ini, int cpr, String role) {

        List<String> roles = new ArrayList<>();
        roles.add(role);
        String password = "";
        var passwd = generateSecureRandomPassword();

        UserDTO user = new UserDTO(userId, userName, ini, cpr, password, roles);

        try {
            userDao.createUser(user);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            UserDTO user = userDao.getUser(userId);
            userDao.deleteUser(user);
        } catch (IUserDAO.DALException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getUsername() {
        return userDto.getUserName();
    }

    @Override
    public int getUserId() {
        return userDto.getUserId();
    }

    /**
     * A method for generating a set of random chars
     *
     *
     * @param count the amount of special characters that you want to generate
     * @return a character stream containing count special charactes (unicode 33-45)
     */
    public Stream<Character> getRandomSpecialChars(int count) {
        Random random = new SecureRandom();
        IntStream specialChars = random.ints(count, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }

    /**
     * A method for generating a set of random numbers
     *
     *
     * @param count the amount of numbers you want to generate
     * @return a character stream containing count numbers (unicode 48-57)
     */
    public Stream<Character> getRandomNumbers(int count) {
        Random random = new SecureRandom();
        IntStream numberChars = random.ints(count, 48, 57);
        return numberChars.mapToObj(data -> (char) data);
    }

    /**
     * A method for generating a set of lower case characters
     *
     *
     * @param count the amount of chars you want to generate.
     * @return a character stream containing count lower case chars (unicode 97-122)
     */
    public Stream<Character> getLowerCase(int count) {
        Random random = new SecureRandom();
        IntStream lowerCaseChar = random.ints(count, 97,122);
        return lowerCaseChar.mapToObj(data -> (char) data);
    }

    /**
     * A method for generating a set of upper case chars
     *
     *
     * @param count the amount of chars you want to generate
     * @return a character stream containing count lower case chars (unicode 65-90)
     */
    public Stream<Character> getUpperCase(int count) {
        Random random = new SecureRandom();
        IntStream upperCaseChar = random.ints(count, 65,90);
        return upperCaseChar.mapToObj(data -> (char) data);
    }

    /**
     * a method utilizing the character streams to generate a password.
     *
     *
     * @return a randomly generated secure password.
     */
    public String generateSecureRandomPassword() {
        Stream<Character> pwdStream = Stream.concat(getRandomNumbers(2),
                Stream.concat(getRandomSpecialChars(2),
                        Stream.concat(getLowerCase(2), getUpperCase(4))));
        List<Character> charList = pwdStream.collect(Collectors.toList());
        Collections.shuffle(charList);
        String password = charList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }
}
