package storage;



import model.Type;
import model.User;

import java.util.HashMap;
import java.util.Map;


public class UserStorage {

    private final Map<String, User> userHashMap = new HashMap<>();

    public void add(String emailKey, User user) {
        userHashMap.put(emailKey, user);

    }

    public User login(String email, String password) {
        User user = userHashMap.get(email);
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            return user;

        }

        return null;
    }

    public void printUsers() {
        for (User user : userHashMap.values()) {
            if (user.getType() == Type.USER) {
                System.out.println(user);
            }
        }
    }

    public User getUserById(String userIdForChanged) {
        for (User value : userHashMap.values()) {
            if (value.getId().equals(userIdForChanged)) {
                User user = userHashMap.get(value.getEmail());
                return user;
            }
        }
        return null;
    }

    public void changerUserType(User userIdForChanged) {
        userIdForChanged.setType(Type.ADMIN);
    }


}
