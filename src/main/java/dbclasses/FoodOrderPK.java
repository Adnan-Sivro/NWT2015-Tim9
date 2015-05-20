package dbclasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Adnan on 20.5.2015..
 */
public class FoodOrderPK implements Serializable {
    private int idfoodOrder;
    private int userIduser;
    private int foodMenuIdfood;

    @Column(name = "idfood_order")
    @Id
    public int getIdfoodOrder() {
        return idfoodOrder;
    }

    public void setIdfoodOrder(int idfoodOrder) {
        this.idfoodOrder = idfoodOrder;
    }

    @Column(name = "user_iduser")
    @Id
    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    @Column(name = "food_menu_idfood")
    @Id
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

        FoodOrderPK that = (FoodOrderPK) o;

        if (idfoodOrder != that.idfoodOrder) return false;
        if (userIduser != that.userIduser) return false;
        if (foodMenuIdfood != that.foodMenuIdfood) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfoodOrder;
        result = 31 * result + userIduser;
        result = 31 * result + foodMenuIdfood;
        return result;
    }
}
