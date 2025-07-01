package org.example;
import org.example.Player;
import org.example.Monster;
public class Main {
    public static void main(String[] args) {
        Player player = new Player("용사");
        Monster monster = new Monster("고블린", 15, 3);

        player.attack(monster);
        monster.attack(player);
    }
}

