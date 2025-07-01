package org.example;

import java.util.Random;
import java.util.Random;
import effects.dungeon.DungeonEffect;
import effects.dungeon.Burning;
import effects.dungeon.Darkness;
import effects.dungeon.Healing;
import effects.dungeon.LowGravity;
import effects.dungeon.TimeLimit;

public class Dungeon {
    private int floor;
    private DungeonEffect effect;
    private Monster monster;
    private ItemRoom itemRoom;

    public Dungeon(int floor){
        this.floor = floor;
        this.effect = getRandomEffect();
        this.monster = new Monster();
        this.itemRoom = new ItemRoom();

    }

    public void enter(Player player) {
        System.out.println(floor+"층 던전에 입장합니다");
        System.out.println(""+effect.getName());
        effect.onEnter(player); // 던전 효과 적용
    }

    public DungeonEffect getEffect() {
        return effect;
    }

    public Monster getMonster() {
        return monster;
    }

    public ItemRoom getItemRoom() {
        return itemRoom;
    }

    public int getFloor() {
        return floor;
    }

    //  던전 효과를 랜덤으로 선택
    private DungeonEffect getRandomEffect() {
        DungeonEffect[] effects = {
                new Burning(floor),
                new Darkness(),
                new Healing(floor),
                new LowGravity(),
                new TimeLimit(floor)
        };
        Random random = new Random();
        return effects[random.nextInt(effects.length)];
    }

    }




