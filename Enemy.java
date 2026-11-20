// Farah Alhwagrh : 215348178


public class Enemy extends Character {
    private int damage; // 1 to 5

    public Enemy(String name, int health, int level, int damage) {
        super(name, health, level);
        if (damage < 1) {
            this.damage = 1;
        } else if (damage > 5) {
            this.damage = 5;
        } else {
            this.damage = damage;
        }
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return super.toString() + "\nDamage: " + damage;
    }
}