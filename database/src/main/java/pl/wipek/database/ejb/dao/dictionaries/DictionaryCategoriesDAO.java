package pl.wipek.database.ejb.dao.dictionaries;

import pl.wipek.database.entities.DictionaryCategories;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 19.09.2017.
 */
public interface DictionaryCategoriesDAO {
    public DictionaryCategories save(DictionaryCategories dictionaryCategories);
    public DictionaryCategories merge(DictionaryCategories dictionaryCategories);
    public boolean delete(DictionaryCategories dictionaryCategories);
    public boolean delete(String id);
    public DictionaryCategories find(String id);
    public List<DictionaryCategories> getAll();
}
