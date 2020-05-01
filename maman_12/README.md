# Main Purpose
These two code exercises represent only two parts of three, 
That comes to realize Computerized stock system in the supermarket.
The system use Date, fooditem and stock classes.

## Date.java
Date class represent date of specific fooditem.
The date represented by dd/mm/yyyy format, the year is between 1000-9999. 
The And the representation is considerate in leap years.
### methods
- public boolean equals(Date other)
--> check if 2 dates are the same
- public boolean before(Date other)
--> check if this date is before other date
- public boolean after(Date other)
--> check if this date is after other date
- public int difference(Date other)
--> calculates the difference in days between two dates
- public Date tomorrow()
--> calculate the date of tomorrow
- public int dayInWeek()
--> calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
- public String toString()
-->  returns a String that represents this date
