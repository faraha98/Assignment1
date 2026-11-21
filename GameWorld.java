// Farah Alhwagrh : 215348178
// Toqa Abu Amar : 215611385

public class GameWorld {
    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty;

    public GameWorld() {
        this.name = "Crystalpath";
        this.difficulty = 1;
        this.players = new Player[0];
        this.enemies = new Enemy[0];
    }

    public GameWorld(String name, Player[] players, Enemy[] enemies, int difficulty) {
        this.name = (name != null) ? name : "Crystalpath";

        if (difficulty < 1) {
            this.difficulty = 1;
        } else if (difficulty > 3) {
            this.difficulty = 3;
        } else {
            this.difficulty = difficulty;
        }

        if (players != null) {
            this.players = new Player[players.length];
            for (int i = 0; i < players.length; i++) {
                this.players[i] = players[i];
            }
        } else {
            this.players = new Player[0];
        }

        if (enemies != null) {
            this.enemies = new Enemy[enemies.length];
            for (int i = 0; i < enemies.length; i++) {
                this.enemies[i] = enemies[i];
            }
        } else {
            this.enemies = new Enemy[0];
        }
    }

    public void addPlayer(Player player) {
        if (player == null) {
            return;
        }
        Player[] updated = new Player[this.players.length + 1];
        for (int i = 0; i < this.players.length; i++) {
            updated[i] = this.players[i];
        }
        updated[this.players.length] = player;
        this.players = updated;
    }

    public void printAllPlayers() {
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] != null) {
                System.out.println("Player " + (i + 1));
                System.out.println(this.players[i].toString());
                if (i < this.players.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public int getTotalValueOfWorld() {
        int total = 0;
        for (Player p : this.players) {
            if (p != null) {
                total += p.calculateInventoryValue();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "World Name: " + name + "\n" +
               "Difficulty: " + difficulty + "\n" +
               "Number of players: " + players.length;
    }
}