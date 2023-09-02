package com.nhnacademy.mart;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasketTest {
    private Basket basket;

    @BeforeEach
    void setup() {
        basket = new Basket();
    }

    @Test
    @DisplayName("장바구니 크기 맞는지 테스트")
    void basketSizeTest() {
        Food Onion = new Food("양파", 1_000);
        Food Egg = new Food("계란", 5_000);
        Food GreenOnion = new Food("파", 500);
        Food Apple = new Food("사과", 2_000);

        basket.add(Onion);
        basket.add(Egg);
        basket.add(GreenOnion);
        basket.add(Apple);

        Assertions.assertEquals(4, basket.getBasketFood().size());

    }

    @Test
    @DisplayName("장바구니에 음식이 정확하게 들어있는지 테스트")
    void getBasketFoodTest() {
        Food Onion = new Food("양파", 1_000);
        Food Egg = new Food("계란", 5_000);
        Food GreenOnion = new Food("파", 500);
        Food Apple = new Food("사과", 2_000);

        basket.add(Onion);
        basket.add(Egg);
        basket.add(GreenOnion);
        basket.add(Apple);

        ArrayList<Food> basketFood = basket.getBasketFood();

        Assertions.assertTrue(basketFood.contains(Onion));
        Assertions.assertTrue(basketFood.contains(Egg));
        Assertions.assertTrue(basketFood.contains(GreenOnion));
        Assertions.assertTrue(basketFood.contains(Apple));
    }
}