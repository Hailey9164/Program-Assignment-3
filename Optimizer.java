/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 3                                   */
/* Optimizer class: Uses dynamic programming algorithm that   */
/*                  computes opt[i][j] = minimum cost to      */
/*                  travel from i to j. Builds nextStop [i][j]*/
/*                  table that records which intermediate post*/
/*                  k gives the optimal solution. This        */
/*                  allows reconstruction of the actual rental*/
/*                  sequence.                                 */
/**************************************************************/
import java.util.*;


public class Optimizer {

    private int n;              // Number of posts
    private int[][] C;          // Direct rental costs
    private int[][] opt;        // Optimal cost matrix
    private int[][] nextStop;   // Stores best intermediate stop k

    /**********************************************************/
    /* Method: Optimizer    (Constructor)                     */
    /* Purpose: Loads the input cost matrix. Stores the       */
    /*          number of posts. Allocates the opt table for  */
    /*          optimal costs. Allocates the opt table for    */
    /*          path reconstruction                           */
    /* Parameters:                                            */
    /*   Read: the data from the input file                   */
    /* Returns: none                                          */
    /**********************************************************/
    public Optimizer(Read cm) {
        // stores the cost matrix from the Read object
        this.C = cm.getMatrix();  
        // number of posts  
        this.n = cm.getN();
        // allocate tables for optimal costs and path reconstruction
        this.opt = new int[n][n];
        // nextStop[i][j] will store the intermediate post k that 
        // gives the optimal cost from i to j
        this.nextStop = new int[n][n];
    }

    /**********************************************************/
    /* Method: compute                                        */
    /* Purpose: Compute the optimal cost matrix using dynamic */
    /*          programming. Fill in table by increasing      */
    /*          interval length.                              */
    /*          Recurrence realation: opt[i][j] = min over k  */
    /*          (C[i][k] +opt[k][j]).                         */
    /* Parameters: None                                       */
    /* Returns: None                                          */
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
    /* Method: getOptMatrix                                   */
    /* Purpose: Return the opt matrix                         */
    /* Parameters: None                                       */
    /* Returns: opt: opt                                   */
    /**********************************************************/
    public int[][] getOptMatrix() {
        return opt;
    }

    /**********************************************************/
    /* Method: getNextMatrix                                  */
    /* Purpose: Return nextStop                               */
    /* Parameters: None                                       */
    /* Returns: nextStop: nextStop                            */
    /**********************************************************/
    public int[][] getNextMatrix() {
        return nextStop;
    }
}
