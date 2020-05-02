package Supermarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HowManyTester 
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
	public void Test_01_posistive_value()
	{
		
		assertTrue(st.howMany(10) == 0, "howMany != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 11, 60,15));
		assertTrue(st.howMany(11) == 1, "howMany != 1");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 11, 60,15));
		assertTrue(st.howMany(11) == 2, "howMany != 2");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 5000, 1, d1, d2, 11, 60,15));
		assertTrue(st.howMany(11) == 3, "howMany != 3");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 5000, 10, d1, d2, 11, 60,15));
		assertTrue(st.howMany(11) == 12, "howMany != 12");
	}
	@Test
	public void Test_02_negative_value()
	{
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howMany(9) == 0, "howMany != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 9, 60,15));
		assertTrue(st.howMany(9) == 1, "howMany != 1");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 2, d1, d2, 9, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howMany(9) == 2, "howMany != 2");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 2, d1, d2, 9, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 5000, 3, d1, d2, 8, 60,15));
		assertTrue(st.howMany(9) == 5, "howMany != 5");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 3, d1, d2, 9, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 5000, 3, d1, d2, 8, 60,15));
		st.addItem(new FoodItem(new String(name+3), 5000, 3, d1, d2, 10, 60,15));
		assertTrue(st.howMany(9) == 6, "howMany != 6");
	}
	@Test
	public void Test_03_Same_Items()
	{
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howMany(10) == 2, "howMany != 2");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howMany(10) == 3, "howMany != 3");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 11, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howMany(10) == 0, "howMany != 0");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 11, 60,15));
		assertTrue(st.howMany(10) == 3, "howMany != 3");
	}
	@Test
	public void Test_04_Same_Items_Duplicate_In_Stock()
	{
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d2, d2, 10, 60,15));
		assertTrue(st.howMany(10) == 2, "howMany != 2");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d3, 10, 60,15));
		assertTrue(st.howMany(10) == 2, "howMany != 2");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d2, d2, 11, 60,15));
		assertTrue(st.howMany(10) == 1, "howMany != 1");
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 1, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d2, d2, 11, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 1, d3, d2, 9, 60,15));
		assertTrue(st.howMany(10) == 2, "howMany != 2");
	}
}
