package effects.dungeon;

import org.example.Player;
import org.example.Monster;

public interface DungeonEffect {
    String getName();
    void onEnter(Player player);
    void onCombatTurn(Player player, Monster monster, int turnCount);
}