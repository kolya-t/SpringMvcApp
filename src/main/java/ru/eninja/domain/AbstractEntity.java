package ru.eninja.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Class of abstract Entity to persist it in table
 *
 * @param <K> type of entity primary key
 */
@MappedSuperclass
public abstract class AbstractEntity<K extends Serializable> implements Serializable {

    /**
     * Primary key column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected K id;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}
