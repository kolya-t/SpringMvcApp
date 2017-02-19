package ru.eninja.dao;

import ru.eninja.domain.AbstractEntity;

import java.io.Serializable;
import java.util.List;


/**
 * Defines common CRUD operations.
 *
 * @param <K> key type of using Entity
 * @param <E> type of using Entity
 */
public interface Dao<K extends Serializable, E extends AbstractEntity<K>> {

    /**
     * Create - method.
     * Persists entity and returns its id
     *
     * @param entity entity to save
     * @return entity id
     */
    K persist(E entity);

    /**
     * Read - method.
     * Finds entity by id and returns it or {@code null} if entity not found
     *
     * @param id entity id
     * @return entity by id
     */
    E findById(K id);

    /**
     * Read - method.
     * Finds all entities in table and returns list of them
     *
     * @return list of all E entities
     */
    List<E> findAll();

    /**
     * Update - method.
     * Updates entity data
     *
     * @param entity persistent object
     */
    void update(E entity);

    /**
     * Delete - method.
     * Removes entity
     *
     * @param entity object to delete
     */
    void delete(E entity);
}
