package part_1.assignment_1;

/**
 * First programming assignment in course "Algoritmer och datastrukturer"
 * Second handin
 * @author Victor Nilsson,
 */
public class Assignment1 {

    private static int MAX_COUNT = 10;

    public static void printCounts(int current){
        System.out.print(current + " ");
        if (current == 0){ // Basfall
            System.out.println("");
        } else { //
            printCounts(current-1);
            System.out.println("BANG " + current + "!");
        }
    }

    public static void main(String[] args){
        System.out.println("Nu börjar nedräkningen:");
        printCounts(MAX_COUNT);
    }
}
