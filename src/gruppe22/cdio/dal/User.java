package gruppe22.cdio.dal;

import java.util.List;

public class User{
    private int	userId;
    private String userName;
    private String ini;
    private int cpr;
    private String password;
    private List<String> role;

    public User(int userId, String username, String ini, int cpr, String password, List<String> role ){
        this.userId = userId;
        this.userName = username;
        this.ini = ini;
        this.cpr = cpr;
        this.password = password;
        this.role = role;
    }

    public int getCpr() {
        return cpr;
    }

    public int getUserId() {
        return userId;
    }

    public String getIni() {
        return ini;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }
}
