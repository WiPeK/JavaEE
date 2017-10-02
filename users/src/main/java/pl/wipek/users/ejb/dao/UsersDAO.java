package pl.wipek.users.ejb.dao;

import pl.wipek.shared.ejb.dao.Dao;
import pl.wipek.users.entity.Users;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.transaction.Transactional;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
@Remote
public interface UsersDAO extends Dao<String, Users> {
    // todo add specific method
}
