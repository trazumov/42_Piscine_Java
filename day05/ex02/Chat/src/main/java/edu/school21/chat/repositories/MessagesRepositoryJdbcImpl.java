package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String query = "SELECT * FROM chat.msgs WHERE id = " + id;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (!resultSet.next()) {
            return Optional.empty();
        }

        massage = Optional.of(new Message(resultSet.getLong("id"), new User("user", "user"),
                new Chatroom("room"),
                resultSet.getString("message"),
                resultSet.getTimestamp("time").toLocalDateTime()));

        statement.cancel();
        connection.close();

        return massage;
    }

    @Override
    public void save(Message message) {
        String query = "INSERT INTO chat.message (room, author, text, time) VALUES (?, ?, '"
         + message.getText()  + "', '"
          + message.getDateTime() + "');";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, message.getRoom().getId());
            statement.setLong(2, message.getAuthor().getId());

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getLong("id"));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
    }
}
