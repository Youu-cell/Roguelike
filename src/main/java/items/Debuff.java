package items;

import org.example.Player;

public class Debuff extends Item {
    private final int amount;

    public Debuff(int floor) {
        super("불길한 조각 (-" + (1 + floor / 20) + ")");
        this.amount = 1 + floor / 20;
    }

    @Override
    public void use(Player player) {
        player.getStats().decreaseLuck(amount);
        System.out.println(player.getName() + "의 행운이 " + amount + " 감소했습니다...");
    }
}
