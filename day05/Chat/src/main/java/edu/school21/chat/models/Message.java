package edu.school21.chat.models;

public class Message {
	private Int			_id;
	private User		_author;
	private Chatroom	_room;
	private String		_text;
	//Message date/time;

	public Message(Int id, User author, Chatroom room, String text) {
		this._id = id;
		this._author = author;
		this._room = room;
		this._text = text;
	}

	@Override
    public String toString() {
        return "Message { Id: " + this._id +
		"author:" + this._author +
		"room:" + this._room +
		"text: " + this._text + "}";
    }

	@Override
    public boolean equals(Object toCompare) {
 
        if (toCompare == this) {
            return true;
        }
 
        if (!(toCompare instanceof Chatroom)) {
            return false;
        }
         
        Message tmp = (Message) toCompare;
        return Int.compare(this._id, tmp._id) == 0;
    }

	@Override
    public int hashCode() {
        return Objects.hash(_id, _author, _room, _text);
    }
}
