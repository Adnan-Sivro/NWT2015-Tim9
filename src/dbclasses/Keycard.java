import javax.persistence.*;

/**
 * Created by Adnan on 19.5.2015..
 */
@Entity
@Table(name = "keycard", schema = "", catalog = "hotel")
public class KeycardEn {
    private int idkeycard;
    private String number;
    private String accessIdentifier;

    @Id
    @Column(name = "idkeycard")
    public int getIdkeycard() {
        return idkeycard;
    }

    public void setIdkeycard(int idkeycard) {
        this.idkeycard = idkeycard;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "access_identifier")
    public String getAccessIdentifier() {
        return accessIdentifier;
    }

    public void setAccessIdentifier(String accessIdentifier) {
        this.accessIdentifier = accessIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeycardEn keycardEn = (KeycardEn) o;

        if (idkeycard != keycardEn.idkeycard) return false;
        if (number != null ? !number.equals(keycardEn.number) : keycardEn.number != null) return false;
        if (accessIdentifier != null ? !accessIdentifier.equals(keycardEn.accessIdentifier) : keycardEn.accessIdentifier != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idkeycard;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (accessIdentifier != null ? accessIdentifier.hashCode() : 0);
        return result;
    }
}
