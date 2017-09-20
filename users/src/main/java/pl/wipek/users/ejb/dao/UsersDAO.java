package pl.wipek.users.ejb.dao;

import pl.wipek.users.entities.Users;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
public interface UsersDAO {
    /**
     * Saves an Users entity to database
     * @param user entity
     * @return newly created Users entity
     */
    public Users save(Users user);

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param user entity
     * @return a newly created instance merged.
     */
    public Users merge(Users user);

    /**
     * Deletes the entity.
     *
     * @param user entity
     * @throws NotFoundException if the user does not exist in database.
     */
    public boolean delete(Users user);

    /**
     * Deletes the entity.
     *
     * @param id user entity
     * @throws NotFoundException if the user does not exist in database.
     */
    public boolean delete(String id);

    /**
     * Find an entity by its identifier.
     *
     * @param id user id
     * @return user entity
     */
    public Users find(String id);

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    public List<Users> getAll();
}
