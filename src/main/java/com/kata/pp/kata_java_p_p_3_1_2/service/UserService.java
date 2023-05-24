package com.kata.pp.kata_java_p_p_3_1_2.service;


import com.kata.pp.kata_java_p_p_3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void save(User user);

    void update(User user);

    void remove(Long id);

    User getUserById(Long id);

}
