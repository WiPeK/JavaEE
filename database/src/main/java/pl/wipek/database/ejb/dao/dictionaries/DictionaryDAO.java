package pl.wipek.database.ejb.dao.dictionaries;

import pl.wipek.database.entities.Dictionary;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
public interface DictionaryDAO {
    public Dictionary save(Dictionary dictionary);
    public Dictionary merge(Dictionary dictionary);
    public boolean delete(Dictionary dictionary);
    public boolean delete(String id);
    public Dictionary find(String id);
    public List<Dictionary> getAll();
}
