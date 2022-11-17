package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Message {
    private int         _id;
    private User        _author;
    private Chatroom    _room;
    private String      _text;
    private Timestamp   _dateTime;

    public Message(int id, User author, Chatroom room, String text, Timestamp dateTime) {
        this._id = id;
        this._author = author;
        this._room = room;
        this._text = text;
        this._dateTime = dateTime;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public User getAuthor() {
        return _author;
    }

    public void setAuthor(User author) {
        this._author = author;
    }

    public Chatroom getRoom() {
        return _room;
    }

    public void setRoom(Chatroom room) {
        this._room = room;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    public Timestamp getDateTime() {
        return _dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this._dateTime = Timestamp.valueOf(dateTime);
    }

    @Override
    public String toString() {
        return "Message{\n" +
                " id=" + _id +
                ",\n author=" + _author +
                ",\n room=" + _room +
                ",\n text='" + _text + '\'' +
                ",\n dateTime=" + _dateTime +
                "\n}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return _id == message._id;
    }
}
