package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USER_NAME);
        ds.setPassword(PASSWORD);

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        User creator = new User(null, "User1", "user1", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(null,  "Chat1", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        repository.save(message);

        System.out.println(message.getId());
    }
}
