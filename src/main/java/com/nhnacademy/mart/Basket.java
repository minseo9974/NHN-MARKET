package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 장바구니 클래스입니다.
 */
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();
    public Basket(){
    }

    /**
     * 장바구니에 음식을 추가하는 클래스입니다.
     * @param food
     */
    public void add(Food food) {
        foods.add(food);
        MyLogger.getLogger().trace("{}을 추가 했습니다.", food.getName());
    }
    public ArrayList<Food> getBasketFood(){
        return foods;
    }
}
