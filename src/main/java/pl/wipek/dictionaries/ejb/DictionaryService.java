package pl.wipek.dictionaries.ejb;

import pl.wipek.dictionaries.entity.DictionaryPl;
import pl.wipek.shared.ejb.GenericDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 20.08.2017.
 */
@ApplicationScoped
public class DictionaryService {

    @Inject
    GenericDao genericDao;

    public List<DictionaryPl> getAll() {
        return this.genericDao.findAll(DictionaryPl.class);
    }
}
