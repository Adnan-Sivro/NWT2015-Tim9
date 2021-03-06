import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by Adnan on 19.5.2015..
 */
@Entity
@Table(name = "resource", schema = "", catalog = "hotel")
@IdClass(ResourceEnPK.class)
public class ResourceEn {
    private int idresource;
    private String name;
    private byte[] occupied;
    private byte[] available;
    private String availabilityStatus;
    private Timestamp availabilityDate;
    private int resourceTypeIdresourceType;
    private int keycardIdkeycard;
    private int userIduser;

    @Id
    @Column(name = "idresource")
    public int getIdresource() {
        return idresource;
    }

    public void setIdresource(int idresource) {
        this.idresource = idresource;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "occupied")
    public byte[] getOccupied() {
        return occupied;
    }

    public void setOccupied(byte[] occupied) {
        this.occupied = occupied;
    }

    @Basic
    @Column(name = "available")
    public byte[] getAvailable() {
        return available;
    }

    public void setAvailable(byte[] available) {
        this.available = available;
    }

    @Basic
    @Column(name = "availability_status")
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Basic
    @Column(name = "availability_date")
    public Timestamp getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(Timestamp availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    @Id
    @Column(name = "resource_type_idresource_type")
    public int getResourceTypeIdresourceType() {
        return resourceTypeIdresourceType;
    }

    public void setResourceTypeIdresourceType(int resourceTypeIdresourceType) {
        this.resourceTypeIdresourceType = resourceTypeIdresourceType;
    }

    @Id
    @Column(name = "keycard_idkeycard")
    public int getKeycardIdkeycard() {
        return keycardIdkeycard;
    }

    public void setKeycardIdkeycard(int keycardIdkeycard) {
        this.keycardIdkeycard = keycardIdkeycard;
    }

    @Id
    @Column(name = "user_iduser")
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

        ResourceEn that = (ResourceEn) o;

        if (idresource != that.idresource) return false;
        if (resourceTypeIdresourceType != that.resourceTypeIdresourceType) return false;
        if (keycardIdkeycard != that.keycardIdkeycard) return false;
        if (userIduser != that.userIduser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(occupied, that.occupied)) return false;
        if (!Arrays.equals(available, that.available)) return false;
        if (availabilityStatus != null ? !availabilityStatus.equals(that.availabilityStatus) : that.availabilityStatus != null)
            return false;
        if (availabilityDate != null ? !availabilityDate.equals(that.availabilityDate) : that.availabilityDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idresource;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (occupied != null ? Arrays.hashCode(occupied) : 0);
        result = 31 * result + (available != null ? Arrays.hashCode(available) : 0);
        result = 31 * result + (availabilityStatus != null ? availabilityStatus.hashCode() : 0);
        result = 31 * result + (availabilityDate != null ? availabilityDate.hashCode() : 0);
        result = 31 * result + resourceTypeIdresourceType;
        result = 31 * result + keycardIdkeycard;
        result = 31 * result + userIduser;
        return result;
    }
}
