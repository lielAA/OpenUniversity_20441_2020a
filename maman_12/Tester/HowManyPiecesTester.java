package Supermarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HowManyPiecesTester 
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
	public void Test_01_positive_Test() 
	{
		assertTrue(st.howManyPieces() == 0);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"), 1000, 1, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 1);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 2);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"+1), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 2000, 2, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 4);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"), 1000, 0, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 2000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 3000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 4000, 0, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 4);
	}
	@Test
	public void Test_02_with_same_items() 
	{
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 4);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 1000, 0, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 4);
		//
		beforeMethod();
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"), 1000, 2, d1, d2, 10, 60,15));
		st.addItem(new FoodItem(new String("tomato"+1), 1000, 3, d1, d2, 10, 60,15));
		assertTrue(st.howManyPieces() == 7);
	}
}
