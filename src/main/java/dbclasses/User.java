package dbclasses;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by XenoGearX on 23.3.2015.
 */
@Entity
public class User {
    private int iduser;
    private String username;
    private String password;
    private String email;
    private byte userType;
    private Timestamp createdDate;
    private Timestamp activatedDate;
    private Timestamp deactivatedDate;
    private String confirmationKey;

    @Id
    @Column(name = "iduser", nullable = false, insertable = true, updatable = true)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "user_type", nullable = false, insertable = true, updatable = true)
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "created_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "activated_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Timestamp activatedDate) {
        this.activatedDate = activatedDate;
    }

    @Basic
    @Column(name = "deactivated_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getDeactivatedDate() {
        return deactivatedDate;
    }

    public void setDeactivatedDate(Timestamp deactivatedDate) {
        this.deactivatedDate = deactivatedDate;
    }

    @Basic
    @Column(name = "confirmation_key", nullable = false, insertable = true, updatable = true, length = 40)
    public String getConfirmationKey() {
        return confirmationKey;
    }

    public void setConfirmationKey(String confirmationKey) {
        this.confirmationKey = confirmationKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (iduser != user.iduser) return false;
        if (userType != user.userType) return false;
        if (activatedDate != null ? !activatedDate.equals(user.activatedDate) : user.activatedDate != null)
            return false;
        if (confirmationKey != null ? !confirmationKey.equals(user.confirmationKey) : user.confirmationKey != null)
            return false;
        if (createdDate != null ? !createdDate.equals(user.createdDate) : user.createdDate != null) return false;
        if (deactivatedDate != null ? !deactivatedDate.equals(user.deactivatedDate) : user.deactivatedDate != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) userType;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (activatedDate != null ? activatedDate.hashCode() : 0);
        result = 31 * result + (deactivatedDate != null ? deactivatedDate.hashCode() : 0);
        result = 31 * result + (confirmationKey != null ? confirmationKey.hashCode() : 0);
        return result;
    }
}
