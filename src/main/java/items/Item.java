package items;

import org.example.Player;

public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    // 아이템 이름 반환 (ex. 치유 포션, 공격력 강화제 등)
    public String getName() {
        return name;
    }

    // 각 아이템의 효과 정의는 자식 클래스가 구현함
    public abstract void use(Player player);
}