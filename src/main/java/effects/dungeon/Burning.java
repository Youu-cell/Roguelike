package effects.dungeon;
import org.example.Player;

    public class Burning implements DungeonEffect {
        private final int damagePerTurn;
        public Burning(int floor) {
            this.damagePerTurn = 2 + (floor / 5);
        }

        @Override
        public String getName() {
            return "불타는 던전";
        }

        @Override
        public void onEnter(Player player) {
            System.out.println("🔥 바닥이 불타고 있습니다. 이 던전에서는 매 행동마다 피해를 입습니다.");
        }

        @Override
        public void onCombatTurn(Player player, org.example.Monster monster, int turnCount) {
            player.getStats().decreaseHp(damagePerTurn);
            System.out.println("🔥 " + player.getName() + "은(는) 화염으로 인해 " + damagePerTurn + " 피해를 입었습니다.");
        }
    }

