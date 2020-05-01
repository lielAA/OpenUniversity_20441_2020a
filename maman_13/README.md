# Main Purpose
Stock class is continuation for maman_12 (date and fooditem classes).
Stock represent the stock of all fooditems in the supermarket.

Matrix class represents a Matrix by Two-dimensional array that represent image in black and white colors. 
Any cell in the Matrix represent by integer number between 0-255, while 0 show pure white, and 255 show pure black.

## Stock.java
Stock represent the stock of all fooditems in the supermarket.
It use Date.java and FoodItem.java methods.
### methods

- <b>public boolean addItem(FoodItem newItem)</b> --> Sort (by minimum to maximum) the stock by catalogue number.If Stock is full (100 items) new item will not be added.If Item already in stock (same name and catalogue number), The quantity of new item will be added to exist item.If Item already in stock (same name and catalogue number), but production OR expire dates are different:The new Item will be added to the Stock as a new item, but before the existing item
- <b>public String order(int amount)</b> --> Return String of all FoodItems that exist in Stock that their quantity is small than amount. If in Stock there is Items with same name and catalogue number that their production OR expire dates are different, The quantity of these items consider as the of them.
- <b>public int howMany(int temp)</b> --> Return number of items that could be store in refrigerator depend on min and max temperature of items,and the temperature of refrigerator. If refrigerator temperature between min and max temperature of item the quantity of item will be count.
- <b>public void removeAfterDate(Date d)</b> --> Remove all the items from stock that their expire date before defined date. If expire date before defined date its mean that the item is a moldy item.
- <b>public FoodItem mostExpensive()</b> --> Return The food item from stock that his price is most expensive.If Stock is empty - Retrun 0. 
- <b>public int howManyPieces()</b> --> Return the number of all pieces of all items in Stock. If Stock is empty return 0.
- <b>public void updateStock(String[] itemsList)</b> --> The method update the stock depend on list of items String, and decrease items quantity for each of items in stock.
If the list contain two (or more) items with same name, the quantity of this item will decrease by two (ore more).
If there is two same items in stock (by name and catalogue number), it will be update the first item until his quantity will be 0.
If quantity of item equal to 0 - it will remove from stock.  
- <b>public int getTempOfStock()</b> --> Return the min of temperature of refrigerator that could store the all items in stock.
If there is no range of temperature - Return '2147483647'
- <b>public String toString()</b> --> Returns a String that represents all FoodItems in Stock 

## Matrix.java

### methods

- <b>public Matrix makeNegative()</b> --> Return new Matrix, that represent the negative of the origin image (by colors).
Any number in the matrix will be BLACK minus the cell himself.
For example: 255 became to 0 (255-255) ; and 150 became to 105 (255-150).   
- <b>public Matrix imageFilterAverage()</b> --> Return new Matrix, that represent the image without noise. Any number in origin array will be averaged himself and his closest neighbors. 
- <b>public Matrix rotateClockwise()</b> --> Return new Matrix that rotate the Matrix 90° by Clockwise (to right). 
- <b>public Matrix rotateCounterClockwise()</b> --> Return new Matrix that rotate the Matrix 90° by counter Clockwise (to left).
- <b>public String toString()</b> --> returns a String that represents Matrix of integer numbers, any number between 0-255. 
