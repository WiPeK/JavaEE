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
public class Users implements Serializable {
    private static final long serialVersionUID = -6580012241620579129L;

    private String idUsers;
    private String login;

    @Id
    @Column(name = "ID_USERS")
    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (idUsers != null ? !idUsers.equals(users.idUsers) : users.idUsers != null) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers != null ? idUsers.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}
