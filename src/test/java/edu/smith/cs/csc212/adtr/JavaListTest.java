package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
		
	}
	public void testSetI() {
		ListADT<String> input3 = makeEmptyList();
		input3.addBack("1");
		input3.addBack("2");
		input3.addBack("3");
		input3.addBack("4");
		input3.setIndex(0, "4");
		Assert.assertEquals(input3.getIndex(0), "4");
	}
	
	public void testAddI() {
		ListADT<String> setup = makeEmptyList();
		setup.addBack("A");
		setup.addBack("B");
		setup.addBack("C");
		setup.addBack("D");
		setup.addIndex(0, "Z");
		Assert.assertEquals(setup.getIndex(0),"Z");
	}
	
	public void testATBack() {
		ListADT<String> behind = makeEmptyList();
		behind.addBack("C");//Alternatively, you can check the back index to see if it was the 4th one.
		behind.addFront("B");
		behind.addFront("A");
		behind.addFront("Z");
		behind.addFront("Y");//Since this is the last value added to the front, you can check the index
		//behind it to see if it got added.
		Assert.assertEquals(behind.getIndex(4), "C");
	}
	
	public void testRemoveB() {
		ListADT<String> backside = makeEmptyList();
		backside.addFront("1");
		backside.addFront("2");
		backside.addFront("3");
		backside.addFront("4");
		backside.addFront("5");
		backside.addFront("6");
		backside.removeBack();
		Assert.assertEquals(backside.getIndex(0),"1" );
	}
	
	public void testRemoveI() {
		ListADT<String> removal = makeEmptyList();
		removal.addFront("1");
		removal.addFront("2");
		removal.addFront("4");
		removal.addFront("8");
		removal.addFront("16");
		removal.addFront("32");
		removal.removeIndex(3);
		Assert.assertEquals(removal.getIndex(3), "8");
	}
	
	public void testRemoveF() {
		ListADT<String> takeout = makeEmptyList();
		takeout.addFront("Z");
		takeout.addFront("Y");
		takeout.addFront("X");
		takeout.addFront("W");
		takeout.addFront("1");
		takeout.addFront("2");
		takeout.removeFront();
		Assert.assertEquals(takeout.getIndex(0), "2");
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}

	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	// TODO: test list addToBack.
	// TODO: test list remove
	// TODO test addIndex methods.
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	// TODO write some tests for setIndex.
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
