// Farah Alhwagrh : 215348178
// Toqa Abu Amar : 215611385

public class Game {

    public static void simulateBattle(Player player, Enemy enemy) {
        if (player == null || enemy == null) {
            return;
        }

        int playerLevel = player.getLevel();
        int enemyLevel = enemy.getLevel();

        System.out.println(player.getName() + " - level: " + playerLevel +
                       " VS " + enemy.getName() + " - level: " + enemyLevel);

        if (playerLevel > enemyLevel) {
            player.levelUp();
            System.out.println(player.getName() + " wins!");
        } else if (enemyLevel > playerLevel) {
            enemy.levelUp();
            System.out.println(enemy.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        Item grimoire = new Item("Grimoire", 15, true);
        Item iceSword = new Item("Ice Sword", 25, true);
        Item shield = new Item("Guardian Shield", 10, false);

        Player player1 = new Player("Elara the Enchanter", 10, 4);
        player1.addItem(grimoire);
        player1.addItem(iceSword);

        Player player2 = new Player("Kael the Windcaller", 10, 2);
        player2.addItem(shield);

        Enemy goblin = new Enemy("Goblin", 10, 2, 3);

        Player[] players = { player1, player2 };
        Enemy[] enemies = { goblin };
        GameWorld world = new GameWorld("Crystalpath", players, enemies, 2);

        System.out.println(world);
        System.out.println();

        world.printAllPlayers();
        System.out.println();

        for (Player p : players) {
            System.out.println(p.getName() + " - Inventory Value: " + p.calculateInventoryValue());
        }
        System.out.println();

        simulateBattle(player1, goblin);
    }
}
