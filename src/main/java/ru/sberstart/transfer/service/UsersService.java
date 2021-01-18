package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.implement.UsersDaoImpl;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersService {
    private final UsersDaoImpl usersDaoImpl;

    @Autowired
    public UsersService(UsersDaoImpl usersDaoImpl) {
        this.usersDaoImpl = usersDaoImpl;
    }

    public void createUser(User user) {
        usersDaoImpl.create(user);
    }

    public User getUser(Long id){
        return usersDaoImpl.read(id);
    }

    public void updateUser(Long id, User user) {
        usersDaoImpl.update(id, user);
    }

    public void deleteUser(Long id) {
        usersDaoImpl.delete(id);
    }

    public List<User> getUsers(){
        return usersDaoImpl.getUsers();
    }
}
