package pl.wipek.users.ejb.services;

import pl.wipek.users.ejb.dao.UsersDAO;
import pl.wipek.users.entities.Users;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 18.09.2017.
 */
@Named
@ApplicationScoped
public class UsersService {

    @Inject
    UsersDAO usersDao;

    public List<Users> getAll() {
        return this.usersDao.getAll();
    }
}
