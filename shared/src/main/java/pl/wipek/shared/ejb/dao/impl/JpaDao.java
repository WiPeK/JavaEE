package pl.wipek.shared.ejb.dao.impl;

import javassist.NotFoundException;
import pl.wipek.shared.ejb.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 21.09.2017.
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    /**
     * Saves an E entity to database
     *
     * @param entity
     * @return newly created entity
     */
    @Override
    public void persist(E entity) {
        entityManager.persist(entity);
    }

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param entity
     * @return a newly created instance merged.
     */
    @Override
    public E merge(E entity) {
        return entityManager.merge(entity);
    }

    /**
     * Deletes the entity.
     *
     * @param id of entity
     * @throws NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean remove(K id) throws NotFoundException {
        E entity = this.findById(id);
        if (entity != null) {
            entityManager.remove(entity);
            return true;
        } else {
            throw new NotFoundException("Can not remove object which doesn't exists");
        }
    }

    /**
     * Deletes the entity.
     *
     * @param id entity
     * @throws NotFoundException if the entity does not exist in database.
     */
    @Override
    public E findById(K id) throws NotFoundException {
        E entity = entityManager.find(entityClass, id);
        if (entity != null) {
            return entity;
        }
        throw new NotFoundException("Can not find object with id");
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        criteriaQuery.from(entityClass);
        List<E> res = entityManager.createQuery(criteriaQuery).getResultList();
        return res;
    }
}

