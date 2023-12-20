package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String username;
   private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private Type type;

//    public User() {
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }
//
//    public User(String username, String email, String password, String phoneNumber, Type type) {
//        this.id= UUID.idGenerate();
//        this.username = username;
//        this.email=email;
//        this.password=password;
//        this.phoneNumber = phoneNumber;
//        this.type=type;
//    }
//
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public  String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return username;
//    }
//
//    public void setName(String name) {
//        this.username = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", type=" + type +
//                '}';
//    }
}
