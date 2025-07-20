package org.example;

import effects.dungeon.DungeonEffect;
import org.example.Monster;
import org.example.Player;

import java.util.Scanner;

public class CombatSystem {
    private final Player player;
    private final Monster monster;
    private final DungeonEffect effect;
    private final Scanner scanner = new Scanner(System.in);

    public CombatSystem(Player player, Monster monster, DungeonEffect effect) {
        this.player = player;
        this.monster = monster;
        this.effect = effect;
    }

    public void startCombat() {
        System.out.println("⚔ 전투 시작! 상대: " + monster.getName());
        effect.onEnter(player);

        int turn = 1;

        while (player.isAlive() && monster.isAlive()) {
            System.out.println("\n▶ 턴 " + turn);
            player.resetTurn();

            // 던전 효과 적용 (예: TimeLimit)
            effect.onCombatTurn(player, monster, turn);

            // 몬스터가 도망쳤다면 종료
            if (!monster.isAlive()) break;

            // 플레이어의 행동
            playerAction();

            // 몬스터 반격
            if (monster.isAlive()) {
                monster.attack(player);
            }

            turn++;
        }

        if (player.isAlive() && !monster.isAlive()) {
            System.out.println(" 몬스터 처치 성공!");
            player.gainExp(monster.getExp());
        } else if (!player.isAlive()) {
            System.out.println(" 당신은 패배했습니다...");
        }
    }

    private void playerAction() {
        System.out.println("1. 공격하기");
        System.out.println("2. 아이템 사용");

        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // 잘못된 입력 제거
            }
        }

        if (choice == 1) {
            player.attack(monster);
        } else {
            if (player.hasUsedItemThisTurn()) {
                System.out.println(" 이번 턴엔 이미 아이템을 사용했습니다. 공격으로 전환합니다.");
                player.attack(monster);
                return;
            }

            if (player.getInventory().isEmpty()) {
                System.out.println("인벤토리에 사용 가능한 아이템이 없습니다. 공격으로 전환합니다.");
                player.attack(monster);
                return;
            }

            player.getInventory().showInventory();
            System.out.print("사용할 아이템 번호 선택: ");
            int itemChoice = scanner.nextInt() - 1;
            player.getInventory().useItem(itemChoice, player);
        }
    }
}
