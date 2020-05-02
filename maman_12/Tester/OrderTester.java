package Supermarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTester 
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
	public void Test_01_order_with_different_items()
	{
		assertTrue(st.order(100).equals(""));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		assertTrue(st.order(99).equals("")); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		assertTrue(st.order(100).equals("")); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		assertTrue(st.order(101).equals(name));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 4000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 100, d1, d2, 10, 60,15));
		assertTrue(st.order(101).equals(name+", " + name + "1"));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 4000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 6000, 100, d1, d2, 10, 60,15));
		
		assertTrue(st.order(101).equals(name+", " + name + "1" + ", " + name + "2"));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name+9), 9000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+8), 8000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+7), 7000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+6), 6000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+5), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+4), 4000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+3), 3000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+2), 2000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+1), 1000, 100, d1, d2, 10, 60,15));
		assertTrue(st.order(101).equals(name +  "1" + ", " + name + "2" + ", " +
				name +  "3" + ", " + name + "4" + ", " +
				name +  "5" + ", " + name + "6" + ", " + 
				name +  "7" + ", " + name + "8" + ", " + 
				name +  "9"));
	}
	@Test
	public void Test_02_order_with_same_items()
	{
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d3, d2, 10, 60,15));
		assertTrue(st.order(200).equals(""));
		//		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d3, d2, 10, 60,15));
		System.out.println(st.order(201));
		assertTrue(st.order(201).equals(name + ", "));
				beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d3, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d4, d2, 10, 60,15));
		System.out.println(st);
		System.out.println(st.order(301));
		assertTrue(st.order(301).equals(name + ", "));
		/*				beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d3, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d4, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 5000, 100, d2, d2, 10, 60,15));*/
		//assertTrue(st.order(300).equals(""));

	}
}
