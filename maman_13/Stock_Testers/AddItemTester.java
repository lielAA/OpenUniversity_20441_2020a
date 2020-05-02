package Supermarket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemTester 
{
	Date d1 = new Date(3,2,2020);
	Date d2 = new Date(10,8,2020);
	Date d3 = new Date(15,10,2020);
	Date d4 = new Date(22,12,2020);
	Date date1 = new Date(1, 1, 2000);
    Date date2 = new Date(1, 2, 2000);
	String name = "tomato";
	Stock st = new Stock();
	Stock actual2 = new Stock();

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
	public void Test_01_addItem_stockSize() 
	{
		st.addItem(new FoodItem(new String("tomato"), 1000, 100, d1, d2, 10, 60,15));
		assertEquals(st.getNumOfItems(), 1, "stock not in correct length");
		//
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"1"), 2000, 100, d1, d2, 10, 60,15));
		assertEquals(st.getNumOfItems(), 2);
		//
		for(int i=1;i<=100;i++)
		{
			st.addItem(new FoodItem(new String(name+i), 2000+i, 100, d1, d2, 10, 60,15));
		}
		assertTrue(st.getNumOfItems() == 100, "stock is not 100");
		//
		for(int i=1;i<=101;i++)
		{
			st.addItem(new FoodItem(new String(name+i), 2000+i, 100, d1, d2, 10, 60,15));
		}
		assertTrue(st.getNumOfItems()==100, "stock is not 100");

	}
	@Test
	public void Test_02_item_in_stock_ByName_First_is_Small() 
	{
		//first catalogue num is small
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 2000, 100, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 2 && st._stock[0].getName().equals(name) && st._stock[0].getQuantity()==100);
		beforeMethod();
		//
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 2000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 3000, 100, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 && st._stock[0].getName().equals(name) && st._stock[0].getQuantity()==100);
		beforeMethod();
		//
		for(int i=0;i<=99;i++)
		{
			st.addItem(new FoodItem(new String(name), 2000+i, 100, d1, d2, 10, 60,15));
			assertTrue(st.getNumOfItems() == i+1 && st._stock[i].getName().equals(name) && st._stock[i].getCatalogueNumber()==2000+i);
		}
	}
	@Test
	public void Test_03_item_in_stock_ByName_First_is_biggest() 
	{
		st.addItem(new FoodItem(new String(name), 2000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 2 && st._stock[0].getName().equals(name) && st._stock[0].getQuantity()==200);
		beforeMethod();
		//
		st.addItem(new FoodItem(new String(name), 3000, 300, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 2000, 200, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 && st._stock[0].getName().equals(name) && st._stock[0].getQuantity()==100);
		beforeMethod();
		//
		for(int i=0;i<=99;i++)
		{
			st.addItem(new FoodItem(new String(name), 2000+i, 100, d1, d2, 10, 60,15));
			assertTrue(st.getNumOfItems() == i+1 && st._stock[i].getName().equals(name) && st._stock[i].getCatalogueNumber()==2000+i);
		}

	}
	@Test
	public void Test_04_item_in_stock_ByCatalogueNumber() 
	{
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"2"), 1000, 200, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 2 && st._stock[0].getName().equals(name+"1") && st._stock[0].getQuantity()==100);
		beforeMethod();
		//		//
		st.addItem(new FoodItem(new String(name+"2"), 1000, 200, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"3"), 1000, 300, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 && st._stock[0].getName().equals(name+"2") && st._stock[0].getQuantity()==200);
		beforeMethod();
		//
		for(int i=0;i<=99;i++)
		{
			st.addItem(new FoodItem(new String(name+i), 1000, 100, d1, d2, 10, 60,15));
			assertTrue(st.getNumOfItems() == i+1 && st._stock[i].getCatalogueNumber() == 1000);
		}
		//		
	}
	@Test
	public void Test_05_Sort_Stock_MIN_to_MAX_By_Catalogue_Number()
	{
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"2"), 1001, 100, d1, d2, 10, 60,15));
		assertTrue(st._stock[0].getName().equals(name+1) && st._stock[1].getName().equals(name+2));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"2"), 1001, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"3"), 1002, 100, d1, d2, 10, 60,15));
		assertTrue(st._stock[0].getName().equals(name+1) && st._stock[1].getName().equals(name+2) && 
				st._stock[2].getName().equals(name+3));
		//		//
		beforeMethod();
		for(int i=0;i<=99;i++)
		{
			st.addItem(new FoodItem(new String(name+i), 1000+i, 100, d1, d2, 10, 60,15));
			assertTrue(st._stock[i].getName().equals(name+i));
		}
	}
	@Test
	public void Test_06_different_Production_Date_For_Same_Item()
	{
		st.addItem(new FoodItem(new String(name+"2"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d3, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 2 && st._stock[0].getName().equals(name+2) && 
				st._stock[1].getName().equals(name+1));
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d3, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 300, d4, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 &&  st._stock[0].getQuantity() == 200 && 
				st._stock[1].getQuantity() == 300 && 
				st._stock[2].getQuantity() == 100); 
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 500, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d4, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d3, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 && st._stock[0].getQuantity() == 100 && 
				st._stock[1].getQuantity() == 200 && 
				st._stock[2].getQuantity() == 500);


		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 500, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d4, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d3, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 4000, 400, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 4 && st._stock[0].getQuantity() == 100 && 
				st._stock[1].getQuantity() == 200 && 
				st._stock[2].getQuantity() == 400 &&
				st._stock[3].getQuantity() == 500);
	}
	@Test
	public void Test_07_different_Expiry_Date_For_Same_Item()
	{
		st.addItem(new FoodItem(new String(name+"2"), 1000, 100, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name+"1"), 1000, 100, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 2 && st._stock[0].getName().equals(name+2) && 
				st._stock[1].getName().equals(name+1));


		beforeMethod();
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d4, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d1, d3, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 300, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 &&  st._stock[0].getQuantity() == 200 && 
				st._stock[1].getQuantity() == 300 && 
				st._stock[2].getQuantity() == 100);
		
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 500, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d4, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d1, d3, 10, 60,15));
		assertTrue(st.getNumOfItems() == 3 && st._stock[0].getQuantity() == 100 && 
				st._stock[1].getQuantity() == 200 && 
				st._stock[2].getQuantity() == 500);
		
		//
		beforeMethod();
		st.addItem(new FoodItem(new String(name), 5000, 500, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 100, d1, d4, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 1000, 200, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String(name), 4000, 400, d1, d2, 10, 60,15));
		assertTrue(st.getNumOfItems() == 4 && st._stock[0].getQuantity() == 100 && 
				st._stock[1].getQuantity() == 200 && 
				st._stock[2].getQuantity() == 400 &&
				st._stock[3].getQuantity() == 500);
	}
	@Test
	public void Test_08_sameItems()
	{
		for (int i = 0; i < 100; i++) 
		{
			actual2.addItem(new FoodItem("Name" + i, 1000 + i, 10, date1, date2, 1, 10, 5));
		}
		assertTrue(actual2.addItem(new FoodItem("Name0", 1000, 10, date1, date2, 1, 10, 5)));
		
	}

}