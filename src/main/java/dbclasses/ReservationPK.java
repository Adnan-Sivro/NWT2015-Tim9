package dbclasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Adnan on 20.5.2015..
 */
public class ReservationPK implements Serializable {
    private int idreservation;
    private int userIduser;

    @Column(name = "idreservation")
    @Id
    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    @Column(name = "user_iduser")
    @Id
    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationPK that = (ReservationPK) o;

        if (idreservation != that.idreservation) return false;
        if (userIduser != that.userIduser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idreservation;
        result = 31 * result + userIduser;
        return result;
    }
}
