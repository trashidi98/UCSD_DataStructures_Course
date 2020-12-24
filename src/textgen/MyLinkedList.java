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

	/**
	 * Create a new empty LinkedList
	 */
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 *
	 * @param element The element to add
	 */
	public boolean add(E element) {
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> addedNode = new LLNode<E>(element);
		LLNode<E> lastTail = tail;
		boolean replaced = false;

		// If list is empty
		if (this.size == 0) {
			head = addedNode;
			tail = addedNode;
			size++;

			replaced = true;
		}
		else {

			// Set the new node's prev to be current tail [currTail] <- [newTail]
			addedNode.prev = tail;

			// Set currTail next value to new node [currTail] <-> [newTail]
			lastTail.next = addedNode;

			//			       								TAIL
			// Set tail value to new node [currTail] <-> [newTail]
			tail = addedNode;

			// addedNode automatically points next to null, check constructor
			size++;

			replaced = true;
		}

		return replaced;
	}

	/**
	 * Get the element at position index
	 *
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E get(int index) {

		// Sanitize Input
		if (index < 0 || index >= this.size || head == null || tail == null) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> currNode = this.head;
		E elementData = this.head.data;


		for (int i = 0; i < this.size; i++) {
			if (i == index) {
				elementData = currNode.data;
			} else {
				currNode = currNode.next;
			}
		}

		return elementData;
	}

	/**
	 * Add an element to the list at the specified index
	 *
	 * @param index   where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		/*
		* Behavior should be:
		* Empty list is indexOutofBounds
		* Any index < 0 or greater than size is out of Bounds
		* Null objects cannot be added to LL
		* When adding to a specific index all other elements 'shift right'
		* and size increases by 1
		* */


		if(this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Check index");
		}

		if(element == null) {
			throw new NullPointerException("Passed null object");
		}

		LLNode<E> addedNode = new LLNode<E>(element);

		// Get node at index
		LLNode<E> currNode = getNode(index);

		LLNode<E> nodeBefore = currNode.prev;

		// The currNode must point back to addedNode
		currNode.prev = addedNode;

		// The addedNode must point to the currNode
		addedNode.next = currNode;

		// Creating a []<->[] link between them

		if (index == 0) {

			addedNode.prev = null;

			this.head = addedNode;
		}

		else {

			// Set lastNode next to added
			nodeBefore.next = addedNode;

			// Set addedNode prev to nodeBefore
			addedNode.prev = nodeBefore;
		}

		this.size++;
	}


	/**
	 * Return the size of the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 *
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 */
	public E remove(int index) {
		if(this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Check index");
		}

		LLNode<E> currNode = getNode(index);
		LLNode<E> lastNode = currNode.prev;
		LLNode<E> nextNode = currNode.next;

		// Head Case
		if(index == 0) {
			head = nextNode;
			currNode.next = null;
			nextNode.prev = null;
			size--;
		}

		// Tail Case
		else if(index == size-1) {
			tail = lastNode;
			currNode.prev = null;
			lastNode.next = null;
			size--;
		}

		// Any middle nodes
		else {
			nextNode.prev = lastNode;
			lastNode.next = nextNode;
			currNode.next = null;
			currNode.prev = null;
			size--;
		}

		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 *
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {

		if(this.size == 0 || index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Check index");
		}

		if(element == null) {
			throw new NullPointerException("Passed null object");
		}

		LLNode<E> currNode = this.head;
		currNode = getNode(index);
		E replaced = currNode.data;
		currNode.data = element;

		return replaced;
	}

	//	Helper Method
	public LLNode<E> getNode(int index) {

		LLNode<E> currNode = this.head;

		for (int i = 0; i < size; i++) {
			if (i == index) {
				return currNode;
			} else {
				currNode = currNode.next;
			}
		}
		return currNode;
	}

	// Helper

	public void printNodes() {

		LLNode<E> currNode = this.head;

		for (int i = 0; i < size; i++) {
			System.out.print(i);
			System.out.print(currNode.toString());
			currNode = currNode.next;
		}
	}

}
	class LLNode<E> {
		LLNode<E> prev;
		LLNode<E> next;
		E data;

		public LLNode(E e, LLNode<E> setPrev, LLNode<E> setNext) {
			this.data = e;
			this.prev = setPrev;
			this.next = setNext;
		}

		public LLNode(E e) {
			this.data = e;
			this.prev = null;
			this.next = null;
		}

		@Override
		public String toString() {
			String dataString = "D:" + this.data.toString();
			String prevString;
			String nextString;

			try {
				prevString = "P:" + prev.data.toString();
			}

			catch(NullPointerException e) {
				prevString = "P:" + "null";
			}

			try {
				nextString = "N:" + next.data.toString();
			}

			catch(NullPointerException e) {
				nextString = "N:" + "null";
			}

			return "[" + prevString + " " + dataString+ " " + nextString + "]" + " ";
		}

	}
