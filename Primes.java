/* CSC 300 Sections Fall 2019 -- Lytinen
 * Homework assignment 2, part a
 * The Primes class
 */
package hw2;

import java.util.Iterator;
import java.util.Scanner;

// generate a sequence of prime numbers that are greater than or equal to
// smallest, and less than or equal to largest.

public class Primes implements Iterable<Integer> {
	private int smallest, largest;
	private int i=0;
	private int p=0;

	// fill this in
	public Primes(int x, int y) {
		p=0;
		i=0;
		this.smallest=x;
		this.largest=y;
	}
	
	// fill this in; to be used in one of more of the iterator methods below
	public static boolean isPrime(int p) {
		// replace this with your code
		int sqrt=(int) Math.sqrt(p)+1;
		for (int i=2; i<sqrt;i++) {
			if (p%i==0) {
				return false;
			}
		}
		return true;
	}
	
	// I have supplied the iterator method, which is required by the Iterable<T>
	// interface.  It returns an object which implements Iterator<T>.  You
	// must write hasNext and next methods for this object.
	public Iterator<Integer> iterator() {
		// this is an "anonymous inner class"
		return new Iterator<Integer>() {
			private int p = smallest;
			public boolean hasNext() {//loop takes to the next prime number
				// replace this
				return i<p;
			}
			public Integer next() {//loop report prime number then impliment by 1 
				// replace this
				for (i=0;i<=p;i++);
					return i;
			}
		};
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y;
		System.out.println("Type 2 positive integers.  The second integer should be greater then the first\n");
		x = sc.nextInt();
		y = sc.nextInt();
		Primes p = new Primes(x, y);
		System.out.println("The prime numbers between " + x + " and " + y + " are");
		for (Integer i : p)
			System.out.print(i + " ");
		System.out.println();
	}
}
			
