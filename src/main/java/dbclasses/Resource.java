package dbclasses;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * Created by XenoGearX on 23.3.2015.
 */
@Entity
public class Resource {
    private int idresource;
    private String name;
    private byte[] occupied;
    private byte[] available;
    private String availabilityStatus;
    private Timestamp availabilityDate;
    private Keycard keycardIdkeycard;
    private List<ResourceType> resourceTypeIdresourceType;
    private List<User> userIduser;

    @Id
    @Column(name = "idresource", nullable = false, insertable = true, updatable = true)
    public int getIdresource() {
        return idresource;
    }

    public void setIdresource(int idresource) {
        this.idresource = idresource;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "occupied", nullable = false, insertable = true, updatable = true)
    public byte[] getOccupied() {
        return occupied;
    }

    public void setOccupied(byte[] occupied) {
        this.occupied = occupied;
    }

    @Basic
    @Column(name = "available", nullable = false, insertable = true, updatable = true)
    public byte[] getAvailable() {
        return available;
    }

    public void setAvailable(byte[] available) {
        this.available = available;
    }

    @Basic
    @Column(name = "availability_status", nullable = true, insertable = true, updatable = true, length = 64)
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Basic
    @Column(name = "availability_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(Timestamp availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (idresource != resource.idresource) return false;
        if (availabilityDate != null ? !availabilityDate.equals(resource.availabilityDate) : resource.availabilityDate != null)
            return false;
        if (availabilityStatus != null ? !availabilityStatus.equals(resource.availabilityStatus) : resource.availabilityStatus != null)
            return false;
        if (!Arrays.equals(available, resource.available)) return false;
        if (name != null ? !name.equals(resource.name) : resource.name != null) return false;
        if (!Arrays.equals(occupied, resource.occupied)) return false;

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
        return result;
    }

    @OneToOne
    @JoinColumn(name = "keycard_idkeycard", referencedColumnName = "idkeycard", nullable = false)
    public Keycard getKeycardIdkeycard() {
        return keycardIdkeycard;
    }

    public void setKeycardIdkeycard(Keycard keycardIdkeycard) {
        this.keycardIdkeycard = keycardIdkeycard;
    }

    @OneToMany
    public List<ResourceType> getResourceTypeIdresourceType() {
        return resourceTypeIdresourceType;
    }

    public void setResourceTypeIdresourceType(List<ResourceType> resourceTypeIdresourceType) {
        this.resourceTypeIdresourceType = resourceTypeIdresourceType;
    }

    @OneToMany
    public List<User> getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(List<User> userIduser) {
        this.userIduser = userIduser;
    }
}
