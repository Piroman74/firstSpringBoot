package com.dmitrijpol.firstboot.firstspringboot.dao;

import com.dmitrijpol.firstboot.firstspringboot.models.User;
import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public User show(long id);
    public void update(User user);
    List<User> index();
    public void deleteById(long id);
}
