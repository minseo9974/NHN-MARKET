package com.nhnacademy.mart;

public class NhnMart {

    private final FoodStand foodStand = new FoodStand();

    /**
     * 식품매대를 채웁니다.
     */
    public void prepareMart() {
        MyLogger.getLogger().trace("마트가 준비가 되었습니다.");
        fillFoodStand();
    }
    // 음식 세팅

    /**
     * 음식을 세팅합니다.
     */
    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    /**
     * 장바구니를 가져옵니다.
     * @return
     */
    public Basket provideBasket() {
        return new Basket();
    }

    /**
     * 식품매대를 가져옵니다.
     * @return
     */
    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    /**
     * 계산합니다.
     * @return
     */
    public Counter getCounter() {

        // TODO
         return new Counter();
    }
}
