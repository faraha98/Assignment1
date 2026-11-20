//Farah Alhwajrh : 215348178

import java.util.Random;
public class Horse implements Runnable {
    private String name;
    private FinishingLine finishingLine;
    private int distance;   
    private static final Random random = new Random();

    public Horse(String name, FinishingLine f, int distanse) {
        this.name = name;
        this.finishingLine = f;
        this.distance = distanse;
    }
    public String getHorseName() {
        return name;
    }
    // Helper method to format distance printing identically to the sample output
    private void printStatus(int dist) {
        System.out.printf("%-12s %2d meters to finish%n", name + ":", dist);
    }
    @Override
    public void run() {
        // Step 1: Initial print before beginning the race (as seen in sample output)
        printStatus(distance);
        // Step 2: Race loop
        while (distance > 0) {
            try {
                // Sleep for 1 second using Thread.sleep
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            // Decrease distance by a random number between 1 and 20
            int step = random.nextInt(20) + 1;
            distance -= step;
            // If horse has not crossed the finish line yet, print remaining distance
            if (distance > 0) {
                printStatus(distance);
            } else {
                // Horse crossed the finish line: call arrive on FinishingLine object and stop
                distance = 0;
                finishingLine.arrive(this);
                break;
            }
        }
    }
}
