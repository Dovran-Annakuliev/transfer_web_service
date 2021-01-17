package ru.sberstart.transfer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersDao implements CrudDao<User, Long>{
    private String SQL_CREATE = "INSERT INTO users (name, middlename, surename) VALUES (?, ?, ?)";
    private String SQL_READ = "SELECT * FROM users where id = ?";
    private String SQL_UPDATE = "UPDATE users SET name = ?, middlename = ?, surename = ? where id = ?";
    private String SQL_DELETE = "DELETE FROM users WHERE id = ?";
    private String SQL_FIND_ALL = "select * from users";
//    private String SQL_FIND_ALL_BY_ID = "select * from Card WHERE Account_id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(User user) {
        jdbcTemplate.update(SQL_CREATE, User.getName(), User.getMiddlename(), User.getSurname());
    }

    @Override
    public User read(Long id) {
        return jdbcTemplate.query(SQL_READ, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(Long id, User user) {
        jdbcTemplate.update(SQL_UPDATE, User.getName(), User.getMiddlename(), User.getSurname(), id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    public List<User> getUsers() {
        return jdbcTemplate.query(SQL_FIND_ALL, new BeanPropertyRowMapper<>(User.class));
    }
}
