package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {
    private Counter counter;
    private Basket basket;
    private final int MONEY = 20_000;
    @BeforeEach
    void setup(){
        counter = new Counter();
        basket = new Basket();

        Food Onion = new Food("양파", 1_000);
        Food Egg = new Food("계란", 5_000);
        Food GreenOnion = new Food("파", 500);
        Food Apple = new Food("사과", 2_000);

        basket.add(Onion);
        basket.add(Egg);
        basket.add(GreenOnion);
        basket.add(Apple);
    }

    @Test
    @DisplayName("장바구니에서 받은 품목들의 가격 총합")
    void totalPriceTest() {
        Assertions.assertEquals(counter.total(basket),8_500);
    }

    @Test
    @DisplayName("돈을 초과한다면 예외처리")
    void payTest() {
//        counter.total(basket);
//        counter.pay(MONEY);

        basket.add(new Food("계란", 5_000));
        basket.add(new Food("계란", 5_000));
        basket.add(new Food("계란", 5_000));

        counter.total(basket);

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            counter.pay(MONEY);
        });
    }
}