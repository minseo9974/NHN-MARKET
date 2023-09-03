package com.nhnacademy.mart;

/**
 * 음식 클래스입니다.
 */
public class Food {

    private final String name;
    private final int price;

    public Food(String name,int price){
        MyLogger.getLogger().debug("Food가 생성되었습니다.(name : {} , Price: {})", name, price);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
