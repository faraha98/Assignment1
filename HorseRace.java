//Faraha Alhwagrh : 215348178

// Student 2: [Name], [ID]
import java.util.Scanner;
public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter distance: ");
        int distance = scanner.nextInt();
        FinishingLine finishingLine = new FinishingLine();

        String[] horseNames = {
            "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten"
        };
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            Horse horse = new Horse(horseNames[i], finishingLine, distance);
            threads[i] = new Thread(horse);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        scanner.close();
    }
}
