/*********************************************
 *  CSC 300 Sections 201, 210 Summer I 2017  *
 *  Homework assignment 1:  the Polynomial   *
 *  class.                                   *
 *                                           *
 *  A polynomial is a function which         *
 *  consists of a summation of terms.        *
 *  Each term consists of a coefficient c    *
 *  and a non-negative power of n.           *
 *  For example, f(n) = 2n^4 - 3n^3 + 4n - 1 *
 *  is a polynomial.                         *
 *                                           *
 *  Your assignment is to complete the code  *
 *  below as follows:                        *
 *                                           *
 *  1.  Complete the constructor             *
 *  2.  Write a method called "simplify"     *
 *  3.  Write a method called "toString"     *
 *  4.  Write a method called "degree"       *
 *  5.  Write a method called "evaluate"     *
 *                                           *
 *  Please refer to the homework write-up    *
 *  for a more detailed description of the   *
 *  assignment.                              *
 *                                           *
 *  Please DO NOT put a main method into the *
 *  Polynomial class.  Notice that I have    *
 *  created a second class, called TestHW1.  *
 *  It has test cases for each of the        *
 *  methods of the Polynomial class          *
 *********************************************
 */ 

package hw1;

public class Polynomial {
	private int[] coefficients;
	// the constructor creates a Polynomial with the specified
	// coefficients (passed as the parameter c).  It should
	// set the "coefficients" instance variable to be an array
	// which is a copy of c.  At the end, the constructor calls
	// the "simplify" method, which makes sure that the first
	// coefficient(s) of the polynomial are non-zero.
	public Polynomial(int[] c) {
		coefficients = new int[c.length];
		// complete this
		coefficients=c;
		// make sure that the first coefficient of the 
        // polynomial is not 0
		if (coefficients[0]==0);
		simplify();
	}
	/* 
	   simplify should (if necessary) create a new array to
	   be stored in the "coefficients" instance variable.
	   In the new array, the first coefficient will be nonzero.
	   For example, 
	  
	   int coeffs[] = {0, 0, 2, 1, 0};
	   Polynomial p = new Polynomial(coeffs);
	   p represents the function f(n) = 0n^4 + 0n^3 + 2n^2 + n.
	   We would like to get ride of the highest order term(s)
	   with coefficient of 0.  In this example after calling
	   
	   p.simplify();
	 
	   p's coefficients should be {2, 1, 0}, which
	   represents f(n) = 2n^2 + n
	*/
	public void simplify() {
		// fill in the code for this method
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                return;
            }
        }
	}
	/*
	   return a String that represents the Polynomial.  The
	   toString method should be written as specified in
	   the homework write-up
	*/
	public String toString() {
		int p = degree();
		if (coefficients.length == 0)
			return "0";
		StringBuilder b = new StringBuilder("");
		// fill in the rest
		if (p== 1)
			return coefficients[1]+"n + "+coefficients[0];
		for(int i=degree()-1; i>=0; i++){
			b.append(p);
			
		}
	   return b.toString();
   }
	// return the degree of the polynomial
	public int degree() {
		return degree();    // replace this
	}
	// return the value of the Polynomial f(n) when n is equal to x
	public int evaluate(int x) {
		// fill this in
		int p = 0;
        for (int y = degree(); y >= 0; y--)
            p = coefficients[y] + (x * p);
        return p;
	}
        }
