package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
	private Int				_id;
	private String			_login;
	private String			_password;
	private List<Chatroom>	_createdRooms;
	private List<Chatroom>	_activeRooms;

	public User (Int id, String login, String password) {
		this._id = id;
		this._login = login;
		this._password = password;
		this._createdRooms = null;
		this._activeRooms = null;
	}

	@Override
    public String toString() {
        return "User { Id: " + this._id +
		"_login:" + this._login +
		"_password:" + this._password + "}";
    }

	@Override
    public boolean equals(Object toCompare) {
 
        if (toCompare == this) {
            return true;
        }
 
        if (!(toCompare instanceof Chatroom)) {
            return false;
        }
         
        User tmp = (User) toCompare;
        return Int.compare(this._id, tmp._id) == 0;
    }

	@Override
    public int hashCode() {
        return Objects.hash(_id, _login, _password);
    }

	public getID() {
		return this._id;
	}

	public getLogin() {
		return this._login;
	}

	public getPassword() {
		return this._password;
	}

}
