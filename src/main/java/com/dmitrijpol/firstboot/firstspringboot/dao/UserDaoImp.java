package com.dmitrijpol.firstboot.firstspringboot.dao;

import com.dmitrijpol.firstboot.firstspringboot.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("select s from User s ", User.class)
                .getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

}
