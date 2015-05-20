package services;


import dbclasses.FoodMenu;

/**
 * Created by Korisnik on 25.3.2015..
 */
public class FoodMenuService {

    public FoodMenu updateFoodMenu(int idfood) {
        FoodMenu foodmenu = new FoodMenu();
        try {

            foodmenu.setIdfood(idfood);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return foodmenu;

    }

}
