package Supermarket;


/**
 * This class represents a Stock of Items.
 * @author Liel Adir
 * @version 28-12-2019
 */
public class Stock 
{
	FoodItem[] _stock; // array of foodItems
	int _noOfItems; // number of food items inside stock
	public static final int MAX_ITEMS = 100; // max of food item that could be store in array stock
	public final int MAX_INTEGER_NUMBER = Integer.MAX_VALUE; // the biggest integer number = '2147483647'

	/**
	 * Creates a new default Stock object with 0 items, with max potential size to store 100 items.
	 * 
	 */
	public Stock()
	{
		_stock = new FoodItem[MAX_ITEMS];
		_noOfItems = 0;
	}
	/**
	 * Gets the number of items in Stock
	 * @return The number of items in Stock
	 */
	public int getNumOfItems()
	{
		int counter = 0;
		for(int i=0; i<_noOfItems ; i++)
		{
			if(_stock[i]!=null)
			{
				counter++;
			}
		}
		return counter;
	}
	/**
	 * Add new Item to Stock:
	 * <br>Sort (by minimum to maximum) the stock by catalogue number.
	 * <br>If Stock is full (100 items) new item will not be added.
	 * <br>If Item already in stock (same name and catalogue number), The quantity of new item will be added to exist item.
	 * <br>If Item already in stock (same name and catalogue number), but production OR expire dates are different:
	 * <br>The new Item will be added to the Stock as a new item, but before the existing item
	 * @param newItem item to be added
	 * @return true if food item added to Stock 
	 */
	public boolean addItem(FoodItem newItem)
	{
		if(itemInStock(newItem)) // if new item (by name) already exist in stock
		{
			//productionDate OR expirtyDate of existing item is different from productionDate OR expirtyDate of new item
			if(differentProductionOrExpiryDate(_stock[itemEqualsLocation(newItem)], newItem))  
			{
				if(_noOfItems < _stock.length)
				{
					// if stock is not full (stock < 100)
					for(int i =_noOfItems-1 ; i>=0 ; i--)
					{
						_stock[i+1] = _stock[i];
						_stock[i] = new FoodItem(newItem);
						_noOfItems++;
						return true;
					}
				}
				else
					return false;
			}
			// if productionDate OR expirtyDate equals between newItem to item from stock
			else
			{
				int sumOfQuantity = sumOfQuantity(_stock[itemEqualsLocation(newItem)], newItem);    //(_stock[itemEqualsLocation(newItem)].getQuantity()) + (newItem.getQuantity());
				_stock[itemEqualsLocation(newItem)].setQuantity(sumOfQuantity); // set sum of Quantity
				return true;
			}
		}
		else
		{
			// if stock is not full (stock < 100)
			if(_noOfItems < _stock.length)
			{
				// empty array or catalogue number of new item is the biggest in array 
				if(emptyArrOrItemIsBiggest(newItem))
				{
					_stock[_noOfItems] = new FoodItem(newItem);
					_noOfItems++;
					return true;
				}
				else
				{
					for(int i=_noOfItems-1 ; i>0 ; i--)
					{
						if(_stock[i].getCatalogueNumber() > newItem.getCatalogueNumber())
							_stock[i+1] = _stock[i];
						else
						{
							_stock[i+1] = new FoodItem(newItem);
							_noOfItems++;
							return true;
						}

						if(_stock[i-1].getCatalogueNumber() < newItem.getCatalogueNumber()) // sort stock items by catalogue number (min to max)
						{
							_stock[i] = new FoodItem(newItem); 
							_noOfItems++;
							return true;
						} 
					}
					// for i=0
					if(_stock[0].getCatalogueNumber() > newItem.getCatalogueNumber())
					{
						_stock[1] = _stock[0];
						_stock[0] = new FoodItem(newItem);
						_noOfItems++;
					}
					else
					{
						_stock[1] = new FoodItem(newItem);
						_noOfItems++;
					}
					return true;
				}
			}
		}
		return false;
	}

	//##########################################################################################
	//##########################################################################################
	/**
	 * Return String of all FoodItems that exist in Stock that their quantity is small than amount.
	 * <br>If in Stock there is Items with same name and catalogue number that their production OR expire dates
	 * <br>are different, The quantity of these items consider as the of them.      
	 * @param amount represent the upper limit of quantity per item that will return   
	 * @return String that represent the name of all food items that their quantity is small than amount.
	 * For Example: milk, tomato, cucumber.   
	 */
	public String order(int amount)
	{
		String list = "";
		int sumOfQuantity = 0;

		// for empty stock
		if(_noOfItems==0)
		{
			list = "";
		}
		// while stock contain only 1 Food Item
		else if(_noOfItems==1)
		{
			if(_stock[0].getQuantity() < amount)
				list = _stock[0].getName();
		}
		else
		{

			if(_stock[0].getName().equals(_stock[1].getName()) && _stock[0].getCatalogueNumber() == _stock[1].getCatalogueNumber())
			{
				sumOfQuantity = _stock[0].getQuantity() + _stock[1].getQuantity();
			}

			if(sumOfQuantity < amount)
			{
				list = _stock[0].getName() + ", ";
			}

			//###########
			for(int i=1 ; i<_noOfItems ; i++)
			{
				// if items are equals by name && catalogue number
				if(_stock[i].getName().equals(_stock[i-1].getName()))
				{
					sumOfQuantity += _stock[i].getQuantity();
					if(sumOfQuantity < amount)
					{
						if(i<_noOfItems-1)
						{
							list = _stock[i].getName() + ", ";
						}
						//print last item without ', '
						else
						{
							list = _stock[i].getName() ;
						}
					}
				}
				else
				{
					if(_stock[i].getQuantity() < amount)
					{
						if(i<_noOfItems-1)
						{
							list += _stock[i].getName()+ ", ";
						}
						//print last item without ', '
						else
						{
							list += _stock[i].getName() ;
						}
					}
				}
			}

		}
		return list;
	}
	//##########################################################################################
	//##########################################################################################
	/**
	 * Return number of items that could be store in refrigerator depend on min and max temperature of items,
	 * <br>and the temperature of refrigerator.
	 * <br>If refrigerator temperature between min and max temperature of item the quantity of item will be count.
	 * @param temp the temperature of refrigerator.
	 * @return - the numbers of all items that could be store in refrigerator. 
	 */
	public int howMany(int temp)
	{
		int itemesCounter = 0;
		//if stock is empty
		if(_noOfItems == 0)
			itemesCounter = 0;
		else
		{
			for(int i=0 ; i<_noOfItems ; i++)
			{
				// if amount between min and max item temperature
				if(temp >= _stock[i].getMinTemperature() && temp <= _stock[i].getMaxTemperature() )
				{
					itemesCounter += _stock[i].getQuantity();
				}
			}
		}
		return itemesCounter;
	}

	//##########################################################################################
	//##########################################################################################
	/**
	 * Remove all the items from stock that their expire date before defined date.
	 * <br>If expire date before defined date its mean that the item is a moldy item.
	 * @param d represent the date that will be a bottom limit to expire date.
	 */
	public void removeAfterDate(Date d)
	{
		for(int i=_noOfItems-1 ; i>0 ; i--)
		{
			if(d.after(_stock[i].getExpiryDate())) // if received date is after expire date of item
			{
				_stock[i] = null; // remove item from stock
				_noOfItems--;
			}
		}
		if(_noOfItems==1 && d.after(_stock[0].getExpiryDate())) // if there is only one item in stock and received date is after his expire date. 
		{
			_stock[0] = null;
			_noOfItems--;
		}
		if(_noOfItems>1 && d.after(_stock[0].getExpiryDate())) // if stock contain 2 or more items and received date is after expire date of first item. 
		{
			_stock[0] = _stock[_noOfItems-1];
			_noOfItems--;
		}
	}

	//##########################################################################################
	//##########################################################################################
	/**
	 * Return The food item from stock that his price is most expensive.
	 * <br>If Stock is empty - Retrun 0. 
	 * @return FoodItem that his price is most expensive.
	 */
	public FoodItem mostExpensive()
	{
		FoodItem mostExpensive;
		if(_noOfItems == 0)
		{
			return null;
		}
		else
		{
			mostExpensive = new FoodItem(_stock[0]); //define the first food item as the most expensive item 
			for(int i=1; i<_noOfItems ; i++)
			{
				if(_stock[i].getPrice() > mostExpensive.getPrice()) // 
				{
					mostExpensive = new FoodItem(_stock[i]); //set the most expensive item
				}
			}
		}
		return mostExpensive;
	}

	//##########################################################################################
	//##########################################################################################
	/**
	 * Return the number of all pieces of all items in Stock.
	 * <br>If Stock is empty return 0.
	 * @return the number of all pieces of all items in Stock
	 */
	public int howManyPieces()
	{
		int numOfPieces = 0;

		if(_noOfItems == 0) //if stock is empty
		{
			numOfPieces = 0;
		}
		else
		{
			for(int i=0 ; i<_noOfItems ; i++)
			{
				numOfPieces += _stock[i].getQuantity(); // count the quantity of item
			}
		}
		return numOfPieces;
	}
	//##########################################################################################
	//##########################################################################################
	/**
	 * The method update the stock depend on list of items String, and decrease items quantity for each of items in stock.
	 * <br>If the list contain two (or more) items with same name, the quantity of this item will decrease by two (ore more).
	 * <br>If there is two same items in stock (by name and catalogue number), it will be update the first item until his quantity will be 0.
	 * <br>If quantity of item equal to 0 - it will remove from stock.     
	 * @param itemsList List of items to be updated in Stock.
	 */
	public void updateStock(String[] itemsList) 
	{
		for(int j=itemsList.length-1 ; j>=0 ; j--) // for loop - for itemList - from the end of list to start
		{
			for(int i=0 ; i<_noOfItems-1; i++) // for loop - for stock item - from start of list to 1 item before the end
			{
				if(_stock[i].getName().equals(itemsList[j])) // if item from stock equal to item from list (by name)
				{
					if(_stock[i].getName().equals(_stock[i+1].getName())) // if there is same items (by name)  in list 
					{
						if(_stock[i].getQuantity() > 1) // if quantity of current item > 1
							_stock[i+1].setQuantity(_stock[i+1].getQuantity()+1); // add 1 to quantity of next item (because in the next loop it will decrease by 1)
					}
					_stock[i].setQuantity(_stock[i].getQuantity()-1); // decrease quantity by 1 for current item.
					if(_stock[i].getQuantity() == 0)
					{
						// delete items with quantity = 0, and Re-organize list. 
						for(int k=i ; k<_noOfItems-1 ; k++)
						{
							_stock[k] = _stock[k+1];
						}
						_noOfItems--;
						break;
					}
					// for first item
					if(_stock[0].getQuantity() == 0)
					{
						_stock[0] = null;
						_noOfItems--;
					}
				}
			}
			// for last item in stock
			if(_stock[_noOfItems-1].getName().equals(itemsList[j])) // if there is a match between last item to items in listItem 
			{
				_stock[_noOfItems-1].setQuantity(_stock[_noOfItems-1].getQuantity()-1); // decrease item quantity by 1
				// if quantity of last item = 0 --> delete last item from stock.
				if(_stock[_noOfItems-1].getQuantity() == 0) 
				{
					_stock[_noOfItems-1] = null;
					_noOfItems--;
				}
			}
		}
	}

	//##########################################################################################
	//##########################################################################################
	/**
	 * Return the min of temperature of refrigerator that could store the all items in stock.
	 * <br>If there is no range of temperature - Return '2147483647' 
	 * @return the min of temperature of refrigerator that could store the all items in stock.
	 */
	public int getTempOfStock()
	{
		int minTemp, maxTemp;
		// if stock is empty
		if(_noOfItems == 0)
			return MAX_INTEGER_NUMBER; // represent the number = '2147483647'
		else
		{
			minTemp = _stock[0].getMinTemperature(); //set the min temp to the min temp of first item
			maxTemp = _stock[0].getMaxTemperature(); //set the max temp to the max temp of first item		
			for(int i=1; i<_noOfItems ; i++)
			{
				if(_stock[i].getMinTemperature() > minTemp)
				{
					minTemp = _stock[i].getMinTemperature();
				}
				if(_stock[i].getMaxTemperature() < maxTemp)
				{
					maxTemp = _stock[i].getMaxTemperature();
				}
			}
			if(minTemp <= maxTemp) // if the min temp is small than ma temp --> mean there is a range of refrigerator to store all items
				return minTemp;
			else
				return MAX_INTEGER_NUMBER;
		}
	}

	//################################################
	//### private utilities methods to addItem method 
	//################################################

	// return the location of the item which equals to current FoodItem(to be add) 
	private int itemEqualsLocation(FoodItem newItem)
	{
		for(int i=0 ; i<_noOfItems ; i++)
		{
			if((_stock[i].getName()).equals(newItem.getName()) && (_stock[i].getCatalogueNumber() == newItem.getCatalogueNumber()))
				return i;
		}
		return -1;
	}

	// check if exist item in stock that equals by name to current FoodItem(to add).
	// return true if there is same item in stock. 
	private boolean itemInStock(FoodItem newItem)
	{
		for(int i=0 ; i<_noOfItems ; i++)
		{
			if((_stock[i].getName().equals(newItem.getName())) && (_stock[i].getCatalogueNumber() == newItem.getCatalogueNumber()))
				return true;
		}
		return false;
	}
	// (check if array is empty = 0) OR (chack if catalogue number of new item is the biggest in array)  
	private boolean emptyArrOrItemIsBiggest(FoodItem newItem)
	{
		if((_noOfItems == 0) || (_stock[_noOfItems-1].getCatalogueNumber() < newItem.getCatalogueNumber()))
			return true;
		return false;
	}
	// check if productionDate OR expirtyDate of existing item is different from productionDate OR expirtyDate of new item
	private boolean differentProductionOrExpiryDate(FoodItem existItem, FoodItem newItem)
	{
		if(existItem.getProductionDate().equals(newItem.getProductionDate()) && existItem.getExpiryDate().equals(newItem.getExpiryDate()))
			return false; 
		return true;

	}

	// sum the quantity of two items 
	private int sumOfQuantity(FoodItem existItem,FoodItem newItem)
	{
		return (existItem.getQuantity() + newItem.getQuantity());
	}
	/**
	 * Returns a String that represents all FoodItems in Stock 
	 * @overrides toString in class java.lang.Object
	 * @return String that represents this food item in the following format:
	 * <pre>
	 *  FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3<br>
	 *  FoodItem: tomato CatalogueNumber: 4321 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
	 *  
	 */
	public String toString()
	{
		String str = "";
		for(int i=0 ; i<_noOfItems ; i++)
		{
			if(i==0)
				str +=  _stock[i];
			else
				str += "\n" + _stock[i];
		}
		return str;
	}
}
