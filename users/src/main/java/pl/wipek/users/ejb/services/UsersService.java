package pl.wipek.users.ejb.services;

import pl.wipek.users.ejb.dao.UsersDAO;
import pl.wipek.users.ejb.dao.impl.JpaUsersDao;
import pl.wipek.users.entity.Users;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof Adamczyk on 18.09.2017.
 */
@Stateless
public class UsersService {

    @PersistenceContext(unitName = "pl.wipek.database.users")
    protected EntityManager entityManager;

//    @EJB(beanInterface = UsersDAO.class, beanName = "JpaUsersDao")
//    private UsersDAO usersDao;
//
//    public Optional<Users> findById(String id) {
//        Optional<Users> result = null;
//        try {
//            result = Optional.of(this.usersDao.findById(id));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

//    public List<Users> getAll() {
//        return this.usersDao.getAll();
//    }

    public Users abc() {
        return entityManager.find(Users.class, "E667E6C480394F45BC377D3F2DCFA4B9");
    }
}
