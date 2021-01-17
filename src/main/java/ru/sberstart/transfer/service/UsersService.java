package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.UsersDao;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersService {
    private final UsersDao usersDao;

    @Autowired
    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void createUser(User user) {
        usersDao.create(user);
    }

    public User getUser(Long id){
        return usersDao.read(id);
    }

    public void updateUser(Long id, User user) {
        usersDao.update(id, user);
    }

    public void deleteUser(Long id) {
        usersDao.delete(id);
    }

    public List<User> getUsers(){
        return usersDao.getUsers();
    }
}
