/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 3                                   */
/* Read class: Reads and stores the canoe rental cost matrix  */
/**************************************************************/

import java.io.*;
import java.util.*;

public class Read {

    private int n;          // Number of posts along the river
    private int[][] C;      // Direct rental cost matrix C[i][j]

    /**********************************************************/
    /* Method: Read (Constructor)                             */
    /* Purpose: Initialize the Read object                    */
    /* Parameters:                                            */
    /*   String filename: name of the input file              */
    /* Returns: None                                          */
    /**********************************************************/
    public Read(String filename) throws Exception {
        readInput(filename);
    }
    /**********************************************************/
    /* Method: readInput                                      */
    /* Purpose: Read the input file and initialize the matrix */
    /* Parameters:                                            */
    /*   String filename: name of the input file              */
    /* Returns: None                                          */
    /**********************************************************/
    private void readInput(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));

        n = sc.nextInt();   // read the number of posts
        C = new int[n][n];  // allocate the cost matrix

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
    /* Method: getN                                           */
    /* Purpose: Return the number of posts                    */
    /* Parameters:                                            */
    /*   None                                                 */
    /* Returns: int: number of posts                          */
    /**********************************************************/
    public int getN() {
        return n;
    }

    /**********************************************************/
    /* Method: getMatrix                                      */
    /* Purpose: Return the cost matrix                        */
    /* Parameters:                                            */
    /*   None                                                 */
    /* Returns: int[][]: cost matrix                          */
    /**********************************************************/
    public int[][] getMatrix() {
        return C;
    }
}   