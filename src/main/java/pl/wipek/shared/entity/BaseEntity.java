package pl.wipek.shared.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Krzysztof Adamczyk on 20.08.2017.
 */
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Serializable{

    /**
     * This method should return the primary key.
     *
     * @return
     */
    public abstract T getId();
}
