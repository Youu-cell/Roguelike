package org.example;

public class Monster implements Attackable {
    private String name = "";
    private Stats stats;
    private int exp;
    public Monster(String name, int hp, int attackPower, int i) {
        this.name = name;
        this.stats = new Stats(hp, attackPower, 0); // 몬스터한테 운 필요없음
        this.exp = exp;
    }

    public Monster() {

    }
    //> 던전 코드에서 몬스터 생성 할 때 아무것도 지정하지 않은 빈 몬스터 만드는 생성자가 잇는데 거기 필요함
    // 나중에 층수에 따라 능력치를 어떻게 할지 결정되면 삭제할 예정

    public String getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }
// 외부에서 이름과 스탯을 확인할 수 있음
public int getExp() {
    return this.exp; // 또는 다른 변수명에 맞춰 수정
}
    @Override
    public int getHp() {
        return stats.getHp();
    }

    @Override
    public void takeDamage(int damage) {
        stats.decreaseHp(damage);
        System.out.println(name + "이(가) " + damage + "의 피해를 입었습니다! (남은 HP: " + stats.getHp() + ")");
    }

    @Override
    public boolean isAlive() {
        return stats.isAlive();
    }

    @Override
    public int getAttackPower() {
        return stats.getAttackPower();
    }

    public void attack(Player player) {
        int damage = getAttackPower();
        player.takeDamage(damage);
        System.out.println(name + "이(가) " + player.getName() + "을(를) 공격했습니다! " + damage + "의 피해!");
    }
    public void forceDefeat() {
        stats.decreaseHp(stats.getHp()); // 현재 체력만큼 피해 → 체력 0
        System.out.println(name + "은(는) 전투에서 도망쳤습니다! (EXP 획득 불가)");
    }
}
