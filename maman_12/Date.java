 

public class Date 
{
private int _day, _month, _year; // date parameters.
    
    /**
    * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
    * @param _day the day in the month(1-31)
    * @param _month the month in the year(1-12)
    * @param _year the year (in 4 digits ; 1000-9999)
    */
    
    public Date(int day, int month, int year)
    {       
        if(validDay(day) && validMonth(month) && validYear(year)) 
        {
            if(validMaxDayInMonth(day, month, year))
            {
                _day = day;
                _month = month;
                _year = year;
            }
            else
                defaultDate(); // set default date 1\1\2000 if date is illegal  (for example: 31/4/1994)
        }
        else
            defaultDate(); // set default date 1\1\2000 if one of the parameters (day/month/year) is illegal (for example: day = 32)
    }
    
    /**
    * copy constructor 
    * @param other the date to be copied
    */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    //###############################################
    //#### utilities methods for Date validations####
    //###############################################
    
    //#### validYear method check if the current day is legal (1-31).
    //#### if yes return 'true'   ;   if not return 'false'.
    private boolean validDay(int day)
    {
        final int MIN_DAY = 1;
        final int MAX_DAY = 31;
        return (day >= MIN_DAY && day <= MAX_DAY); // verify for legal day in month (1-31) 
    }
    //#### validMonth method check if the current month is legal (1-12) 12 months in one year.
    //#### if yes return 'true'   ;   if not return 'false'.
    private boolean validMonth(int month)
    {
        final int MIN_MONTH = 1;
        final int MAX_MONTH = 12;
        return (month >= MIN_MONTH && month <= MAX_MONTH); // verify for legal month in year (1-12)
    }
    //#### validYear method check if the current year is legal (1000-9999) only 4 digits.
    //#### if yes return 'true'   ;   if not return 'false'. 
    private boolean validYear(int year)
    {
        final int MIN_YEAR = 1000;
        final int MAX_YEAR = 9999;
        return (year >= MIN_YEAR && year <= MAX_YEAR); // verify for legal year (4 digits --> 1000-9999)
    }
    //#### validMaxDayInMonth check how many days exist in relevant month - following to georgian calander ####
    //#### for months (1,3,5,7,8,10,12) set 31 days.
    //#### for months (4,6,9,11) set 30 days. 
    //#### for month (2) set 28 days (for regular year), set 29 days (for leap year). 
    private boolean validMaxDayInMonth(int day ,int month, int year)
    {
        final int MIN_DAY = 1; // min days in any month.
        int maxDayInMonth = 31; // set max days in month.
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDayInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDayInMonth = 30;
                break;
            case 2:
                if(leapYear(year)) // if the year is leap year
                    maxDayInMonth = 29; // leap year
                else
                    maxDayInMonth = 28; // not a leap year   
                break;
        } 
        if(day >= MIN_DAY && day <= maxDayInMonth) // validate that day is between 1-31
            return true;
        return false;    
    }
    
    //####### leapYear method check if the current year is a leap year.
    //####### if yes return 'true'   ;    if not return 'false' 
    private boolean leapYear(int year)
    { 
        if (year%400 == 0)
            return true;
        else if ((year%4 == 0) && (!(year%100 == 0)))
            return true;
        else 
            return false;
    } 

    //##########################################
    //############ get methods #################
    //##########################################
    
    //#### return the day by get method #### 
    /**
    * gets the day
    * @return the day
    */
    public int getDay()
    {
        return _day;
    }
    //#### return the month by get method ####
    /**
    * gets the month
    * @return the month
    */
    public int getMonth()
    {
        return _month;
    }
    //#### return the year by get method ####
    /**
    * gets the year
    * @return the year
    */
    public int getYear()
    {
        return _year;
    }

    //##########################################
    //############ set methods #################
    //##########################################
    
    //#### set day by Set method #####
    /**
    * sets the day (only if date remains valid)
    * @param dayToSet the day value to be set 
    */
    public void setDay(int dayToSet)
    {
        if(validDay(dayToSet) && validMaxDayInMonth(dayToSet, _month, _year))
            _day = dayToSet;
    }
    //#### set month by Set method #####
    /**
    * sets the month (only if date remains valid)
    * @param monthToSet the month value to be set 
    */
    public void setMonth(int monthToSet)
    {
        if(validMonth(monthToSet) && validMaxDayInMonth(_day, monthToSet, _year))
            _month = monthToSet;
    }
    //#### set year by Set method #####
    /**
    * sets the year (only if date remains valid)
    * @param yearToSet the year value to be set 
    */
    public void setYear(int yearToSet)
    {
        if(validYear(yearToSet) && validMaxDayInMonth(_day, _month, yearToSet))
            _year = yearToSet;
    }

    //####################################################    
    //####different methods for different requirements####
    //####################################################
    
    /**
    * check if 2 dates are the same
    * @param other the date to compare this date to
    * @return true if the dates are the same 
    */
    public boolean equals(Date other)
    {
        if((_day == other._day) && (_month == other._month) && (_year == other._year)) // all date parameters (day, month, yeear) supposed to be the same between two dates
            return true;
        return false;    
    }
    
    /**
    * check if this date is before other date
    * @param other date to compare this date to
    * @return true if this date is before other date
    */
    public boolean before(Date other)
    {
        if(_year < other._year) // if current year before other
            return true;
        else if((_year == other._year) && (_month < other._month)) // if the years are equals and current month before other
            return true; 
        else if((_year == other._year) && (_month == other._month) && (_day < other._day)) // if the years and months are equals and current day before other
            return true;
        else
            return false;
    }

    /**
    * check if this date is after other date
    * @param other date to compare this date to
    * @return true if this date is after other date
    */
    public boolean after(Date other)
    {
        return other.before(this); // if other before current date (return 'true') its mean that current date is after other (return 'true') 
    }

    /**
    * calculates the difference in days between two dates
    * @param other the date to calculate the difference between
    * @return the number of days between the dates
    */
    public int difference(Date other)
    { 
        int numOfDaysForDate1 = calculateDate(_day, _month, _year); // number of days that have passed since the count - for current date 
        int numOfDaysForDate2 = calculateDate(other._day, other._month, other._year); // number of days that have passed since the count - for other date
        //## return only positive numbers  
        if(numOfDaysForDate1 >= numOfDaysForDate2) 
            return numOfDaysForDate1 - numOfDaysForDate2;
        else
            return numOfDaysForDate2 - numOfDaysForDate1;
    }
    //#### calculateDate - return int number that represents the number of days that have passed since the count started.
    private int calculateDate ( int day, int month, int year) 
    {         
        if (month < 3) 
        {             
            year--;             
            month = month + 12;         
        }          
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);    
    }  
    
    /**
    * calculate the date of tomorrow
    * @return the date of tomorrow 
    */
    public Date tomorrow()
    {
        final int INC_BY_ONE = 1;
        final int FIRST_DAY_MONTH = 1; // variable represent first day in month OR first month in year
        if(validMaxDayInMonth(_day + INC_BY_ONE, _month, _year) && validDay(_day + INC_BY_ONE)) // validate for legal date with next day
            return new Date(_day + INC_BY_ONE, _month, _year); // return date with next day 
        else if(validMaxDayInMonth(FIRST_DAY_MONTH, _month + INC_BY_ONE, _year) && (validMonth(_month + INC_BY_ONE))) // validate for legal date with next month
            return new Date(FIRST_DAY_MONTH, _month + INC_BY_ONE, _year); // return date with first day in month and next month.
        else 
            return new Date(FIRST_DAY_MONTH, FIRST_DAY_MONTH, _year + INC_BY_ONE); //  return date with first day in month and first month and next year.      
    }

    /**
    * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
    * @return the day of the week that this date occurs on 
    */
    public int dayInWeek()
    {
        int Day/*day in week 0-6*/, M/*current month*/, Y/*last two digits in year*/, C/*first two digits in year*/, D/*current day*/;
        int newYear = 0; // to prevent aliasing define new variable to decrease year by 1 (if month = 1 || month = 2)
        
        D = _day;
        if(_month == 1 || _month == 2) // if month 1 set as 13, and if 2 set as 14 
        {
            M = spacialMonth(_month);
            newYear = _year - 1; // month 1 and 2 represents as month 13 and 14 (Respectively) of the last year --> therefore decrease year by 1.
            Y = lastTwoDigitsInYear(newYear); 
            C = firstTwoDigitsInYear(newYear);
        }
        else // if month between 3-12
        {
            M = _month;
            Y = lastTwoDigitsInYear(_year); // last two digits in year
            C = firstTwoDigitsInYear(_year); // first two digits in year
        } 
        Day = (D + (26*(M+1))/10 + Y + (Y/4) + (C/4) - (2*C)) % 7; //### fo.rmula to find day in week ### 
        return Math.floorMod(Day, 7); // if result of % operation is < 0 --> calculate to >= 0
    }
    //#### spacialMonth rturn 13 if month is 1, and return 14 if month is 2 
    private int spacialMonth(int month)
    {
        if(month == 1)
            return 13;
        return 14;    
    }
    //#### return last two digits of year by mod (%) operation
    private int lastTwoDigitsInYear(int year)
    {
        return year % 100;
    }
    //#### return first two digits in year by division (/) operation
    private int firstTwoDigitsInYear(int year)
    {
        return year / 100;
    }

    //#### set default date if the date is illegal OR one of the parameters (day, month year) is illegal ######
    private void defaultDate()
    {
        final int DEF_DAY = 1; // default day = 1
        final int DEF_MONTH = 1; // default month = 1
        final int DEF_YEAR = 2000; // default year = 2000
        //#--------------------------#//
        _day = DEF_DAY;
        _month = DEF_MONTH;
        _year = DEF_YEAR;
    }
    /**
    * returns a String that represents this date
    * @overrides toString in class java.lang.Object
    * @return String that represents this date in the following format: day/month/year for example: 02/03/1998 
    */
    public String toString()
    {
        if(_day<=9 && _month<=9) // if day and month between 1-9 (1 digits) add 0 to start of day and month 
            return "0" + _day + "/" + "0" + _month + "/" + _year; 
        else if(_month<=9)
            return _day + "/" + "0"  + _month + "/" + _year; // if month between 1-9 (1 digits) add 0 to start of month ((for example: 04))
        else if(_day<=9)
            return "0" + _day + "/" + _month + "/" + _year; // if day between 1-9 (1 digits) add 0 to start of day (for example: 06)
        else
            return + _day + "/" + _month + "/" + _year;
    }
}