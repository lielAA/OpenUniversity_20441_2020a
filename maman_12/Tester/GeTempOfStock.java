package Supermarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeTempOfStock 
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
	public void Test_01_minTemp_Positive() 
	{
		assertTrue(st.getTempOfStock() == Integer.MAX_VALUE);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		assertTrue(st.getTempOfStock() == 10); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 15,60,15));
		assertTrue(st.getTempOfStock() == 15); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 61,60,15));
		assertTrue(st.getTempOfStock() == 60); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name+1), 1000, 100, d1, d2, 11,60,15));
		assertTrue(st.getTempOfStock() == 11); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name+1), 2000, 100, d1, d2, 11,60,15));
		st.addItem(new FoodItem(new String(name+2), 3000, 100, d1, d2, 15,60,15));
		assertTrue(st.getTempOfStock() == 15); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,15,15));
		st.addItem(new FoodItem(new String(name+1), 2000, 100, d1, d2, 11,60,15));
		st.addItem(new FoodItem(new String(name+2), 3000, 100, d1, d2, 15,60,15));
		assertTrue(st.getTempOfStock() == 15); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name+1), 2000, 100, d1, d2, 11,60,15));
		st.addItem(new FoodItem(new String(name+2), 3000, 100, d1, d2, 15,60,15));
		st.addItem(new FoodItem(new String(name+3), 3000, 100, d1, d2, 8,14,15));
		assertTrue(st.getTempOfStock() == Integer.MAX_VALUE); 
	}
	@Test
	public void Test_02_minTemp_sameItems() 
	{
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		assertTrue(st.getTempOfStock() == 10); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 11,60,15));
		assertTrue(st.getTempOfStock() == 10); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 11,60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		assertTrue(st.getTempOfStock() == 11); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 11,60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name+1), 1000, 100, d1, d2, 10,60,15));
		assertTrue(st.getTempOfStock() == 11);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 11,11,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10,60,15));
		st.addItem(new FoodItem(new String(name+1), 1000, 100, d1, d2, 10,60,15));
		assertTrue(st.getTempOfStock() == 11);

	}
}
