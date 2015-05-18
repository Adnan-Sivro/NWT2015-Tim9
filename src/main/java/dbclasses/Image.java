package dbclasses;

import javax.persistence.*;

/**
 * Created by Enes on 18.5.2015..
 */
@Entity
@IdClass(ImagePK.class)
public class Image {
    private int idimage;
    private String name;
    private String location;
    private String description;
    private int resourceTypeIdresourceType;

    @Id
    @Column(name = "idimage")
    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
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
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "resource_type_idresource_type")
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

        Image image = (Image) o;

        if (idimage != image.idimage) return false;
        if (resourceTypeIdresourceType != image.resourceTypeIdresourceType) return false;
        if (description != null ? !description.equals(image.description) : image.description != null) return false;
        if (location != null ? !location.equals(image.location) : image.location != null) return false;
        if (name != null ? !name.equals(image.name) : image.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idimage;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + resourceTypeIdresourceType;
        return result;
    }
}
