package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food){
        foods.add(food);
    }
    public int getSize(){
        return foods.size();
    }

    public Food getFood(String food){
        for (Food f:foods) {
            //구매리스트를 파라미터로 가져와 상품 매대의 음식과 같으면 가져간다.
            if(f.getName().equals(food)){
                return f;
            }
        }
        //식품 매대에 없는 상품 구매 경우
        return null;
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public void deleteFood(Food food){
        foods.remove(food);
    }
    public int getFoodAmount(Food food){
        int count = 0;
        for (Food f:foods) {
            if(food.getName().equals(f.getName())){
                count++;
            }
        }
        return count;
    }
}
