import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Adnan on 19.5.2015..
 */
@Entity
@Table(name = "food_order", schema = "", catalog = "hotel")
@IdClass(FoodOrderEnPK.class)
public class FoodOrderEn {
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

        FoodOrderEn that = (FoodOrderEn) o;

        if (idfoodOrder != that.idfoodOrder) return false;
        if (amount != that.amount) return false;
        if (Float.compare(that.orderPrice, orderPrice) != 0) return false;
        if (userIduser != that.userIduser) return false;
        if (foodMenuIdfood != that.foodMenuIdfood) return false;
        if (orderName != null ? !orderName.equals(that.orderName) : that.orderName != null) return false;
        if (oderDate != null ? !oderDate.equals(that.oderDate) : that.oderDate != null) return false;

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
