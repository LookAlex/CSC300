package hw3;
//Fix lol
import java.util.Iterator;

public class NodeSet<T> extends Comparable<T >implements Set300<T> {
	private Node<T> first = null;
	
	private class Node<T> {
		private T data;
		private Node next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	public NodeSet() { }
	public boolean add(T data) {
		if(contains(data))
			return false;
		else {
			first = new Node<T>(data, first);
			return true;
	}
	public boolean remove(T data,Node<T> current) {
		if(current==null)
			return null;
		else {
			int com=data.compareTo(current.data);
			if(comp==0)
				return current.next;
			else {
				current.next=remove(data,current.next);
				return current;
			}
		}
	}
			
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			public Node<T> curr = first;
			
			public boolean hasNext() {
				return curr != null;
			}
			
			public T next() {
				T answer = curr.data;
				curr = curr.next;
				return answer;
			}
		};
	}
	public String toString() {
		StringBuilder s = new StringBuilder("[ ");
		for (T item : this) 
			s.append(item.toString() + " ");
		s.append("]");
		return s.toString();
	}
	public boolean contains(T item) {
		Node<T> current=first;
		while(current!=null) {
			int comp=data.compareTo(current.data)
		}
	}	
}
