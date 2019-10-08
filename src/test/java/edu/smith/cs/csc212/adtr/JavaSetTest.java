package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSize() {
		
		SetADT<String> Size = new JavaSet<>();//Create an empty data structure
		assertEquals(Size.size(), 0);
		Size.insert("Food");//Place objects within that data structure //In this case insert food into the list
		assertEquals(Size.size(),1);//Check the Size method to see if the items size is 1
		Size.contains("Food");//Check to see if Size contains the item
		assertEquals(Size.contains("Food"), true);//if it does return true
		Size.remove("Food");//remove food from the list
		assertEquals(Size.contains("Food"), false);//when it does return false.
	}
}
