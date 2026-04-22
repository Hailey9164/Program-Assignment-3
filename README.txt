README — Canoe Rental Optimization Program
CS 3310 — Program 3
Spring 2026

------------------------------------------------------------
1. Overview
------------------------------------------------------------

This program computes the minimum-cost sequence of canoe rentals
for a trip down the Los Angeles River. Canoes may be rented at
any post i and dropped off at any downstream post j (i < j).
The input file provides the direct rental cost matrix C[i][j].

The program uses a dynamic programming algorithm to compute:

    opt[i][j] = minimum cost to travel from post i to post j

It also reconstructs the actual sequence of canoe rentals used
in the optimal solution from post 0 to post n-1.

------------------------------------------------------------
2. Files Included
------------------------------------------------------------

Prog3.java              — Driver program
Read.java	        — Reads and stores the cost matrix
Optimizer.java     	— Dynamic programming algorithm
PathReconstructor.java  — Reconstructs optimal rental path
Printer.java 	        — Prints the optimal cost matrix

README                  — This file
ANALYSIS                — Description of recurrence and runtime

------------------------------------------------------------
3. How to Compile
------------------------------------------------------------

Ensure all .java files are in the same directory.

Compile using:

    javac Prog3.java

This will automatically compile all dependent classes.

------------------------------------------------------------
4. How to Run
------------------------------------------------------------

Run the program with:

    java Prog3 <inputfile>

Example:

    java Prog3 inputA.txt

------------------------------------------------------------
5. Input File Format
------------------------------------------------------------

The first line contains an integer n (number of posts).

The next n-1 lines contain the upper-triangular cost matrix:

Example:

4
   10 15 50
      40 20
         35

This corresponds to:

C[0][1] = 10   C[0][2] = 15   C[0][3] = 50
               C[1][2] = 40   C[1][3] = 20
			      C[2][3] = 35

------------------------------------------------------------
6. Output
------------------------------------------------------------

The program prints:

1. The full optimal cost matrix opt[i][j]
2. The optimal rental sequence from post 0 to post n-1
3. The total minimum cost
