package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 계산하는 메서드입니다.
 */
public class Counter {
    private int totalPrice;

    public Counter() {
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * 총가격을 계산하는 메서드입니다.
     * @param basket
     * @return
     */
    public int total(Basket basket) {
        ArrayList<Food> basketFood = basket.getBasketFood();
        int sum = 0;
        for (Food foods : basketFood) {
            sum = sum + foods.getPrice();
        }
        System.out.println("총 가격은 " + sum + "원 입니다.");
        MyLogger.getLogger().debug("가격 {}", sum);
        setTotalPrice(sum);
        return sum;
    }

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    // TODO 돈이 초과하는 상품 구매

    /**
     * 보유 돈에서 총 가격을 계산하는 메서드입니다.
     * @param money
     */
    public void pay(int money) {
        if(money<getTotalPrice()){
            throw new IllegalArgumentException("돈을 초과하는 상품 입니다.");
        }
        System.out.println("고객님 결제 후 잔액 : "+(money-getTotalPrice()));
    }
}
