package com.nhnacademy.mart;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    private final int MONEY = 20_000;
    private NhnMart nhnMart;
    private Customer minseo;
    private FoodStand foodStand;
    private BuyList buyList;
    @BeforeEach
    void setup() {
        nhnMart = new NhnMart();
        nhnMart.prepareMart();

        //inputBuyListFromShell 메서드 대신 입력
        buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 2));
        buyList.add(new BuyList.Item("계란", 2));
        buyList.add(new BuyList.Item("파", 2));

        foodStand = new FoodStand();

    }

    @Test
    @DisplayName("장바구니에 제대로 담겼는지 Test")
    void pickFoodsSuccessTest(){
        minseo = new Customer(buyList);
        minseo.bring(nhnMart.provideBasket());

        //아래 메서드가 성공적으로 돌았다면 구매리스트 품목이
        //그대로 장바구니에 담겼을 것이다
        //구매리스트 개수 == 장바구니 개수 확인하기
        minseo.pickFoods(nhnMart.getFoodStand());

        //구매리스트에 담긴 품목 개수
        int count = 0;

        ArrayList<BuyList.Item> arrayList = buyList.getArrayList();
        for (BuyList.Item item : arrayList) {
            count+= item.getAmount();
        }

        Assertions.assertEquals(count,minseo.getBasket().getBasketFood().size());
    }

    @Test
    @DisplayName("식품 매대에 없는 상품을 골랐을 경우")
    void noneexistFoodTest(){
        //없는 상품 토마토 입력
        buyList.add(new BuyList.Item("토마토", 2));
        minseo = new Customer(buyList);
        minseo.bring(nhnMart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            minseo.pickFoods(nhnMart.getFoodStand());
        });
    }

    @Test
    @DisplayName("고른 상품이 재고가 부족한 경우")
    void noneStuckFoodTest(){
        //식품 매대 파 개수 : 10
        //내가 고른 파 개수 : 12
        buyList.add(new BuyList.Item("파",10));
        minseo = new Customer(buyList);
        minseo.bring(nhnMart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            minseo.pickFoods(nhnMart.getFoodStand());
        });
    }

    @Test
    @DisplayName("계산이 성공적으로 이뤄진 경우")
    void payToxSuccessTest() {
        minseo = new Customer(buyList);
        minseo.bring(nhnMart.provideBasket());
        minseo.pickFoods(nhnMart.getFoodStand());
        Basket basket = minseo.getBasket();
        //상품 가격 총합
        int sum = 0;
        for (Food foods: basket.getBasketFood()) {
            sum+= foods.getPrice();
        }

        Counter counter = nhnMart.getCounter();

        //총 가격이 잘 들어갔는지 확인
        Assertions.assertEquals(sum,counter.total(basket));

        Assertions.assertEquals(MONEY-sum,MONEY - counter.getTotalPrice());
    }

    @Test
    @DisplayName("돈을 초과하는 상품을 고른 경우")
    void payToxOverTest(){
        //계란을 추가함으로 가진돈 20_000원을 넘는다.
        buyList.add(new BuyList.Item("계란",2));
        minseo = new Customer(buyList);
        minseo.bring(nhnMart.provideBasket());
        minseo.pickFoods(nhnMart.getFoodStand());

        Counter counter = nhnMart.getCounter();

        minseo.payTox(counter);

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            counter.pay(MONEY);
        });
    }
}