package pl.wipek.shared.ejb.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wipek.shared.ejb.dao.Dao;
import pl.wipek.shared.ejb.dao.exceptions.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.NotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 21.09.2017.
 */
public abstract class AbstractDao<K, E> implements Dao<K, E> {

    protected Class<E> entityClass;

    protected abstract EntityManager getEntityManager();

    public AbstractDao() {
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
    public E persist(E entity) throws DaoException {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            throw new DaoException(e);
        }
        return entity;
    }

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param entity
     * @return a newly created instance merged.
     * @throws DaoException
     */
    @Override
    public E merge(E entity) throws DaoException
    {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            throw new DaoException(e);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param id of entity
     * @throws NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean remove(K id) throws NotFoundException, DaoException {
        E entity = this.findById(id);
        if (entity != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(entity);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                getEntityManager().getTransaction().rollback();
                throw new DaoException(e);
            }
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
        E entity = getEntityManager().find(entityClass, id);
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
//        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
//        criteriaQuery.from(entityClass);
//        List<E> res = getEntityManager().createQuery(criteriaQuery).getResultList();
//        return res;
        Query query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
        return query.getResultList();
    }
}
