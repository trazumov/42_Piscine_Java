package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.dataSource = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> massage;
        String query = "SELECT * FROM chat.message WHERE id = " + id;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (!resultSet.next()) {
            return Optional.empty();
        }

        massage = Optional.of(new Message(resultSet.getInt("id"),
                new User("user", "user"),
                new Chatroom("room"),
                resultSet.getString("text"),
                resultSet.getTimestamp("time")));

        statement.cancel();
        connection.close();

        return massage;
    }
}
