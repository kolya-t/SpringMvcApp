package ru.eninja.service;

import org.springframework.transaction.annotation.Transactional;
import ru.eninja.domain.User;

import java.util.List;


/**
 * Interface of abstract user service. Defines operations on users
 */
@Transactional
public interface UserService {

    /**
     * Saves user to table
     *
     * @param user user to save
     * @return id of saved user
     */
    Long addUser(User user);

    /**
     * Finds and returns user by id
     *
     * @param id user id
     * @return user by id
     */
    User getUserById(Long id);

    /**
     * Finds and returns user list
     *
     * @return user list
     */
    List<User> getUserList();

    /**
     * Updates user in table
     *
     * @param user user to update
     */
    void updateUser(User user);

    /**
     * Deltes user by id
     *
     * @param id user id
     */
    void deleteUser(Long id);

    /**
     * Return user by login
     *
     * @param login user login
     * @return user by login
     */
    User getUserByLogin(String login);

    /**
     * Return user by email
     *
     * @param email user email
     * @return user by email
     */
    User getUserByEmail(String email);
}
