package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends RuntimeException{
    public NotSavedSubEntityException() {
        System.err.println("Failed to save message.");
    }
}