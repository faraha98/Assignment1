// Farah Alhwagrh : 215348178
// Student 2: [Name], [ID]


import java.util.Arrays;
public class Player extends Character {
    private Item[] inventory;

    public Player(String name, int health, int level) {
        super(name, health, level);
        this.inventory = new Item[0];
    }

    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);
        if (inventory == null) {
            this.inventory = new Item[0];
        } else {
            this.inventory = Arrays.copyOf(inventory, inventory.length);
        }
    }

    public void addItem(Item item) {
        if (item != null) {
            Item[] newInventory = Arrays.copyOf(this.inventory, this.inventory.length + 1);
            newInventory[newInventory.length - 1] = item;
            this.inventory = newInventory;
        }
    }

    public int calculateInventoryValue() {
        int total = 0;
        for (Item item : this.inventory) {
            if (item != null) {
                total += item.getValue();
            }
        }
        return total;
    }

    public boolean hasMagicalItem() {
        for (Item item : this.inventory) {
            if (item != null && item.isMagical()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (sb.length() > 0) {
                    sb.append(" | ");
                }
                sb.append(inventory[i].getName());
            }
        }
        return super.toString() + "\nInventory: " + sb.toString();
    }




}