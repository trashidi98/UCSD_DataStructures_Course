/**
 * 
 */
package textgen;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;


/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> singularList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		singularList = new MyLinkedList<Integer>();
		singularList.add(11);
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			emptyList.remove(1);
		}

		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.remove(-1);
		}

		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.remove(3);
		}

		catch (IndexOutOfBoundsException e) {

		}

		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Check the head", (Integer)21, list1.head.data);

		int b = longerList.remove(9);
		assertEquals("Remove: check b is correct ", 9, b);
		assertEquals("Remove: check tail element is correct ", (Integer)8, longerList.get(8));
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		assertEquals("Check the head", (Integer)8, longerList.tail.data);

		int c = longerList.remove(3);
		assertEquals("Remove: check c is correct ", 3, c);
		assertEquals("Remove: check element is correct ", (Integer)4, longerList.get(3));
		assertEquals("Remove: check size is correct ", 8, longerList.size());

		assertEquals("Check the next", (Integer)5, longerList.get(4));
		assertEquals("Check the prev", (Integer)2, longerList.get(2));
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        Integer eight = new Integer(8);
        Integer nine = new Integer(9);
        Integer ten = new Integer(10);

        boolean result;

		try{
			emptyList.add(null);
			fail("Check input is not null");
		}
		catch (NullPointerException e) {

		}

		result =  emptyList.add(eight);

		assertEquals(true, result);
		assertEquals(1, emptyList.size);
		assertEquals(eight, emptyList.head.data);
		assertEquals(eight, emptyList.head.data);
		assertEquals(null, emptyList.tail.next);


		result = emptyList.add(nine);
		assertEquals(2, emptyList.size);
		assertEquals(eight, emptyList.head.data);
		assertEquals(nine, emptyList.tail.data);
		assertEquals(null, emptyList.tail.next);


		result = longerList.add(ten);

		assertEquals(11, longerList.size);
		assertEquals(ten, longerList.tail.data);
		assertEquals(null, longerList.tail.next);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals(10, longerList.size());
		longerList.add(9, 22);
		assertEquals(11, longerList.size());

		shortList.remove(1);
		assertEquals(1, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{

		Integer eight = new Integer(8);
		Integer nine = new Integer(9);
		Integer ten = new Integer(10);

		boolean result;

		try {
			shortList.add(1, null);
		}
		catch (NullPointerException e) {

		}

		try {
			emptyList.add(0, eight);
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
		emptyList.add(-1, eight);
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.add(2, "eight");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.add(-1, "eight");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.add(-1, null);
		}

		catch (IndexOutOfBoundsException e) {

		}

		singularList.add(0, eight);
		assertEquals(eight, singularList.get(0));
		assertEquals(new Integer(11), singularList.get(1));
		assertEquals(eight, singularList.head.data);
		assertEquals( new Integer(11), singularList.tail.data);
		assertEquals(2, singularList.size);


		shortList.add(1, "C");

		assertEquals("C", shortList.get(1));
		assertEquals("B", shortList.get(2));
		assertEquals("A", shortList.get(0));


		longerList.add(9, ten);
		assertEquals(ten, longerList.get(9));

		longerList.add(0, eight);
		assertEquals(eight, longerList.get(0));


		assertEquals(new Integer(9), longerList.get(11));
		assertEquals(new Integer(9), longerList.tail.data);
		assertEquals(eight, longerList.get(9));
		assertEquals(eight, longerList.head.data);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			emptyList.set(1, (Integer)9);
		}

		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.set(-1, "A");
		}

		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.set(3, "A");
		}

		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.add(1, null);
		}

		catch (NullPointerException e) {

		}

		assertEquals("A", shortList.set(0, "Z"));
		assertEquals("Z", shortList.get(0));

		assertEquals((Integer)0, longerList.set(0, 9));
		assertEquals((Integer)9, longerList.set(9, 0));

		assertEquals((Integer)0, longerList.get(9));
		assertEquals((Integer)9, longerList.get(0));
	}

}
