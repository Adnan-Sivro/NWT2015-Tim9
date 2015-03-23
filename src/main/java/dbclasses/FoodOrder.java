package dbclasses;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by XenoGearX on 23.3.2015.
 */
@Entity
@Table(name = "food_order", schema = "", catalog = "hotel")
public class FoodOrder {
    private int idfoodOrder;
    private String orderName;
    private Timestamp oderDate;
    private int amount;
    private float orderPrice;
    private List<FoodMenu> foodMenuIdfood;
    private List<User> userIduser;

    @Id
    @Column(name = "idfood_order", nullable = false, insertable = true, updatable = true)
    public int getIdfoodOrder() {
        return idfoodOrder;
    }

    public void setIdfoodOrder(int idfoodOrder) {
        this.idfoodOrder = idfoodOrder;
    }

    @Basic
    @Column(name = "order_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "oder_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getOderDate() {
        return oderDate;
    }

    public void setOderDate(Timestamp oderDate) {
        this.oderDate = oderDate;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = true)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "order_price", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodOrder foodOrder = (FoodOrder) o;

        if (amount != foodOrder.amount) return false;
        if (idfoodOrder != foodOrder.idfoodOrder) return false;
        if (Float.compare(foodOrder.orderPrice, orderPrice) != 0) return false;
        if (oderDate != null ? !oderDate.equals(foodOrder.oderDate) : foodOrder.oderDate != null) return false;
        if (orderName != null ? !orderName.equals(foodOrder.orderName) : foodOrder.orderName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfoodOrder;
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (oderDate != null ? oderDate.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (orderPrice != +0.0f ? Float.floatToIntBits(orderPrice) : 0);
        return result;
    }

    @OneToMany
    public List<FoodMenu> getFoodMenuIdfood() {
        return foodMenuIdfood;
    }

    public void setFoodMenuIdfood(List<FoodMenu> foodMenuIdfood) {
        this.foodMenuIdfood = foodMenuIdfood;
    }

    @OneToMany
    public List<User> getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(List<User> userIduser) {
        this.userIduser = userIduser;
    }
}
