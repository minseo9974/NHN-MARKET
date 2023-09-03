package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 구매리스트 클래스입니다.
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();
    public BuyList(){}
    // TODO add 메서드 생성

    /**
     * 구매리스트에 추가하는 메서드입니다.
     * @param item
     */
    public void add(Item item){
        MyLogger.getLogger().trace("{}을 추가했습니다.", item.getName());
        items.add(item);
    }
    public ArrayList<Item> getArrayList(){
        return items;
    }
    @Override
    public String toString() {
        return "BuyList" + items;
    }

    /**
     * 구매리스트에 담게되는 음식과 수량을 나타내는 클래스입니다.
     */

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
