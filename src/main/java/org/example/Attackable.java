package org.example;

public interface Attackable {
    int getHp();                  // 현재 체력
    void takeDamage(int damage); // 데미지 입힘
    boolean isAlive();           // 생존 여부
    int getAttackPower();        // 공격력
}