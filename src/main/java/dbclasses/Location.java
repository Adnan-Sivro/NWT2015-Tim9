package dbclasses;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by XenoGearX on 23.3.2015.
 */
@Entity
public class Location {
    private int idlocation;
    private String address;
    private float latitude;
    private float longitude;

    @Id
    @Column(name = "idlocation", nullable = false, insertable = true, updatable = true)
    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "latitude", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (idlocation != location.idlocation) return false;
        if (Float.compare(location.latitude, latitude) != 0) return false;
        if (Float.compare(location.longitude, longitude) != 0) return false;
        if (address != null ? !address.equals(location.address) : location.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idlocation;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        return result;
    }
}
