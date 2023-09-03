package com.nhnacademy.mart;

import java.util.Scanner;

/**
 * 프로그램 메인 클래스 입니다.
 */
public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();


        try {
            BuyList buyList = inputBuyListFromShell();

            // TODO 본인이름 영어로 변수명 작성!
            Customer minseo = new Customer(buyList);

            // 장바구니를 챙긴다.
            minseo.bring(mart.provideBasket());
            // 식품을 담는다.
            minseo.pickFoods(mart.getFoodStand());

            // 카운터에서 계산한다.
            minseo.payTox(mart.getCounter());

        } catch (IllegalArgumentException e) {
            MyLogger.getLogger().error(e.getMessage());
        }
    }

    /**
     * 입력받는 클래스입니다.
     * @return
     * @throws IllegalArgumentException
     */

    private static BuyList inputBuyListFromShell() throws IllegalArgumentException {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.print("> ");

        String s = sc.nextLine();
//        String s = "양파 2 계란 2 파 4";
        String arr[] = s.split(" ");
        if(arr.length == 1|| arr.length==0){
            throw new IllegalArgumentException("제대로 입력해주세요.");
        }
        BuyList buyList = new BuyList();

        for (int i = arr.length % 2; i < arr.length; i += 2) {
            BuyList.Item item = new BuyList.Item(arr[i], Integer.valueOf(arr[i + 1]));
            buyList.add(item);
        }

        return buyList;
    }
}
