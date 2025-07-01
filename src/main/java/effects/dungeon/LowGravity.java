package effects.dungeon;

import org.example.Player;
import org.example.Monster;

import java.util.Random;

public class LowGravity implements DungeonEffect {
    private final int skipFloors;

    public LowGravity() {
        this.skipFloors = new Random().nextInt(3) + 3; // 3~5층 건너뛰기
    }
        //012 세개 숫자 + 3 임
    @Override
    public String getName() {
        return "저중력 던전";
    }

    @Override
    public void onEnter(Player player) {
        System.out.println("중력에 이상이 생겼습니다. 클리어 시 " + skipFloors + "층을 한 번에 올라갑니다!");
    }

    @Override
    public void onCombatTurn(Player player, Monster monster, int turnCount) {
        // 전투 중 효과 없음
    }


    public int getSkipFloors() {
        return skipFloors;
    }
}