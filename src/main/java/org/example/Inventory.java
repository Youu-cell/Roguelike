package org.example;

import items.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    // 아이템 추가
    public void addItem(Item item) {
        items.add(item);
        System.out.println(" 아이템 " + item.getName() + " 을(를) 인벤토리에 추가했습니다.");
    }

    // 아이템 사용
    public void useItem(int index, Player player) {
        if (index < 0 || index >= items.size()) {
            System.out.println(" 유효하지 않은 선택입니다.");
            return;
        }
        Item item = items.remove(index);
        player.useItem(item);
    }

    // 아이템 목록 출력
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println(" 인벤토리에 아이템이 없습니다.");
            return;
        }

        System.out.println(" 인벤토리:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
    }

    // 아이템 수 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}


