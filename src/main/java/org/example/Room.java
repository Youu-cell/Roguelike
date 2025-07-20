package org.example;
import org.example.Player;
import effects.dungeon.DungeonEffect;

public abstract class Room {
    protected DungeonEffect effect;

    public Room(DungeonEffect effect) {
        this.effect = effect;
    }

    public DungeonEffect getEffect() {
        return effect;
    }

    public abstract void enter(Player player);
}
