package pl.wipek.users.ejb.dao.impl;

import pl.wipek.users.ejb.dao.UsersDAO;
import pl.wipek.users.entities.Users;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
@Named
public class UsersDAOImpl implements UsersDAO {
    @Inject
    private EntityManager entityManager;

    /**
     * Saves an Users entity to database
     * @param user entity
     * @return newly created Users entity
     */
    @Override
    public Users save(Users user) {
        entityManager.persist(user);
        return user;
    }

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param user entity
     * @return a newly created instance merged.
     */
    @Override
    public Users merge(Users user) {
        return entityManager.merge(user);
    }

    /**
     * Deletes the entity.
     *
     * @param user entity
     * @throws javax.ws.rs.NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean delete(Users user) {
        Users userFromDatabase = this.find(user.getIdUsers());
        if (userFromDatabase != null) {
            entityManager.remove(userFromDatabase);
        } else {
            throw new NotFoundException("Can not remove object which doesn't exists");
        }
        return false;
    }

    /**
     * Deletes the entity.
     *
     * @param id user entity
     * @throws NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean delete(String id) {
        Users user = this.find(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            throw new NotFoundException("Can not remove object which doesn't exists");
        }
        return false;
    }

    /**
     * Find an entity by its identifier.
     *
     * @param id user id
     * @return user entity
     */
    @Override
    public Users find(String id) {
        return entityManager.find(Users.class, id);
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    @Override
    public List<Users> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);
        criteriaQuery.from(Users.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
