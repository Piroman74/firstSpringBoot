package com.dmitrijpol.firstboot.firstspringboot.service;

import com.dmitrijpol.firstboot.firstspringboot.dao.UserDao;
import com.dmitrijpol.firstboot.firstspringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

}
