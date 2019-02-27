package gruppe22.cdio.dal;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private List<User> users = new ArrayList<>();


    public DummyData(){
        for (int i = 0; i < 10; i++) {
            List<String> tomListe = new ArrayList<String>();
            tomListe.add("Pharmacist");
            users.add(new User(i, "StandardUserName_" + i, "TEMP", 0000000000, "3t4nd4rd", tomListe));
        }
        List<String> adminListe = new ArrayList<String>();
        adminListe.add("Admin");
        users.add(new User(10, "Admin", "ADM", 0101010101, "hest", adminListe));
    }
    public User getUser(int id){
        return users.get(id);
    }

    public void createUser(UserDTO user){
        int id = users.size() + 1;
        users.add(new User(id ,user.getUserName(), user.getIni(), user.getCpr(), user.getPassword(), user.getRoles()));
    }
    public void updateUser(UserDTO Updateduser){
        int id = Updateduser.getUserId();
        User tempUser = users.get(id);
        users.remove(id);
        users.add(tempUser);
    }
    public void deleteUser(UserDTO user){
        int id = user.getUserId();
        users.remove(id);
    }

    public int getUserListSize() {
        return users.size();
    }
}
