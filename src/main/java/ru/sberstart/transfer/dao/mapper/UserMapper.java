package ru.sberstart.transfer.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.sberstart.transfer.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("userid"));
        user.setName(resultSet.getString("name"));
        user.setMiddlename(resultSet.getString("middlename"));
        user.setSurname(resultSet.getString("surname"));

        return user;
    }
}
