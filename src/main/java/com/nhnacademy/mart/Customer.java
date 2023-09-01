package com.nhnacademy.mart;

import java.util.ArrayList;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;
    // 고객 장바구니
    private Basket basket;
    private int money = 20_000;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> items = buyList.getArrayList();


        // 구매 리스트를 돌면서 구매리스트 목록과 맞는 과일이 재고에 있다면 뺀다.
        for (BuyList.Item i : items) {
            Food food = foodStand.get(i.getName());
            if(food == null){
                continue;
            }

            // 뻰 재고를 장바구니에 채워준다.
            basket.add(food);
            foodStand.deleteFood(food);
        }
    }


    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {

    }

}
