package dbclasses;

import javax.persistence.*;

/**
 * Created by Adnan on 20.5.2015..
 */
@Entity
@Table(name = "food_menu", schema = "", catalog = "hotel")
public class FoodMenu {
    private int idfood;
    private String name;
    private float price;
    private String description;
    private int amountAvailable;

    @Id
    @Column(name = "idfood")
    public int getIdfood() {
        return idfood;
    }

    public void setIdfood(int idfood) {
        this.idfood = idfood;
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
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
    @Column(name = "amount_available")
    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodMenu foodMenu = (FoodMenu) o;

        if (idfood != foodMenu.idfood) return false;
        if (Float.compare(foodMenu.price, price) != 0) return false;
        if (amountAvailable != foodMenu.amountAvailable) return false;
        if (name != null ? !name.equals(foodMenu.name) : foodMenu.name != null) return false;
        if (description != null ? !description.equals(foodMenu.description) : foodMenu.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfood;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + amountAvailable;
        return result;
    }
}
