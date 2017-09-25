package pl.wipek.users.ejb.dao.impl;

import pl.wipek.shared.ejb.dao.impl.JpaDao;
import pl.wipek.users.ejb.dao.UsersDAO;
import pl.wipek.users.entity.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
@Stateless
public class JpaUsersDao extends JpaDao<String, Users> implements UsersDAO {

    @PersistenceContext(unitName = "pl.wipek.database.users")
    protected EntityManager entityManager;
}
