package gruppe22.cdio.dal.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable{

// Private Attributes
    private static final long serialVersionUID = 4545864587995944260L;
    private int	userId;
    private String userName;
    private String ini;
    private long cpr;
    private String password;
    private List<String> roles;

// Constructor
    public UserDTO(int userid, String userName, String ini, long cpr, String password, List<String> roles) {
        this.userId = userid;
        this.userName = userName;
        this.ini = ini;
        this.cpr = cpr;
        this.password = password;
        this.roles = roles;
    }

// Public Methods
    public int  getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getIni() {
        return ini;
    }
    public long getCpr() {
        return cpr;
    }
    public List<String> getRoles() {
        return roles;
    }
    public String getPassword() {
        return password;
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
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role){
        this.roles.add(role);
    }
    public boolean removeRole(String role){
        return this.roles.remove(role);
    }
//Private Methods

// Override Methods
    @Override
    public String toString() {
        return "UserDTO [userId= " + userId + ", userName= " + userName + ", ini= " + ini + ", roles= " + roles + "]";
    }
}