package pl.wipek.users.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Krzysztof Adamczyk on 24.09.2017.
 */
@Entity
public class Users implements Serializable {
    private String idUsers;
    private String login;

    @Id
    @Column(name = "ID_USERS", nullable = false)
    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, length = 20)
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
