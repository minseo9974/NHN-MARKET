package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food){
        foods.add(food);
    }
    public Food get(String food){
        for (Food f:foods) {
            if(f.getName().equals(f)){
                return f;
            }
        }
        return null;
    }
    // TODO 장바구니에 담은 Food 삭제 구현
    public void deleteFood(Food food){
        foods.remove(food);
    }
}
