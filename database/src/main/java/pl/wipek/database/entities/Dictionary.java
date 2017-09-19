package pl.wipek.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author Krzysztof Adamczyk on 19.09.2017.
 */
@Entity
public class Dictionary implements Serializable {
    private static final long serialVersionUID = -6580012241620579129L;

    private String idDictionary;
    private String valuePl;
    private String valueEn;

    @Id
    @Column(name = "ID_DICTIONARY")
    public String getIdDictionary() {
        return idDictionary;
    }

    public void setIdDictionary(String idDictionary) {
        this.idDictionary = idDictionary;
    }

    @Basic
    @Column(name = "VALUE_PL")
    public String getValuePl() {
        return valuePl;
    }

    public void setValuePl(String valuePl) {
        this.valuePl = valuePl;
    }

    @Basic
    @Column(name = "VALUE_EN")
    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;

        if (idDictionary != null ? !idDictionary.equals(that.idDictionary) : that.idDictionary != null) return false;
        if (valuePl != null ? !valuePl.equals(that.valuePl) : that.valuePl != null) return false;
        if (valueEn != null ? !valueEn.equals(that.valueEn) : that.valueEn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionary != null ? idDictionary.hashCode() : 0;
        result = 31 * result + (valuePl != null ? valuePl.hashCode() : 0);
        result = 31 * result + (valueEn != null ? valueEn.hashCode() : 0);
        return result;
    }
}
