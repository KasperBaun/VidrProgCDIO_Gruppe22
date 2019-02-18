package gruppe22.cdio.dal;

import java.util.List;

public class DummyData {


    public List<User> users;

    public DummyData(){
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "StandardUserName_" + i, "TEMP", 0000000000, "3t4nd4rd", "Role"));
        }
    }

    public User getUser(int id){
        return users.get(id);
    }

}
