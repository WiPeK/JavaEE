package pl.wipek.users.ejb.services;

import pl.wipek.users.ejb.dao.UsersDAO;
import pl.wipek.users.entity.Users;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof Adamczyk on 18.09.2017.
 */
@Stateless
public class UsersService {

    @EJB
    private UsersDAO usersDao;

    public Optional<Users> findById(String id) {
        Optional<Users> result = null;
        try {
            result = Optional.of(this.usersDao.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Users> getAll() {
        return this.usersDao.getAll();
    }
}
