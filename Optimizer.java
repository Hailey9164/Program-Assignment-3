**************************************************************/
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
 * Optimizer
 * --------------
 * Implements the dynamic programming algorithm that computes:
 *   opt[i][j] = minimum cost to travel from post i to post j
 *
 * Also builds a nextStop[i][j] table that records which intermediate
 * post k gives the optimal solution. This allows reconstruction of
 * the actual rental sequence.
 */
public class Optimizer {

    private int n;              // Number of posts
    private int[][] C;          // Direct rental costs
    private int[][] opt;        // Optimal cost matrix
    private int[][] nextStop;   // Stores best intermediate stop k

    /** Constructor: initializes DP tables using the cost matrix */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public Optimizer(Read cm) {
        this.C = cm.getMatrix();
        this.n = cm.getN();
        this.opt = new int[n][n];
        this.nextStop = new int[n][n];
    }

    /**
     * Computes the optimal cost matrix using dynamic programming.
     *
     * Recurrence:
     *   opt[i][j] = min over k ( C[i][k] + opt[k][j] )
     *
     * We fill the table by increasing interval length.
     */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public void compute() {
        // Base case: cost from i to i is zero
        for (int i = 0; i < n; i++)
            opt[i][i] = 0;

        // Consider all intervals of length 2..n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;

                int best = Integer.MAX_VALUE;
                int bestK = -1;

                // Try all possible next stops k
                for (int k = i + 1; k <= j; k++) {
                    if (C[i][k] == Integer.MAX_VALUE) continue;

                    int cost = C[i][k] + opt[k][j];
                    if (cost < best) {
                        best = cost;
                        bestK = k;
                    }
                }

                opt[i][j] = best;
                nextStop[i][j] = bestK;
            }
        }
    }

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public int[][] getOptMatrix() {
        return opt;
    }

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public int[][] getNextMatrix() {
        return nextStop;
    }
}
