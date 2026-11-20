// Farah Alhwagrh : 215348178



import java.util.Arrays;
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
        this.name = name;
        this.players = (players != null) ? Arrays.copyOf(players, players.length) : new Player[0];
        this.enemies = (enemies != null) ? Arrays.copyOf(enemies, enemies.length) : new Enemy[0];
        if (difficulty < 1) {    
          
          this.difficulty = 1;
        } else if (difficulty > 3) {
            this.difficulty = 3;
        } else {
            this.difficulty = difficulty;
        }
    }
    // Adds a player to the world
    public void addPlayer(Player player) {
        if (player != null) {
            Player[] newPlayers = Arrays.copyOf(this.players, this.players.length + 1);
            newPlayers[newPlayers.length - 1] = player;
            this.players = newPlayers;
        }
    }
    // Prints all players in the world
    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("---------- Player " + (i + 1) + " ----------");
            System.out.println(players[i].toString());
            if (i < players.length - 1) {
                System.out.println();
            }
        }
    }
    // Calculates total value of all items across all players
    public int getTotalValueOfWorld() {
        int total = 0;
        for (Player p : players) {
            if (p != null) {
                total += p.calculateInventoryValue();
            }
        }
        return total;
    }
    @Override
    public String toString() {
        return "World Name: " + name + "\nDifficulty: " + difficulty + "\nNumber of players: " + players.length;
    }
}