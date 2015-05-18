package dbclasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Enes on 18.5.2015..
 */
public class ResourcePK implements Serializable {
    private int idresource;

    @Column(name = "idresource")
    @Id
    public int getIdresource() {
        return idresource;
    }

    public void setIdresource(int idresource) {
        this.idresource = idresource;
    }

    private int resourceTypeIdresourceType;

    @Column(name = "resource_type_idresource_type")
    @Id
    public int getResourceTypeIdresourceType() {
        return resourceTypeIdresourceType;
    }

    public void setResourceTypeIdresourceType(int resourceTypeIdresourceType) {
        this.resourceTypeIdresourceType = resourceTypeIdresourceType;
    }

    private int keycardIdkeycard;

    @Column(name = "keycard_idkeycard")
    @Id
    public int getKeycardIdkeycard() {
        return keycardIdkeycard;
    }

    public void setKeycardIdkeycard(int keycardIdkeycard) {
        this.keycardIdkeycard = keycardIdkeycard;
    }

    private int userIduser;

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

        ResourcePK that = (ResourcePK) o;

        if (idresource != that.idresource) return false;
        if (keycardIdkeycard != that.keycardIdkeycard) return false;
        if (resourceTypeIdresourceType != that.resourceTypeIdresourceType) return false;
        if (userIduser != that.userIduser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idresource;
        result = 31 * result + resourceTypeIdresourceType;
        result = 31 * result + keycardIdkeycard;
        result = 31 * result + userIduser;
        return result;
    }
}
