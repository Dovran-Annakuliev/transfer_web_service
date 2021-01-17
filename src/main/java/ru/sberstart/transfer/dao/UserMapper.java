package ru.sberstart.transfer.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.sberstart.transfer.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("User_Id"));
        User.setName(resultSet.getString("Name"));
        User.setMiddlename(resultSet.getString("Middle_Name"));
        User.setSurname(resultSet.getString("Sure_Name"));

        return user;
    }
}
