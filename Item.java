// Farah Alhwagrh : 215348178
//Toqa abu amar: 215611385
    
   public class Item {
    private String name;
    private int value;
    private boolean isMagical;

    public Item() {
        this.name = "Unknown";
        this.value = 0;
        this.isMagical = false;
    }

    public Item(String name, int value, boolean isMagical) {
        this.name = (name != null) ? name : "Unknown";
        setValue(value);
        this.isMagical = isMagical;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    public boolean isMagical() {
        return isMagical;
    }

    @Override
    public String toString() {
        String magicStatus = isMagical ? "Magical item" : "Not a magical item";
        return "Name: " + name + "\n" +
               "Value: " + value + "\n" +
               magicStatus;
    }
}