            
// Farah Alhwagrh : 215348178
// Student 2: [Name], [ID]
public class Game {
    // Simulates battle between Player and Enemy based on level
    public static void simulateBattle(Player player, Enemy enemy) {
        System.out.println(player.getName() + " - level : " + player.getLevel() + " VS " + enemy.getName() + " - level : " + enemy.getLevel());
        if (player.getLevel() > enemy.getLevel()) {
            System.out.println(player.getName() + " wins!");
            player.levelUp();
        } else if (enemy.getLevel() > player.getLevel()) {  
            
          
            System.out.println(enemy.getName() + " wins!");
            enemy.levelUp();
        } else {
            System.out.println("It's a tie!");
        }
    }
    public static void main(String[] args) {
        // 1. Create items (at least 2-3 items with different names and values)
        Item item1 = new Item("Grimoire", 15, true);
        Item item2 = new Item("Ice Sword", 25, true);
        Item item3 = new Item("Guardian Shield", 10, false);
        Item item4 = new Item("Wand of Winds", 30, true);
        // 2. Create players (at least two, each with name, health 10, starting level, add items via addItem)
        Player player1 = new Player("Elara the Enchanter", 10, 4);
        player1.addItem(item1);
        player1.addItem(item2);
        Player player2 = new Player("Kael the Windcaller", 10, 0);
        player2.addItem(item3);
        player2.addItem(item4);
        // 3. Create enemy
        Enemy goblin = new Enemy("Goblin", 10, 2, 3);
        // 4. Create GameWorld with name, players array, enemies array, and difficulty level
        Player[] playersList = {player1, player2};
        Enemy[] enemiesList = {goblin};
        GameWorld world = new GameWorld("Crystalpath", playersList, enemiesList, 2);
        // 5. Display all players in the game world
        world.printAllPlayers();
        System.out.println();
        // 6. Display total value of items for each player
        for (Player p : playersList) {
            System.out.println("Total inventory value of " + p.getName() + ": " + p.calculateInventoryValue());
        }
        System.out.println();
        // 7 & 8. Run battle simulation between player and enemy and print results
        simulateBattle(player1, goblin);
    }
}