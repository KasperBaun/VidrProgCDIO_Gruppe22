package gruppe22.cdio.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    public UserDAO(){

    }

    //SQL ------------------ SQL ------------------ SQL ------------------
    public UserDTO getUser(int userId){
        // Try / Catch in case something Goes Wrong.
        try {
            // Connection Setup And Retrieve Data
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lab001_Users WHERE userID = 2;");

            resultSet.next();

            // creating a UserDTO object to store data in.
            String str = resultSet.getString("roles");
            List<String> roles = StrToArrayList(str,";");
            UserDTO user = new UserDTO(
                    resultSet.getInt("userID"),
                    resultSet.getString("userName"),
                    resultSet.getString("ini"),
                    resultSet.getInt("cpr"),
                    resultSet.getString("password"),
                    roles);

            // making Sure to Close the Connection afterwards
            connection.close(); // Husker at lukke forbindelsen ned.
            return user;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //SQL ------------------ SQL ------------------ SQL ------------------
    public List<UserDTO> getUserList(){
        List<UserDTO> users = new ArrayList<UserDTO>();
        try {
            // Connection Setup And Retrieve Data
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lab001_Users");

            // Sort Results into a UserDTO List Object
            while (resultSet.next()){
                List<String> roles = StrToArrayList(resultSet.getString("roles"),";");
                UserDTO fillerDTO = new UserDTO(
                        resultSet.getInt("userID"),
                        resultSet.getString("userName"),
                        resultSet.getString("ini"),
                        resultSet.getInt("cpr"),
                        resultSet.getString("password"),
                        roles);
                users.add(fillerDTO);
            }

            // close Connection again
            return users;
        }
        catch(SQLException e){
            System.out.println("List<UserDTO> getUserList(); - somthing went wrong in the SQL Connection");
            e.printStackTrace();
            return null;
        }

    }
    //SQL ------------------ SQL ------------------ SQL ------------------
    public void createUser(UserDTO user){
        try {
            // Connection Setup And Retrieve Data
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

           // String sql = "INSERT INTO Lab001_Users(userID, userName, ini,cpr,password ,roles ) values (" + user.getUserId() + ", " + user.getUserName() + " , " + user.getIni() + " , " + user.getCpr() + " , " + user.getPassword() + ", " + ListToStr(user.getRoles());
            String sql = "INSERT INTO Lab001_Users(userID, userName, ini,cpr,password ,roles ) values (?, ? , ? , ? , ?, ?);";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3,user.getIni());
            pstmt.setInt(4,user.getCpr());
            pstmt.setString(5,user.getPassword());
            pstmt.setString(6,ListToStr(user.getRoles()));
            pstmt.executeUpdate();

           // statement.executeQuery("INSERT INTO Lab001_Users(userID, userName, ini,cpr,password ,roles ) values (" + user.getUserId() + ", " + user.getUserName() + " , " + user.getIni() + " , " + user.getCpr() + " , " + user.getPassword() + ", " + ListToStr(user.getRoles()) );

            // close Connection again
            connection.close(); // Husker at lukke forbindelsen ned.
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //SQL ------------------ SQL ------------------ SQL ------------------
    public void updateUser(UserDTO user){
        try {
            // Connection Setup And Retrieve Data
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Lab001_Users SET userName = \" " + user.getUserName() + " \", ini = \" " + user.getIni() + " \", cpr= " + user.getCpr() +", password=\" "+ user.getPassword() +" \", roles=\" "+ ListToStr(user.getRoles()) +" \" WHERE userID ="+ + user.getUserId());

            // close Connection again
            connection.close(); // Husker at lukke forbindelsen ned.
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //SQL ------------------ SQL ------------------ SQL ------------------
    public void deleteUser(UserDTO user){
        try {
            // Connection Setup And Retrieve Data
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Lab001_Users Where userID = " + user.getUserId() +";");

            // close Connection again
            connection.close(); // Husker at lukke forbindelsen ned.
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Private Methods
    private ArrayList<String> StrToArrayList(String str, String sepSymbol){
        ArrayList<String> returnList = new ArrayList<String>();
        String[] strA = str.split(sepSymbol);
        for(int i = 0; i < strA.length; i++){
            returnList.add(strA[i]);
        }
        return returnList;
    }
    private String ListToStr(List<String> list){
        String Str = "";
        for(int i = 0; i < list.size(); i++){
            Str = Str + list.get(i) + ";";
        }
        return Str;
    }
    private Connection getConnection() throws SQLException  {
        Connection myConnection = DriverManager.getConnection(/*todo SKRIV ADGANGS KODER HER...*/ );
        return myConnection;
    }

    @Deprecated
    private static void loadDriver() {

        try {
            Class.forName("com.mysql.cj.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Setting up an Exception, cant remember why.. but its done.
    class DALException extends Exception {
        public DALException(String msg, Throwable e) {
            super(msg,e);
        }
        public DALException(String msg) {
            super(msg);
        }
    }
}
