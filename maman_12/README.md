# Main Purpose
These two code exercises represent only two parts of three, 
That comes to realize Computerized stock system in the supermarket.
The system use Date, fooditem and stock classes.

## Date.java
Date class represent date of specific fooditem.
The date represented by dd/mm/yyyy format, the year is between 1000-9999. 
The representation is considerate in leap years.
### methods
- <b>get methods
- <b>set methods
- <b>public boolean equals(Date other)</b>
--> check if 2 dates are the same
- <b>public boolean before(Date other)</b>
--> check if this date is before other date
- <b>public boolean after(Date other)</b>
--> check if this date is after other date
- <b>public int difference(Date other)</b>
--> calculates the difference in days between two dates
- <b>public Date tomorrow()</b>
--> calculate the date of tomorrow
- <b>public int dayInWeek()</b>
--> calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
- <b>public String toString()</b>
-->  returns a String that represents this date

## FoodItem.java
FoodItem Class represent food item in supermarket and contain the next parameters:
- name
- catalogue Number
- quantity
- Production Date
- Expiry Date
- Min Store Temp
- Max Store Temp
- price
### methods
- <b>get methods</b> --> get fooditem param
- <b>set methods</b> --> set fooditem param
- <b>public boolean equals(FoodItem other)</b> --> check if 2 food items are the same (excluding the quantity values)
- <b>public boolean isFresh(Date d)</b> --> check if this food item is fresh on the date d
- <b>public boolean olderFoodItem(FoodItem other)</b> --> check if this food item is older than other food item
- <b>public int howManyItems(int amount)</b> --> returns the number of units of products that can be purchased for a given amount
- <b>public boolean isCheaper(FoodItem other)</b> --> check if this food item is cheaper than other food item
- <b>public String toString()</b> --> returns a String that represents this food item
