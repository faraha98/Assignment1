            
// Farah Alhwagrh : 215348178
// Student 2: [Name], [ID]
public class Game {

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

        Item item1 = new Item("Grimoire", 15, true);
        Item item2 = new Item("Ice Sword", 25, true);
        Item item3 = new Item("Guardian Shield", 10, false);
        Item item4 = new Item("Wand of Winds", 30, true);

        Player player1 = new Player("Elara the Enchanter", 10, 4);
        player1.addItem(item1);
        player1.addItem(item2);
        Player player2 = new Player("Kael the Windcaller", 10, 0);
        player2.addItem(item3);
        player2.addItem(item4);

        Enemy goblin = new Enemy("Goblin", 10, 2, 3);

        Player[] playersList = {player1, player2};
        Enemy[] enemiesList = {goblin};
        GameWorld world = new GameWorld("Crystalpath", playersList, enemiesList, 2);

        world.printAllPlayers();
        System.out.println();
        for (Player p : playersList) {
            System.out.println("Total inventory value of " + p.getName() + ": " + p.calculateInventoryValue());
        }
        System.out.println();

        simulateBattle(player1, goblin);
    }
}
