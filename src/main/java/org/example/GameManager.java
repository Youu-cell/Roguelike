package org.example;

import org.example.Dungeon;
import org.example.Room;
import org.example.Player;

import java.util.Scanner;

public class GameManager {
    private Player player;
    private Dungeon dungeon;
    private boolean isRunning = true;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 로그라이크 던전 탐험 ===");
        System.out.print("플레이어의 이름을 입력하세요: ");
        String name = scanner.nextLine();  // 사용자 이름 입력 받기

        player = new Player(name);         // 입력한 이름으로 플레이어 생성
        dungeon = new Dungeon(5);          // 총 5층 던전 생성

        runGameLoop();}

    private void runGameLoop() {
        while (isRunning && player.isAlive() && dungeon.hasNextRoom()) {
            Room currentRoom = dungeon.getNextRoom();

            System.out.println("\n--- 현재 층: " + dungeon.getCurrentFloor() + " ---");
            currentRoom.enter(player); // 전투 또는 아이템 선택

            if (!player.isAlive()) {
                System.out.println("\n💀 플레이어가 사망했습니다. 게임 오버!");
                isRunning = false;
                break;
            }

            dungeon.moveToNextFloor();
        }

        if (player.isAlive()) {
            System.out.println("\n🎉 던전을 모두 클리어했습니다! 축하합니다!");
        }

        endGame();
    }

    private void endGame() {
        System.out.println("\n=== 게임 종료 ===");
        System.out.println("플레이어 레벨: " + player.getLevel());
        System.out.println("남은 체력: " + player.getHp());
        System.out.println("보유 아이템 수: " + player.getInventory().size());
    }
}

