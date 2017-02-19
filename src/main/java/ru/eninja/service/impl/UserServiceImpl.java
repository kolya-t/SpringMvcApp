package ru.eninja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.eninja.dao.user.UserDao;
import ru.eninja.domain.User;
import ru.eninja.service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("hibernateUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Long addUser(User user) {
        return userDao.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userDao.findById(id);
        userDao.delete(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
