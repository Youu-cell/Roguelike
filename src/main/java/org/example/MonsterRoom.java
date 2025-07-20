package org.example;

import org.example.CombatSystem;
import effects.dungeon.DungeonEffect;
import org.example.Monster;
import org.example.Player;

public class MonsterRoom extends Room {
    private final Monster monster;

    public MonsterRoom(Monster monster, DungeonEffect effect) {
        super(effect);
        this.monster = monster;
    }

    @Override
    public void enter(Player player) {
        System.out.println(" 몬스터 방입니다! " + monster.getName() + " 이(가) 나타났습니다!");
        CombatSystem combat = new CombatSystem(player, monster, effect);
        combat.startCombat();
    }
}