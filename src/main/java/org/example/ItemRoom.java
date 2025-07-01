package org.example;

import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ItemRoom {
    private List<Item> items;

    public ItemRoom(int floor) {
        items = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int roll = random.nextInt(4); // 아이템 4종류 중 하나
            switch (roll) {
                case 0: items.add(new Healing(floor)); break;
                case 1: items.add(new AttackUp(floor)); break;
                case 2: items.add(new LuckUp(floor)); break;
                case 3: items.add(new Debuff(floor)); break;
            }
        }
    }

    public void enter(Player player) {
        System.out.println("🎁 아이템 룸에 입장했습니다!");
        System.out.println("다음 아이템 중 하나를 선택하세요:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > items.size()) {
            System.out.print("선택 (1~" + items.size() + "): ");
            choice = scanner.nextInt();
        }

        Item selectedItem = items.get(choice - 1);
        System.out.println("👉 " + selectedItem.getName() + "을(를) 선택했습니다!");
        player.useItem(selectedItem);
    }
}

