/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main driver for reading graphs from a file,   */
/* computing connected components and cycles, and printing    */
/* formatted results.                                         */
/**************************************************************/
/**
 * Printer
 * -------------
 * Utility class for printing the optimal cost matrix.
 * Entries where i >= j are printed as "-" since they are not valid.
 */
public class Printer {

        /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public static void printOptimalMatrix(int[][] opt) {
        int n = opt.length;

        System.out.println("Optimal Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    System.out.print("- ");
                else
                    System.out.print(opt[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
