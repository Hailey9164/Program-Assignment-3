/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 3                                   */
/* Printer class: Utility for printing the optimal cost       */
/*                matrix. Entries where i >= j are printed as */
/*                "-" since they are not valid.               */        
/**************************************************************/

public class Printer {

    /**********************************************************/
    /* Method: printOptimalMatrix                             */
    /* Purpose: Print the optimal cost matrix                 */
    /* Parameters:                                            */
    /*   int[][] opt: the optimal cost matrix                 */
    /* Returns: none                                          */
    /**********************************************************/
    public static void printOptimalMatrix(int[][] opt) {
        int n = opt.length; // number of posts is the size of the matrix

        // Print the optimal cost matrix with formatting
        System.out.println("Optimal Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    System.out.printf("%4s", "-");
                else
                    System.out.printf("%4d", opt[i][j]);
                }
            System.out.println();
        }
        System.out.println();
    }
}
