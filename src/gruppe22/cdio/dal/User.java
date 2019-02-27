package gruppe22.cdio.dal;

import java.util.List;

public class User{
    private int	userId;
    private String userName;
    private String ini;
    private long cpr;
    private String password;
    private List<String> role;

    public User(int userId, String username, String ini, long cpr, String password, List<String> role ){
        this.userId = userId;
        this.userName = username;
        this.ini = ini;
        this.cpr = cpr;
        this.password = password;
        this.role = role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public long getCpr() {
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
