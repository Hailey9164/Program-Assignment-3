/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 3                                   */
/* PathReconstructor class: Uses the nextStop[i][j] table     */
/*                          produced by Optimizer to          */
/*                          reconstruct the actual sequence   */
/*                          of canoe rentals.                 */
/*                          If nextStop[i][j] = k, then the   */
/*                          optimal path goes:                */
/*                          i -> k, then k -> j               */
/**************************************************************/
import java.util.*;

public class PathReconstructor {

    private int[][] nextStop;   // DP table storing best intermediate stops

    /**********************************************************/
    /* Method: PathReconstructor                              */
    /* Purpose: Constructor for PathReconstructor             */
    /* Parameters:                                            */
    /*   int[][] nextStop: the nextStop table from Optimizer  */
    /* Returns: none                                          */
    /**********************************************************/
    public PathReconstructor(int[][] nextStop) {
        this.nextStop = nextStop;
    }


    /**********************************************************/
    /* Method: printPath                                      */
    /* Purpose: Print the optimal rental sequence             */
    /* Parameters:                                            */
    /*   int start: starting post                             */
    /*   int end: ending post                                 */
    /*   int[][] opt: the optimal cost matrix                 */
    /* Returns: none                                          */
    /**********************************************************/
    public void printPath(int start, int end, int[][] opt) {
        System.out.println("Optimal rental sequence from " + start + " to " + end + ":");

        // Use a list to store the rental steps for easier printing
        List<String> rentals = new ArrayList<>();
        reconstruct(start, end, rentals);

        // Print the rental steps
        for (String s : rentals)
            System.out.println(s);

        System.out.println("Total cost: " + opt[start][end]);
    }

    /**********************************************************/
    /* Method: reconstruct                                    */
    /* Purpose: Recursively reconstruct the rental path       */
    /* Parameters:                                            */
    /*   int i: starting post                                 */
    /*   int j: ending post                                   */
    /*   List<String> rentals: list to store rental info      */
    /* Returns: none                                          */
    /**********************************************************/
    private void reconstruct(int i, int j, List<String> rentals) {
        // Base case: if nextStop[i][j] == j, then we rent 
        // directly from i to j
        int k = nextStop[i][j];

        // If k == j, we rent directly from i to j
        // Otherwise, we rent from i to k, then recursively 
        // reconstruct from k to j
        if (k == j) {
            rentals.add("Rent canoe from " + i + " to " + j);
        } else {
            rentals.add("Rent canoe from " + i + " to " + k);
            reconstruct(k, j, rentals);
        }
    }
}
