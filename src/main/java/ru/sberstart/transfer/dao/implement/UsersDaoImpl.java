package ru.sberstart.transfer.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.UserDao;
import ru.sberstart.transfer.dao.mapper.UserMapper;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersDaoImpl implements UserDao {
    private String SQL_CREATE = "INSERT INTO users (name, middlename, surname) VALUES (?, ?, ?)";
    private String SQL_READ = "SELECT * FROM users WHERE userid = ?";
    private String SQL_UPDATE = "UPDATE users SET name = ?, middlename = ?, surname = ? WHERE userid = ?";
    private String SQL_DELETE = "DELETE FROM users WHERE userid = ?";
    private String SQL_FIND_ALL = "SELECT * FROM users";
//    private String SQL_FIND_ALL_BY_ID = "select * from Card WHERE Account_id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(User user) {
        jdbcTemplate.update(SQL_CREATE, user.getName(), user.getMiddlename(), user.getSurname());
    }

    @Override
    public User read(Long id) {
        return jdbcTemplate.query(SQL_READ, new Object[]{id}, new UserMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(Long id, User user) {
        jdbcTemplate.update(SQL_UPDATE, user.getName(), user.getMiddlename(), user.getSurname(), id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    public List<User> getUsers() {
        return jdbcTemplate.query(SQL_FIND_ALL, new UserMapper());
    }

}
