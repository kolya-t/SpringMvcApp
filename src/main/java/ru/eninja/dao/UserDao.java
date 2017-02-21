package ru.eninja.dao;

import org.springframework.data.repository.CrudRepository;
import ru.eninja.domain.User;


/**
 * DAO for User type. Defines comm
 */
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Specific user getter by login property
     *
     * @param login user login
     * @return user by login
     */
    User findByLogin(String login);

    /**
     * Specific user getter by login and password properties
     *
     * @param login    user login
     * @param password user password
     * @return user by login and password
     */
    User findByLoginAndPassword(String login, String password);

    /**
     * Specific user getter by email property
     *
     * @param email user email
     * @return user by email
     */
    User findByEmail(String email);
}
