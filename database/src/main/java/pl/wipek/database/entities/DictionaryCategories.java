package pl.wipek.database.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Krzysztof Adamczyk on 19.09.2017.
 */
@Entity
@Table(name = "DICTIONARY_CATEGORIES", schema = "JAVAEE", catalog = "")
public class DictionaryCategories implements Serializable {
    private static final long serialVersionUID = -6580012241620579129L;

    private String idDictionaryCategories;
    private String name;

    @Id
    @Column(name = "ID_DICTIONARY_CATEGORIES")
    public String getIdDictionaryCategories() {
        return idDictionaryCategories;
    }

    public void setIdDictionaryCategories(String idDictionaryCategories) {
        this.idDictionaryCategories = idDictionaryCategories;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryCategories that = (DictionaryCategories) o;

        if (idDictionaryCategories != null ? !idDictionaryCategories.equals(that.idDictionaryCategories) : that.idDictionaryCategories != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionaryCategories != null ? idDictionaryCategories.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
