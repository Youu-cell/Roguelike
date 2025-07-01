package org.example;
import items.Item;

public class Player implements Attackable {
    private final String name;
    private final Stats stats;
    private int level;
    private int exp;
    private boolean itemUsedThisTurn;
    // 아이템 사용 여부 판단

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.stats = new Stats(20, 1, 0);
        // 초기 HP 20, 공격력 1, 럭 0
        this.itemUsedThisTurn = false;
    }

    public String getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }
    // 프라이빗 클래스인 name과 stats을 다른곳에서도 확인할 수 있게 공개 메서드를 제공함
    // getname, getStats로 접근가능

    @Override
    public int getHp() {
        return stats.getHp();
    }

    @Override
    public void takeDamage(int damage) {
        stats.decreaseHp(damage);
        System.out.println(name + "이(가) " + damage + " 피해를 입었습니다! (남은 HP: " + stats.getHp() + ")");
    }

    @Override
    public boolean isAlive() {
        return stats.isAlive();
    }

    @Override
    public int getAttackPower() {
        return stats.getAttackPower();
    }

    public void attack(Monster monster) {
        int damage = getAttackPower();
        monster.takeDamage(damage);
    }

    public void useItem(Item item) {
        if (itemUsedThisTurn) {
            System.out.println(" 이미 이번 턴에 아이템을 사용했습니다.");
            return;
        }
        item.use(this);
        itemUsedThisTurn = true;
    }

    public void resetTurn() {
        itemUsedThisTurn = false;
    }
// 매 턴 시작시 호출되어 아이템 사용 여부를 초기화함

    //<경험치 획득 및 레벨 업>
    public void gainExp(int amount) {
        exp += amount;
        System.out.println(amount + " EXP를 얻었습니다. (총 EXP: " + exp + ")");
        checkLevelUp();
        //경험치 충분하면 checkLevelUp 후 자동 레벨업
    }

    //<레벨업 조건>
    private void checkLevelUp() {
        int requiredExp = level * 10;
        while (exp >= requiredExp) {
            exp -= requiredExp;
            levelUp();
            requiredExp = level * 10;
            //레벨이 증가 했기 때문에 새로운 레벨 기준으로 필요 경험치 다시 계산
        }
    }

    //<레벨 업 효과>
    private void levelUp() {
        level++;
        stats.increaseHp(5);        // 레벨업 시 체력 +5
        stats.increaseAttackPower(1);    // 공격력 +1
        System.out.println("🎉 레벨업! 현재 레벨: " + level + ", HP: " + stats.getHp() + ", 공격력: " + stats.getAttackPower());
    }

}
