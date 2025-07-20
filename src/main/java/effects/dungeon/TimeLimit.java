package effects.dungeon;

import org.example.Player;
import org.example.Monster;


public class TimeLimit implements DungeonEffect {
    private final int turnLimit;

    public TimeLimit(int floor) {
        // 층수 기반으로 턴 제한 설정
        int calculated = 7 - floor / 2;
        if (calculated < 3) this.turnLimit = 3;
        else this.turnLimit = calculated;
    }
    @Override
    public String getName() {
        return "시간제한 던전";
    }

    @Override
    public void onEnter(Player player) {
        System.out.println("몬스터가 도망가려합니다 " + turnLimit + "턴 안에 전투를 끝내지 않으면 몬스터가 도망 갈 것입니다.");
    }

    @Override
    public void onCombatTurn(Player player, Monster monster, int turnCount) {
        if (turnCount > turnLimit && monster.isAlive()) {
            System.out.println("몬스터가 도망쳤습니다! EXP를 얻지 못합니다.");
            monster.forceDefeat();
        }
    }
}
