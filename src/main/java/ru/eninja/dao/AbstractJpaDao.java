package ru.eninja.dao;

import ru.eninja.domain.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * Abstract class implementing DAO based on JPA.
 *
 * @param <K> key type of using Entity
 * @param <E> type of using Entity
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJpaDao<K extends Serializable, E extends AbstractEntity<K>> implements Dao<K, E> {

    /**
     * Type of using entity
     */
    protected Class<E> entityClass;

    /**
     * Object to do all operations with entities
     */
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractJpaDao() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[1];
    }

    @Override
    public K persist(E entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        return entity.getId();
    }

    @Override
    public E findById(K id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        String queryString = "from " + entityClass.getName();
        return entityManager
                .createQuery(queryString)
                .getResultList();
    }

    @Override
    public void update(E entity) {
        entityManager.refresh(entity);
    }

    @Override
    public void delete(E entity) {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
    }
}
