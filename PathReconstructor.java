/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main driver for reading graphs from a file,   */
/* computing connected components and cycles, and printing    */
/* formatted results.                                         */
/**************************************************************/

import java.util.*;

/**
 * PathReconstructor
 * -----------------
 * Uses the nextStop[i][j] table produced by Optimizer
 * to reconstruct the actual sequence of canoe rentals.
 *
 * If nextStop[i][j] = k, then the optimal path goes:
 *   i -> k, then k -> j
 */
public class PathReconstructor {

    private int[][] nextStop;   // DP table storing best intermediate stops

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public PathReconstructor(int[][] nextStop) {
        this.nextStop = nextStop;
    }

    /**
     * Prints the full rental sequence from start to end.
     * Also prints the total optimal cost.
     */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public void printPath(int start, int end, int[][] opt) {
        System.out.println("Optimal rental sequence from " + start + " to " + end + ":");

        List<String> rentals = new ArrayList<>();
        reconstruct(start, end, rentals);

        for (String s : rentals)
            System.out.println(s);

        System.out.println("Total cost: " + opt[start][end]);
    }

    /**
     * Recursively reconstructs the rental path.
     * If nextStop[i][j] = j, then the rental is direct (i → j).
     * Otherwise, split at k and recurse.
     */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    private void reconstruct(int i, int j, List<String> rentals) {
        int k = nextStop[i][j];

        if (k == j) {
            rentals.add("Rent canoe from " + i + " to " + j);
        } else {
            rentals.add("Rent canoe from " + i + " to " + k);
            reconstruct(k, j, rentals);
        }
    }
}
