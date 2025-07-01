package effects.dungeon;
import org.example.Player;
import org.example.Monster;

import java.util.Random;

public class Healing implements DungeonEffect {
    private final Random random = new Random();

    public Healing(int floor) {
    }

    @Override
    public String getName() {
        return "치유의 던전";
    }

    @Override
    public void onEnter(Player player) {
        int healAmount = random.nextInt(6) + 5;
        //random.nextInt(6) = 0부터 5까지의 정수 중 하나를 무작위로 생성
        player.getStats().increaseHp(healAmount);
        System.out.println(" 포근한 기운이 감돕니다. 체력이 " + healAmount + "만큼 치유되었습니다.");
    }

    @Override
    public void onCombatTurn(Player player, Monster monster, int turnCount) {

    }
}

