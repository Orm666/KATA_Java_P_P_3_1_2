package com.kata.pp.kata_java_p_p_3_1_2.dao;

import com.kata.pp.kata_java_p_p_3_1_2.model.User;
import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void remove(Long id) {
        em.remove(getUserById(id));
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = ?1", User.class);
        return query.setParameter(1, id).getSingleResult();
    }
}
