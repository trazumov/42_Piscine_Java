package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private Long             _id;
    private String          _name;
    private User            _owner;
    private List<Message>   _messages;

    public Long getId() {
        return _id;
    }

    public Chatroom(String name) {
        this._name = name;
    }

    public Chatroom(Long id, String name, User owner, List<Message> messages) {
        this._id = id;
        this._name = name;
        this._owner = owner;
        this._messages = messages;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public User getOwner() {
        return _owner;
    }

    public void setOwner(User owner) {
        this._owner = owner;
    }

    public List<Message> getMessages() {
        return _messages;
    }

    public void setMessages(List<Message> messages) {
        this._messages = messages;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + _id +
                ", name='" + _name + '\'' +
                ", owner=" + _owner +
                ", messages=" + _messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return _id == chatroom._id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
