package ru.eninja.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.eninja.domain.AbstractEntity;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * Abstract class implementing DAO based on Hibernate.
 *
 * @param <K> key type of using Entity
 * @param <E> type of using Entity
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<K extends Serializable, E extends AbstractEntity<K>> implements Dao<K, E> {

    /**
     * Type of using entity
     */
    protected Class<E> entityClass;

    /**
     * Factory, producing Hibernate sessions
     */
    private final SessionFactory sessionFactory;

    @Autowired
    public AbstractHibernateDao(SessionFactory sessionFactory) {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[1];

        this.sessionFactory = sessionFactory;
    }

    /**
     * @return current hibernate session
     */
    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public K persist(E entity) {
        return (K) getCurrentSession().save(entity);
    }

    @Override
    public E findById(K id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        String queryString = "from " + entityClass.getName();
        return getCurrentSession()
                .createQuery(queryString)
                .list();
    }

    @Override
    public void update(E entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(E entity) {
        getCurrentSession().delete(entity);
    }
}
