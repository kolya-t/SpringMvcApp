package ru.eninja.dao.user;

import ru.eninja.dao.Dao;
import ru.eninja.domain.User;


/**
 * User DAO interface. Defines specified for User methods.
 */
public interface UserDao extends Dao<Long, User> {

    /**
     * Gets user by login
     *
     * @param login user login
     * @return user by login
     */
    User findByLogin(String login);

    /**
     * Gets user by email
     *
     * @param email user email
     * @return email by email
     */
    User findByEmail(String email);
}
