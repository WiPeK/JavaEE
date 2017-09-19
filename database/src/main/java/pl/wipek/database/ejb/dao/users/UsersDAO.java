package pl.wipek.database.ejb.dao.users;

import pl.wipek.database.entities.Users;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
public interface UsersDAO {
    public Users save(Users user);
    public Users merge(Users user);
    public boolean delete(Users user);
    public boolean delete(String id);
    public Users find(String id);
    public List<Users> getAll();
}
