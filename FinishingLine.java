// Names and IDs of submitters:
// Student 1: [Name], [ID]
// Student 2: [Name], [ID]

public class FinishingLine {
    private int place = 0;

    public synchronized void arrive(Horse h) {
        place++;
        if (place == 1) {
            System.out.println("*****************************");
            System.out.println("====> " + h.getHorseName() + " finished first!");
            System.out.println("*****************************");
        } else {

            System.out.println("====> " + h.getHorseName() + " finished on " + place + "-th place");
        }
    }
}