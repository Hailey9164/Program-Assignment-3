/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main driver for reading graphs from a file,   */
/* computing connected components and cycles, and printing    */
/* formatted results.                                         */
/**************************************************************/


public class Prog3 {

/**
 * Main
 * ----
 * Driver class for the canoe rental optimization program.
 * 
 * Responsibilities:
 *  - Read the input filename from the command line
 *  - Construct the Read object (reads input file)
 *  - Run the dynamic programming optimizer
 *  - Print the optimal cost matrix
 *  - Print the optimal rental path from post 0 to post n-1
 */
    public static void main(String[] args) {
        // Ensure the user provides exactly one filename
        if (args.length != 1) {
            System.out.println("Usage: java Main <inputfile>");
            return;
        }

        try {
            // Read cost matrix from file
            Read cm = new Read(args[0]);

            // Compute optimal costs using dynamic programming
            Optimizer opt = new Optimizer(cm);
            opt.compute();

            // Print the full optimal cost matrix
            Printer.printOptimalMatrix(opt.getOptMatrix());

            // Reconstruct and print the optimal rental sequence
            PathReconstructor pr = new PathReconstructor(opt.getNextMatrix());
            pr.printPath(0, cm.getN() - 1, opt.getOptMatrix());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}