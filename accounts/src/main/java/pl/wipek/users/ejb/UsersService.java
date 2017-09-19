package pl.wipek.users.ejb;

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
    GenericDao dao;

    public List<Users> getAll() {
        return this.dao.findAll(Users.class);
    }
}
