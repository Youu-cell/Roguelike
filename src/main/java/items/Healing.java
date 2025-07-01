package items;

import org.example.Player;

import java.util.Random;

public class Healing extends Item {
    private final int healAmount;

    public Healing(int floor) {
        super("치유 포션 (+" + (floor + 4) + ")");
        this.healAmount = new Random().nextInt(4) + floor + 4; // floor + 4 ~ floor + 7
    }

    @Override
    public void use(Player player) {
        player.getStats().increaseHp(healAmount);
        System.out.println(player.getName() + "이(가) " + healAmount + " 만큼 체력을 회복했습니다!");
    }
}