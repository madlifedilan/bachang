package com.mxt.sql.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private int score;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public User(int id, String username, String password,int score) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public User(String  username, String password,int score){
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
