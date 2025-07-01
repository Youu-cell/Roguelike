package org.example;
public class Stats {
    private int hp;
    private int attackPower;
    private int luck;

    public Stats(int hp, int attackPower, int luck) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.luck = luck;
    }

    // 체력 관련 메서드
    public int getHp() {
        return hp;
    }

    public void decreaseHp(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void increaseHp(int amount) {
        hp += amount;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    // 공격력
    public int getAttackPower() {
        return attackPower;
    }

    public void increaseAttackPower(int amount) {
        attackPower += amount;
    }

    // 운
    public int getLuck() {
        return luck;
    }

    public void increaseLuck(int amount) {
        luck += amount;
    }

    public void decreaseLuck(int amount) {
        luck -= amount;
        if (luck < 0) luck = 0;
    }

}
