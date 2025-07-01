package items;

import org.example.Player;

public class LuckUp extends Item {
    private final int amount;

    public LuckUp(int floor) {
        super("행운의 부적 (+" + (1 + floor / 15) + ")");
        this.amount = 1 + floor / 15;
    }

    @Override
    public void use(Player player) {
        player.getStats().increaseLuck(amount);
        System.out.println(player.getName() + "의 행운이 " + amount + " 증가했습니다!");
    }
}
