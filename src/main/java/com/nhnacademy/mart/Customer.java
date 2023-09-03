package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 고객 클래스입니다.
 */
public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;
    // 고객 장바구니
    private Basket basket;
    // 고객 총 보유 금액
    private int money = 20_000;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }
    //Test 코드를 위한 장바구니 반환용 메서드
    public Basket getBasket(){return basket;}

    // TODO pickFoods 메서드 구현

    /**
     * 음식을 구매리스트에서 보고 매대에서 가져와서 장바구니에 담는 메서드입니다.
     * @param foodStand
     */
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> items = buyList.getArrayList();

        // 구매 리스트를 돌면서 구매리스트 목록과 맞는 과일이 재고에 있다면 뺀다.
        for (BuyList.Item item : items) {
            Food food = foodStand.getFood(item.getName());
            if (food == null) {
                throw new IllegalArgumentException("식품 매대에 없는 상품을 고르셨습니다.");
            }
            //고른 음식이 상품 매대에 재고가 얼마나 있는지 반환
            int foodCount = foodStand.getFoodAmount(food);

            //구매 리스트에 담긴 구매하려는 음식 개수
            int Amount = item.getAmount();

            if (Amount > foodCount) {
                throw new IllegalArgumentException("고르신 상품이 재고가 부족합니다.");
            }
            //음식을 고른 개수만큼 재고에서 빼낸다.
            while (Amount-- > 0) {
                // 뻰 재고를 장바구니에 채워준다.
                foodStand.deleteFood(food);
                basket.add(food);
            }
        }
    }

    // TODO payTox 메서드 구현

    /**
     * 가격을 계산합니다.
     * @param counter
     */
    public void payTox(Counter counter) {
        try {
            counter.total(basket);

            counter.pay(money);
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            MyLogger.getLogger().error(e.getMessage());
        }
    }

}
