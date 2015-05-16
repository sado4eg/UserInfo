package com.sado4eg.userinfo.dao;

import com.sado4eg.userinfo.beans.User;

import java.util.List;

public interface UserDAO {

    User get(Long id);
    User save(User user);
    User findByEmail(String email);
    List<User> find(String column, String value);
    List<User> getAllUsers();

}
