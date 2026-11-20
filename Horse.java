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

        private void printStatus(int dist) {
        System.out.printf("%-12s %2d meters to finish%n", name + ":", dist);
    }
    @Override
    public void run() {

        printStatus(distance);
        while (distance > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int step = random.nextInt(20) + 1;
            distance -= step;

            if (distance > 0) {
                printStatus(distance);
            } else {

                distance = 0;
                finishingLine.arrive(this);
                break;
            }
        }
    }
}
