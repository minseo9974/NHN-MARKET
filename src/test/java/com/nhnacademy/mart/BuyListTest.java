package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyListTest {
    private BuyList buyList;

    @BeforeEach
    void setUp() {
        buyList = new BuyList();
    }

    @Test
    @DisplayName("구매리스트 상품 추가 Test")
    void buyListAddTest() {
        BuyList.Item item = new BuyList.Item("양파", 2);
        buyList.add(item);
        System.out.println(buyList);
        //구매리스트 크기 비교
        Assertions.assertEquals(1,buyList.getArrayList().size());
        //구매리스트 잘들어갔는지 확인
        Assertions.assertEquals(item,buyList.getArrayList().get(0));
    }

    @Test
    @DisplayName("음수가 들어왔을때 예외처리")
    void underZeroTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new BuyList.Item("사과", -3);
        });
    }
}