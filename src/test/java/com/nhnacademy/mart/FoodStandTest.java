package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {
    private FoodStand foodStand;

    @BeforeEach
    void setUp() {
        foodStand = new FoodStand();
    }

    @Test
    @DisplayName("식품 매대에 음식이 추가 되는지 Test")
    void foodStandAddTest() {
        foodStand.add(new Food("양파", 1_000));
        foodStand.add(new Food("계란", 5_000));
        foodStand.add(new Food("파", 500));
        foodStand.add(new Food("사과", 2_000));

        Assertions.assertEquals("양파", foodStand.getFood("양파").getName());
        Assertions.assertEquals("계란", foodStand.getFood("계란").getName());
        Assertions.assertEquals("파", foodStand.getFood("파").getName());
        Assertions.assertEquals("사과", foodStand.getFood("사과").getName());
    }

    @Test
    @DisplayName("식품 매대에서 음식 삭제 Test")
    void foodStandDeleteTest() {
        Food Onion = new Food("양파", 1_000);
        Food Egg = new Food("계란", 5_000);
        Food GreenOnion = new Food("파", 500);
        Food Apple = new Food("사과", 2_000);

        foodStand.add(Onion);
        foodStand.add(Egg);
        foodStand.add(GreenOnion);
        foodStand.add(Apple);

        foodStand.deleteFood(Onion);
        foodStand.deleteFood(Apple);

        Assertions.assertNull(foodStand.getFood("사과"));
        Assertions.assertNull(foodStand.getFood("양파"));

        Assertions.assertEquals(2,foodStand.getSize());
    }
}