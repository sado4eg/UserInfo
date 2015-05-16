package com.sado4eg.userinfo.dao;

import com.sado4eg.userinfo.beans.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class UserHibernateDAOImpl extends HibernateDaoSupport implements UserDAO {

    @Override
    public User get(Long id) {
        return (User) currentSession().get(User.class, id);
    }

    @Override
    public User save(User user) {
        currentSession().saveOrUpdate(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        List<User> result = currentSession().createQuery("from USERS u where u.email like :email").setString("email", email).list();
        return (User)result.toArray()[0];
    }

    @Override
    public List<User> find(String column, String value) {
        return currentSession().createQuery("from USERS u where u." + column + "like :" + column).setString(column, value).list();
    }

    @Override
    public List<User> getAllUsers() {
        return currentSession().createCriteria(User.class).list();
    }
}
