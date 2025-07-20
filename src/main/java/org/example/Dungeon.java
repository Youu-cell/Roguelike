package org.example;

import effects.dungeon.*;
import org.example.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {
    private final List<Room> rooms = new ArrayList<>();
    private int currentFloor = 1;

    public Dungeon(int totalFloors) {
        for (int i = 1; i <= totalFloors; i++) {
            DungeonEffect effect = getRandomEffect(i);
            Room room;

            if (new Random().nextBoolean()) {
                Monster monster = new Monster("몬스터 Lv." + i, 10 + i * 2, 1 + i, 5 + i * 2);
                room = new MonsterRoom(monster, effect);
            } else {
                room = new ItemRoom(i, effect);
            }

            rooms.add(room);
        }
    }

    public Room getNextRoom() {
        return rooms.get(currentFloor - 1);
    }

    public void moveToNextFloor() {
        currentFloor++;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean hasNextRoom() {
        return currentFloor <= rooms.size();
    }

    private DungeonEffect getRandomEffect(int floor) {
        DungeonEffect[] effects = {
                new Burning(floor),
                new Darkness(),
                new Healing(floor),
                new LowGravity(),
                new TimeLimit(floor)
        };
        return effects[new Random().nextInt(effects.length)];
    }
}




