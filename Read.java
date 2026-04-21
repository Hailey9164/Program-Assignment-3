/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main driver for reading graphs from a file,   */
/* computing connected components and cycles, and printing    */
/* formatted results.                                         */
/**************************************************************/

import java.io.*;
import java.util.*;

/**
 * Read
 * ----------
 * Reads and stores the canoe rental cost matrix C[i][j].
 * Only entries where i < j contain valid costs.
 * All other entries are set to Integer.MAX_VALUE.
 */
public class Read {

    private int n;          // Number of posts along the river
    private int[][] C;      // Direct rental cost matrix C[i][j]

    /** Constructor: loads matrix from file */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public Read(String filename) throws Exception {
        readInput(filename);
 /**
     * Reads the triangular matrix from the input file.
     * The file contains:
     *   n
     *   C[0][1] C[0][2] ... C[0][n-1]
     *   C[1][2] C[1][3] ... C[1][n-1]
     *   ...
     */
    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    private void readInput(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));

        n = sc.nextInt();
        C = new int[n][n];

        // Initialize all entries to "infinity"
        for (int i = 0; i < n; i++)
            Arrays.fill(C[i], Integer.MAX_VALUE);

        // Read only the upper triangle
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                C[i][j] = sc.nextInt();
            }
        }

        sc.close();
    }

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public int getN() {
        return n;
    }

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    public int[][] getMatrix() {
        return C;
    }
}   