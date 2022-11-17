package edu.school21.chat.models;

import java.util.List;

public class User {
    private int             _id;
    private String          _login;
    private String          _password;
    private List<Chatroom>  _activeRooms;
    private List<Chatroom>  _createdRooms;

    public User(String login, String password) {
        this._login = login;
        this._password = password;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getLogin() {
        return _login;
    }

    public void setLogin(String login) {
        this._login = login;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public List<Chatroom> getAllChatroom() {
        return _activeRooms;
    }

    public void setAllChatroom(List<Chatroom> allChatroom) {
        this._activeRooms = allChatroom;
    }

    public List<Chatroom> getUserChatroom() {
        return _createdRooms;
    }

    public void setUserChatroom(List<Chatroom> userChatroom) {
        this._createdRooms = userChatroom;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + _id +
                ", login='" + _login + '\'' +
                ", password='" + _password + '\'' +
                ", allChatroom=" + _activeRooms +
                ", userChatroom=" + _createdRooms +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return _id == user._id;
    }
}
