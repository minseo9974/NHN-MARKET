package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();
    public BuyList(){}
    // TODO add 메서드 생성
    public void add(Item item){
        items.add(item);
    }
    public ArrayList<Item> getArrayList(){
        return items;
    }
    @Override
    public String toString() {
        return "BuyList" + items;
    }

    public static class Item {
        private final String name;
        private final int amount;
        public Item(String name,int amount){
            this.name = name;
            this.amount = amount;
            classInvariant();
        }

        private void classInvariant() {
            if(getAmount() < 0 ){
                throw new IllegalArgumentException("수량이 음수가 될수 없습니다.");
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", amount=" + amount +
                    '}';
        }

        public int getAmount() {
            return amount;
        }
    }
}
