package effects.dungeon;

import effects.dungeon.DungeonEffect;

import org.example.Player;
import org.example.Monster;

import java.util.Random;

public class Darkness implements DungeonEffect {
    private final Random random = new Random();

    @Override
    public String getName() {
        return "어두운 던전";
    }

    @Override
    public void onEnter(Player player) {
        System.out.println("칠흙같은 어둠입니다. 플레이어의 공격이 빗나갈 수 있습니다.");
    }

    @Override
    public void onCombatTurn(Player player, Monster monster, int turnCount){
    }
}

