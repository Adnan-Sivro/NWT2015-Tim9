package dbclasses;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Enes on 18.5.2015..
 */
@Entity
@Table(name = "food_order", schema = "", catalog = "hotel")
@IdClass(FoodOrderPK.class)
public class FoodOrder {
    private int idfoodOrder;
    private String orderName;
    private Timestamp oderDate;
    private int amount;
    private float orderPrice;
    private int userIduser;
    private int foodMenuIdfood;

    @Id
    @Column(name = "idfood_order")
    public int getIdfoodOrder() {
        return idfoodOrder;
    }

    public void setIdfoodOrder(int idfoodOrder) {
        this.idfoodOrder = idfoodOrder;
    }

    @Basic
    @Column(name = "order_name")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "oder_date")
    public Timestamp getOderDate() {
        return oderDate;
    }

    public void setOderDate(Timestamp oderDate) {
        this.oderDate = oderDate;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "order_price")
    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Id
    @Column(name = "user_iduser")
    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    @Id
    @Column(name = "food_menu_idfood")
    public int getFoodMenuIdfood() {
        return foodMenuIdfood;
    }

    public void setFoodMenuIdfood(int foodMenuIdfood) {
        this.foodMenuIdfood = foodMenuIdfood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodOrder foodOrder = (FoodOrder) o;

        if (amount != foodOrder.amount) return false;
        if (foodMenuIdfood != foodOrder.foodMenuIdfood) return false;
        if (idfoodOrder != foodOrder.idfoodOrder) return false;
        if (Float.compare(foodOrder.orderPrice, orderPrice) != 0) return false;
        if (userIduser != foodOrder.userIduser) return false;
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
        result = 31 * result + userIduser;
        result = 31 * result + foodMenuIdfood;
        return result;
    }
}
