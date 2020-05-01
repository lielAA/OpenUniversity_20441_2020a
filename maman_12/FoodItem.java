 

/**
* This class represents a Item object.
* @author Liel Adir
* @version 14-12-2019
*/

public class FoodItem
{
    private String _name;
    private long _catalogueNumber;
    private int _quantity, _minTemperature, _maxTemperature, _price;
    private Date _productionDate;
    private Date _expiryDate;
    /**
    * creates a new FoodItem object
    * @param name name of food item
    * @param catalogueNumber catalogue number of food item
    * @param quantity quantity of food item
    * @param productionDate production date
    * @param expiryDate expiry date
    * @param minTemperature minimum storage temperature
    * @param maxTemperature maximum storage temperature
    * @param price unit price
    */
    //## Constructor takes 8 parameters
    public FoodItem(final String name, final long catalogueNumber, int quantity, Date productionDate, Date expiryDate, final int minTemperature, final int maxTemperature, int price)
    {
        final String DEF_NAME = "item"; // default name if name is empty.
        final long DEF_CAT_NUM = 9999; // default value to catalogue number. 
        final int DEF_QUANTITY = 0; // default value to quantity.
        final int DEF_PRICE = 1; // default value to price.
        int temp;
        //### item name validation ###
        if(validName(name)) // true if name is not empty (>0 char).
            _name = name;  
        else
            _name = DEF_NAME; // set name = "item" if name is empty (==0).
        //### Catalogue number validation ###
        if(validCatalogueNumber(catalogueNumber)) // true if catalogueNumber is number with 4 digits (1000-9999).
            _catalogueNumber = catalogueNumber;
        else
            _catalogueNumber = DEF_CAT_NUM; // set catalogueNumber = 9999, if catalogueNumber<1000 OR catalogueNumber>9999.
        //### Quantity validation ### 
        if(validQunatity(quantity)) // true if quantity is non-negative --> (0 OR posistive).
            _quantity = quantity;
        else
            _quantity = DEF_QUANTITY; // set quantity = 0, if quantity is negative.
        //### Quantity validation ###
        if(validPrice(price)) // true if price is posistive. 
            _price = price;
        else
            _price = DEF_PRICE; // set price = 1, if price is NOT positive --> (0 OR negative).
        //### validate if the expiry date before production date ###
        if(expiryBeforeProduction(productionDate, expiryDate)) // test if expiryDate before ProductionDate.
            _expiryDate = productionDate.tomorrow(); // expiryDate set to one day after productionDate.
        else    
            _expiryDate = expiryDate;
        //### set production date    
        _productionDate = productionDate;
        //### validate - if min Temperature is bigger than max Temperature ###
        if(minTempBigMaxTemp(minTemperature, maxTemperature)) // true if minTemp > maxTemp.
        {
            // replace between minTemp to maxTemp by 'temp' variable.
            temp = minTemperature;
            _minTemperature = maxTemperature;
            _maxTemperature = temp;
        }
        else
        {
          _minTemperature = minTemperature;
          _maxTemperature = maxTemperature;
        }
    }
    /**
    *copy constructor
    *@param other the food item to be copied 
    */
    public FoodItem(FoodItem other)
    {
        _name = other._name;
        _catalogueNumber = other._catalogueNumber;
        _quantity = other._quantity; 
        _price = other._price;
        _minTemperature = other._minTemperature;
        _maxTemperature = other._maxTemperature;
        _productionDate = other._productionDate;
        _expiryDate = other._expiryDate;
    }

    //############################################################
    //#### utilities methods for FoodItem attribute validation####
    //############################################################
    
    //### Name Validation ###
    private boolean validName(String name)
    {
        if(name.length() > 0) // if name is empty = string length = 0 // name couldn't be empty.
            return true;
        return false;    
    }

    //### Catalogue number validation ###
    private boolean validCatalogueNumber(long catalogueNumber)
    {
        final int MIN_VALUE = 1000;
        final int MAX_VALUE = 9999;
        if((catalogueNumber >= MIN_VALUE) && (catalogueNumber <= MAX_VALUE)) // catalogueNumber must to be bweteen 1000-9999.
            return true;
        return false;    
    }

    //### Qunatity Validation ###
    private boolean validQunatity(int quantity) 
    {
        if(quantity >= 0) // quantity must to be non-negative (>=0).
            return true;
        return false;    
    }

    //### Price Validation ###
    private boolean validPrice(int price)
    {
        if(price > 0) // price must to be positive. 
            return true;
        return false;    
    }

    //### Check if Expiry date before production date ###
    private boolean expiryBeforeProduction(Date productionDate, Date expiryDate)
    {
        if(expiryDate.before(productionDate)) // using before method from Date class --> return true if expiryDate before productionDate
            return true;
        return false;    
    }

    //### check if minTemperature > maxTemperature ###
    private boolean minTempBigMaxTemp(int minTemp, int maxTemp)
    {
        if(minTemp > maxTemp) // minTemp can't be bigger than maxTemp
            return true;
        return false;
    }

    
    //##########################################
    //############ get methods #################
    //##########################################
    
    //### return Catalogue Number by get method #### 
    /**
    *gets the catalogue number
    *@return the catalogue number 
    */
    public long getCatalogueNumber()
    {
        return _catalogueNumber; 
    }
    
    //### return item name by get method ####
    /**
    *gets the item name
    *@return the item name 
    */
    public String getName()
    {
        return _name;
    }
    
    //### return production date by get method ####
    /**
    *gets the production date
    *@return the production date 
    */
    public Date getProductionDate()
    {
        return new Date(_productionDate);
    }
    
    //### return expiry date by get method ####
    /**
    *gets the Expiry Date
    *@return the Expiry Date
    */
    public Date getExpiryDate()
    {
        return new Date(_expiryDate);
    }
    //#### return price by get method ####
    /**
    *gets the item price
    *@return the item price
    */
    public int getPrice()
    {
        return _price;
    }
    
    //#### return minTemperature by get method ####
    /**
    *gets the minTemperature
    *@return the minTemperature
    */
    public int getMinTemperature()
    {
        return _minTemperature;
    }
    
    //#### return maxTemperature by get method #### 
    /**
    *gets the maxTemperature
    *@return the maxTemperature
    */
    public int getMaxTemperature()
    {
        return _maxTemperature;
    }
    
    //#### return quantity by get method #### 
    /**
    *gets the quantity
    *@return the qunatity
    */
    public int getQuantity()
    {
        return _quantity;
    }
    

    //##########################################
    //############ set methods #################
    //##########################################
    
    //#### set Quantity by Set method #####
    /**
    * set the quantity (only if not negative)
    * @param n the quantity value to be set 
    */
    public void setQuantity(int n)
    {
        if(validQunatity(n)) // before set the quantity --> test if Quantity is valid --> (non-negative value).
            _quantity = n;
    }
    //#### set production date by Set method #####
    /**
    * set the production date (only if not after expiry date)
    * @param d production date value to be set 
    */
    public void setProductionDate(Date d)
    {
        _productionDate = new Date(d);
    }
    
    //#### set expiry date by Set method #####
    /**
    * set the expiry date (only if not before production date )
    * @param d expiry date value to be set
    */
    public void setExpiryDate(Date d)
    {
        if(!expiryBeforeProduction(_productionDate, d)) // if expiry date is NOT before production date.
            _expiryDate = new Date(d);
    }
    
    //#### set price  by Set method #####
    /**
    *set the price (only if positive)
    *@param n price value to be set 
    */
    public void setPrice(int n)
    {
        if(validPrice(n)) // before set the price --> test if price is valid --> (positive value).
            _price = n;
    }
    
    //####################################################    
    //####different methods for different requirements####
    //####################################################
    
    //### equals method ###
    /**
    * check if 2 food items are the same (excluding the quantity values)
    * @param other the food item to compare this food item to
    * @return true if the food items are the same 
    */
    public boolean equals(FoodItem other)
    {
        if(_name.equals(other._name) &&
           _catalogueNumber == (other._catalogueNumber) &&
           _minTemperature == other._minTemperature &&
           _maxTemperature == other._maxTemperature &&
           _price == other._price && 
           _productionDate.equals(other._productionDate) &&
           _expiryDate.equals(other._expiryDate)
           )
            return true;   
        return false;
    }
    
    //### isFresh method ###
    /**
    * check if this food item is fresh on the date d
    * @param d date to check
    * @return true if this food item is fresh on the date d 
    */
    public boolean isFresh(Date d)
    {
        if((d.after(_productionDate) || d.equals(_productionDate))/* d is after OR equals to productionDate*/ && 
           (d.before(_expiryDate) || d.equals(_expiryDate))/*d before OR equals to expiryDate*/)
            return true;
        return false;    
    }
    //### olderFoodItem method ###
    /**
    * check if this food item is older than other food item
    * @param other food item to compare this food item to
    * @return true if this food item is older than other date
    */
    public boolean olderFoodItem(FoodItem other)
    {
        if(_productionDate.before(other._productionDate))
            return true;
        return false;    
    }
    //### howManyItemes method ###
    /**
    * returns the number of units of products that can be purchased for a given amount
    * @param amount amount to purchase
    * @return the number of units can be purchased
    */
    public int howManyItems(int amount)
    {
        double itemsPerAmount = amount / _price; // 
        if((_quantity > 0) && (itemsPerAmount >= 1))
        {
            if(itemsPerAmount <= _quantity) // 
                return (int)(itemsPerAmount);
            else // itemesPerAmount > _price    
                return _quantity;
        }
        else
            return 0; // if(quantity is empty OR amount is not enough for at least 1 item) 
    }
    
    //### isCheaper method ###
    /**
     * check if this food item is cheaper than other food item
     * @param other food item to compare this food item to
     * @retun true if this food item is cheaper than other date 
     */
    public boolean isCheaper(FoodItem other)
    {
        if(_price < other._price)
            return true;
        return false;    
    }
    
    //### print constructor attributes ###
    /**
    * returns a String that represents this food item
    * @overrides toString in class java.lang.Object
    * @return String that represents this food item in the following format:
    *  FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
    */
    public String toString()
    {
        return "FoodItem: " + _name + "\tCatalogueNumber: " + _catalogueNumber + "\tProductionDate: " + _productionDate
        + "\tExpiryDate: " + _expiryDate + "\tQuantity: " + _quantity;
    }
}
