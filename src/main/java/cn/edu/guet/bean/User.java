package cn.edu.guet.bean;

public class User {
    private int userId;
    private String username;
    private String address;

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public User(int userId, String username, String address) {
        this.userId = userId;
        this.username = username;
        this.address = address;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
