package ru.eninja.dao.user.impl;

import org.springframework.stereotype.Repository;
import ru.eninja.dao.AbstractJpaDao;
import ru.eninja.dao.user.UserDao;
import ru.eninja.domain.User;


@Repository
public class JpaUserDao extends AbstractJpaDao<Long, User> implements UserDao {

    @Override
    public User findByLogin(String login) {
        String queryString = "from User where login = :login";
        return (User) entityManager
                .createQuery(queryString)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        String queryString = "from User where email = :email";
        return (User) entityManager
                .createQuery(queryString)
                .setParameter("email", email)
                .getSingleResult();
    }
}
