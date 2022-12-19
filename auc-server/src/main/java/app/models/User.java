package app.models;

import javax.persistence.*;
import app.security.SecureHasher;

import java.util.Objects;

@NamedQueries({
        @NamedQuery(name="Accounts_find_by_email",
                query = "select a from User a where a.email = ?1")
})
@Entity
@Table(name="ACCOUNT")
public class User {

    @Id
    @SequenceGenerator(name="user_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;
    private String name;
    private String email;
    private String hashedPassword;
    private String role;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String hashedPassword, String role) {
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.role = role;
    }

    public String hashPassword(String password) {
        return SecureHasher.secureHash("Id-" + this.getId() + ":" + password);
    }
    public void setPassword(String newPassword) {
        this.setHashedPassword(this.hashPassword(newPassword));
    }

    public boolean verfiyPassword(String password) {
        return this.hashPassword(password).equals(this.getHashedPassword());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return id == ((User) o).id;
    }

    @Override
    public String toString() {
        return String.format("{ login=%s, name=%s, id=%d }", this.email, this.name, this.id);
    }
}
