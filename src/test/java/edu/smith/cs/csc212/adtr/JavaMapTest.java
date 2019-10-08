package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}
	public void testPut() {//create a public void list() operation 
		MapADT<Integer, String> vacant = new JavaMap<>();//Create a "---"ADT with two parameters and a name. Call it a new JavaMap.
	vacant.put(0, "fruit");//within the new list that you named, insert the two specified parameters
	assertEquals(vacant.get(0), true);//How are you going to check the item's in the list
	}
	public void testGet() {
		MapADT<Integer, String> vacant1 = new JavaMap<>();
	vacant1.put(0,"Fruit");
	assertEquals("Fruit", vacant1.get(0));
	}
	public void testSize() {
		MapADT<String, Integer> vacant2 = new JavaMap<>();
	vacant2.put("Juice", 0);
	assertEquals(vacant2.size(), 0);
	}
	public void testRemove() {
		MapADT<String, Integer> vacant3 = new JavaMap<>();
		vacant3.put("Sally",0);
		vacant3.put("Ann", 1);
		vacant3.remove("Sally");
		assertEquals(vacant3.get("Sally"), false);
	}
}