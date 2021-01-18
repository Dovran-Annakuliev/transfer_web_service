package ru.sberstart.transfer.dao;

import ru.sberstart.transfer.model.User;

import java.util.List;

public interface UserDao extends CrudDao<User, Long>{
    public List<User> getUsers();
}
