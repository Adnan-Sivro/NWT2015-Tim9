import javax.persistence.*;

/**
 * Created by Adnan on 19.5.2015..
 */
@Entity
@Table(name = "resource_type", schema = "", catalog = "hotel")
public class ResourceTypeEn {
    private int idresourceType;
    private String name;
    private String description;
    private float price;
    private int qunatity;

    @Id
    @Column(name = "idresource_type")
    public int getIdresourceType() {
        return idresourceType;
    }

    public void setIdresourceType(int idresourceType) {
        this.idresourceType = idresourceType;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "qunatity")
    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceTypeEn that = (ResourceTypeEn) o;

        if (idresourceType != that.idresourceType) return false;
        if (Float.compare(that.price, price) != 0) return false;
        if (qunatity != that.qunatity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idresourceType;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + qunatity;
        return result;
    }
}
