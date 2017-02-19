package ru.eninja.dao.user.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.eninja.dao.AbstractHibernateDao;
import ru.eninja.dao.user.UserDao;
import ru.eninja.domain.User;


@Repository
public class HibernateUserDao extends AbstractHibernateDao<Long, User> implements UserDao {

    public HibernateUserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User findByLogin(String login) {
        String hibernateQuery = "from User where login = :login";
        return (User) getCurrentSession()
                .createQuery(hibernateQuery)
                .setParameter("login", login)
                .uniqueResult();
    }

    @Override
    public User findByEmail(String email) {
        String hibernateQuery = "from User where email = :email";
        return (User) getCurrentSession()
                .createQuery(hibernateQuery)
                .setParameter("email", email)
                .uniqueResult();
    }
}
