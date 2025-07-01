package items;

import org.example.Player;

public class AttackUp extends Item {
    private final int amount;

    public AttackUp(int floor) {
        super("공격력 강화제 (+" + (1 + floor / 10) + ")");
        this.amount = 1 + floor / 10; // 층마다 점진적 증가
    }

    @Override
    public void use(Player player) {
        player.getStats().increaseAttackPower(amount);
        System.out.println(player.getName() + "의 공격력이 " + amount + " 증가했습니다!");
    }
}
