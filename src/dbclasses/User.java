import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Adnan on 19.5.2015..
 */
@Entity
@Table(name = "user", schema = "", catalog = "hotel")
public class UserEn {
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
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "user_type")
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "activated_date")
    public Timestamp getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Timestamp activatedDate) {
        this.activatedDate = activatedDate;
    }

    @Basic
    @Column(name = "deactivated_date")
    public Timestamp getDeactivatedDate() {
        return deactivatedDate;
    }

    public void setDeactivatedDate(Timestamp deactivatedDate) {
        this.deactivatedDate = deactivatedDate;
    }

    @Basic
    @Column(name = "confirmation_key")
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

        UserEn userEn = (UserEn) o;

        if (iduser != userEn.iduser) return false;
        if (userType != userEn.userType) return false;
        if (username != null ? !username.equals(userEn.username) : userEn.username != null) return false;
        if (password != null ? !password.equals(userEn.password) : userEn.password != null) return false;
        if (email != null ? !email.equals(userEn.email) : userEn.email != null) return false;
        if (createdDate != null ? !createdDate.equals(userEn.createdDate) : userEn.createdDate != null) return false;
        if (activatedDate != null ? !activatedDate.equals(userEn.activatedDate) : userEn.activatedDate != null)
            return false;
        if (deactivatedDate != null ? !deactivatedDate.equals(userEn.deactivatedDate) : userEn.deactivatedDate != null)
            return false;
        if (confirmationKey != null ? !confirmationKey.equals(userEn.confirmationKey) : userEn.confirmationKey != null)
            return false;

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
