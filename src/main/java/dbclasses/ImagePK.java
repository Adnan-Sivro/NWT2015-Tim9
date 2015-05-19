package dbclasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Enes on 18.5.2015..
 */
public class ImagePK implements Serializable {
    private int idimage;
    private int resourceTypeIdresourceType;

    @Column(name = "idimage")
    @Id
    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }

    @Column(name = "resource_type_idresource_type")
    @Id
    public int getResourceTypeIdresourceType() {
        return resourceTypeIdresourceType;
    }

    public void setResourceTypeIdresourceType(int resourceTypeIdresourceType) {
        this.resourceTypeIdresourceType = resourceTypeIdresourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagePK imagePK = (ImagePK) o;

        if (idimage != imagePK.idimage) return false;
        if (resourceTypeIdresourceType != imagePK.resourceTypeIdresourceType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idimage;
        result = 31 * result + resourceTypeIdresourceType;
        return result;
    }
}
