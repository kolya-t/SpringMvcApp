package ru.eninja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eninja.dao.UserDao;
import ru.eninja.domain.User;
import ru.eninja.service.UserService;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Saves user to table
     *
     * @param user user to save
     * @return id of saved user
     */
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    /**
     * Saves collection of Users to table
     *
     * @param users user collection
     * @return saved collection
     */
    @Override
    public Iterable<? extends User> addUsers(Iterable<? extends User> users) {
        return userDao.save(users);
    }

    /**
     * Finds and returns user by id
     *
     * @param id user id
     * @return user by id
     */
    @Override
    public User getUserById(Long id) {
        return userDao.findOne(id);
    }

    /**
     * Finds and returns user list
     *
     * @return user list
     */
    @Override
    public List<User> getUserList() {
        return (List<User>) userDao.findAll();
    }

    /**
     * Updates user in table
     *
     * @param user user to update
     */
    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    /**
     * Deletes user by id
     *
     * @param id user id
     */
    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    /**
     * Deleted user
     *
     * @param user user to delete
     */
    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    /**
     * Deletes a collection of users
     *
     * @param users user collection to delete
     */
    @Override
    public void deleteUsers(Iterable<? extends User> users) {
        userDao.delete(users);
    }

    /**
     * Return user by login
     *
     * @param login user login
     * @return user by login
     */
    @Override
    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    /**
     * Return user by email
     *
     * @param email user email
     * @return user by email
     */
    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    /**
     * Returns user by login and password
     *
     * @param login    user login
     * @param password user password
     * @return user by login and password
     */
    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userDao.findByLoginAndPassword(login, password);
    }
}
