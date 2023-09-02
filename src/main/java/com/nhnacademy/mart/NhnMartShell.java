package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer minseo = new Customer(buyList);

        // 장바구니를 챙긴다.
        minseo.bring(mart.provideBasket());

        try {
            // 식품을 담는다.
            minseo.pickFoods(mart.getFoodStand());

            // 카운터에서 계산한다.
            minseo.payTox(mart.getCounter());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.print("> ");

        String s = sc.nextLine();
//        String s = "양파 2 계란 2 파 4";
        String arr[] = s.split(" ");

        BuyList buyList = new BuyList();

        for (int i = arr.length % 2; i < arr.length; i += 2) {
            BuyList.Item item = new BuyList.Item(arr[i], Integer.valueOf(arr[i + 1]));
            buyList.add(item);
        }

        return buyList;
    }
}
