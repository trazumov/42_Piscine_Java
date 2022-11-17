package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
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

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message ID: ");

        Optional<Message> massage;
        try {
            massage = repository.findById(scanner.nextLong());
            if (massage.isPresent()) {
                System.out.println(massage.get());
            } else {
                System.out.println("No message found for this ID.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        scanner.close();
    }
}
