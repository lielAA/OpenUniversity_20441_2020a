package Supermarket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class RemoveAfterDateTester
{
	Date d1 = new Date(3,2,2020);
	Date d2 = new Date(10,8,2020);
	Date d3 = new Date(15,10,2020);
	Date d4 = new Date(22,4,2020);
	String name = "tomato";
	Stock st = new Stock();

	@BeforeMethod
	public void beforeMethod()
	{
		for(int i=0; i<st._stock.length; i++)
		{
			st._stock[i] =  null;
			st._noOfItems =0;
		}

	}
	@Test
	public void Test_01_Positive_Test() 
	{
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 0, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(10,9,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 0, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(10,10,2019), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 0, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(10,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 1 && st._stock[0].getName().equals(name), "name of 1st item in stock not equal" + name);
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(11,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 1, "number of itemes != 1");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name+1)), 2000, 100, d2,new Date(10,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._stock[0].getName().equals(name+1), "name of 1st item in stock not equal" + name+1);
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 3000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name+1)), 2000, 100, d2,new Date(10,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 1 && st._stock[0].getName().equals(name+1), "number of itemes != 0 OR name of 1st item in stock not equal" + name+1 );
	}
	@Test
	public void Test_02_Same_items() 
	{
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 0, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 100, d1,new Date(9,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 0, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 200, d1,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 300, d1,new Date(10,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 1, "number of itemes != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem((new String (name)), 2000, 100, d2,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 200, d1,new Date(9,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 300, d1,new Date(10,10,2020), 10,60,15));
		st.addItem(new FoodItem((new String (name)), 2000, 400, d1,new Date(8,10,2020), 10,60,15));
		st.removeAfterDate(new Date(10,10,2020));
		assertTrue(st._noOfItems == 1, "number of itemes != 0");
	}
}
