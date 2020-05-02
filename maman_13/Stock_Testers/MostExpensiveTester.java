package Supermarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MostExpensiveTester 
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
	public void Test_01_most_expensive() 
	{		
		assertTrue(st.mostExpensive() == null);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,20));
		assertTrue(st.mostExpensive().equals(st._stock[0]));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,20));
		st.addItem(new FoodItem(new String (name+1), 1000, 100, d1,d2, 10,60,19));
		assertTrue(st.mostExpensive().equals(st._stock[0]));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,19));
		st.addItem(new FoodItem(new String (name+1), 1000, 100, d1,d2, 10,60,20));
		assertTrue(st.mostExpensive().equals(st._stock[1]));	
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,19));
		st.addItem(new FoodItem(new String (name+1), 2000, 100, d1,d2, 10,60,20));
		st.addItem(new FoodItem(new String (name+2), 3000, 100, d1,d2, 10,60,21));
		assertTrue(st.mostExpensive().equals(st._stock[2]));
		assertTrue(st._stock[0].equals(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,19)));
	}
	@Test
	public void Test_02_same_items() 
	{	
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,20));
		st.addItem(new FoodItem(new String (name), 2000, 100, d1,d2, 10,60,20));
		assertTrue(st.mostExpensive().equals(st._stock[0]));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,20));
		st.addItem(new FoodItem(new String (name), 2000, 100, d1,d2, 10,60,21));
		assertTrue(st.mostExpensive().equals(st._stock[1]));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String (name), 1000, 100, d1,d2, 10,60,21));
		st.addItem(new FoodItem(new String (name), 2000, 100, d1,d2, 10,60,20));
		st.addItem(new FoodItem(new String (name), 3000, 100, d3,d2, 10,60,22));
		assertTrue(st.mostExpensive().equals(st._stock[2]));
	}
}
