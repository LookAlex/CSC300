/*
 * CSC 300 Spring 2019 -- Lytinen
 * Homework assignment 3:  Sets
 * 
 * The Set300 interface.  You will write 4 classes that 
 * implement this interface.
 */

package hw3;

public interface Set300<T> extends Iterable<T> {
	// returns true if the item is successfully added
	// or false if the item is already in the set
	// or cannot be added for some other reason
	public boolean add(T item);          
	
	// returns true if the item is removed
	public default boolean remove(T item) {
		return false;
	}
	
	// returns true if item is in the set or false otherwise
	// we can make it faster in later versions
	public default boolean contains(T item) {
		for (T obj : this)
			if (obj.equals(item)) 
				return true;
		return false;
	}	
	
	// public Iterator<T> iterator();   // inherits from Iterable<T>
	
	public String toString();
}
