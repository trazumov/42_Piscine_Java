package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
	private Int				_id;
	private String			_name;
	private User			_owner;
	private List<Message>	_messages;

	public Chatroom(Int id, String name, User owner) {
		this._id = id;
		this._name = name;
		this._owner = owner;
		this._messages = null;
	}

	@Override
    public String toString() {
        return "Chatroom { Id: " + this._id +
		"name:" + this._name +
		"owner: " + this._owner + "}";
    }

    @Override
    public boolean equals(Object toCompare) {
 
        if (toCompare == this) {
            return true;
        }
 
        if (!(toCompare instanceof Chatroom)) {
            return false;
        }
         
        Chatroom tmp = (Chatroom) toCompare;
        return Int.compare(this._id, tmp._id) == 0;
    }

	@Override
    public int hashCode() {
        return Objects.hash(_id, _name, _owner, _messages);
    }

}

