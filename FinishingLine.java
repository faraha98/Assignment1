//Farah Alhwajrh : 216348178
// Toqa Abu Amar : 215611385
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
