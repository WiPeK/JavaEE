package pl.wipek.dictionaries.entity;

import pl.wipek.shared.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Krzysztof Adamczyk on 11.08.2017.
 */
@Entity
@Table(name = "DICTIONARY_PL", schema = "JAVAEE")
@XmlRootElement
public class DictionaryPl extends BaseEntity<String> {
    private String id;
    private String value;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryPl that = (DictionaryPl) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
