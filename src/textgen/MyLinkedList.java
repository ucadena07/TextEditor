package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
		{
			throw new NullPointerException("Element added can't be 'null'");
		}
		
		LLNode<E> newElement = new LLNode<E>(element);
		LLNode<E> last = tail.prev;
		
		newElement.next =tail;
		newElement.prev = last;
		tail.prev = newElement;
		last.next = newElement;
		
		if (size == 0)
		{
			head = newElement;
		}
		
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if (index >= size || index < 0 || size <= 0)
		{
			throw new IndexOutOfBoundsException("Element out bounds of linkedlist");
		}
		
		LLNode<E> current = head;
		
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Invalid Index");
		if (element == null)
			throw new NullPointerException("New Element can not be Null");
		if (index == size) {
			this.add(element);
			return;
		}
		
		LLNode<E> newElement = new LLNode<E>(element);
		LLNode<E> current = head;
		
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				newElement.next = current;
				newElement.prev = current.prev;
				
				if (current.prev != null) {
					current.prev.next = newElement;
					current.prev = newElement;
				}
				size++;
			}
			current = current.next;
		}
		if (index == 0) {
			head = newElement;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}
	
	

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index outside of the bounds of the list");
			
		}
		
		E removedElement = get(index);
		
		if (index == 0) {
			if (head.next.next != null) {
				head = head.next;
				head.prev = null;
				
			}
			else {
				head.data = null;
			}
			size--;
			return removedElement;
		}
		
		if (index == size -1) {
			LLNode<E> newLast = tail.prev.prev;
			newLast.next = tail;
			tail.prev = newLast;
			size--;
			return removedElement;
		}
		
		LLNode<E> current = head;
		for (int i = 0; i < index; i++) {
			if (i == index) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				size--;
			}
			current = current.next;
		}
		
		return removedElement;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException("Element cant be null");
		
		if (index > this.size - 1 || index < 0)
			throw new IndexOutOfBoundsException("Index out bounds.");
		
		E replacedElement = get(index);
		
		LLNode<E> current = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				current.data = element;
			}
			current = current.next;
		}
		return replacedElement;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev) {
		this.data = e;
		this.prev = prev;
		this.next = null;
	}

}
