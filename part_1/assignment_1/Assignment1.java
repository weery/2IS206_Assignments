package part_1.assignment_1;

/**
 * First programming assignment in course "Algoritmer och datastrukturer"
 * @author Victor Nilsson,
 */
public class Assignment1 {

    private static int MAX_COUNT = 10;

    /**
     * Prints all numbers from {@code countdown} countdown to 0 in a row comma separated
     * @param countdown the start number to countdown from
     */
    public static void printCountdown(int countdown){
        System.out.print(countdown);
        if (countdown > 0){
            System.out.print(", ");
            printCountdown(countdown-1);
        } else {
            System.out.println();
        }
    }

    /**
     * Prints all numbers from 1 to {@code countupTarget} with with a BANG recursively
     * @param countup the current number to print with a BANG
     * @param countupTarget the end number to countup to
     */
    public static void printCountupBang(int countup, int countupTarget){
        System.out.println("BANG " + countup + "!");
        if (countup < countupTarget){
            printCountupBang(countup + 1, countupTarget);
        }
    }

    public static void main(String[] args){
        System.out.println("Nu börjar nedräkningen:");
        printCountdown(MAX_COUNT);
        printCountupBang(1, MAX_COUNT);
    }
}
