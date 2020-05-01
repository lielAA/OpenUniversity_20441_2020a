import java.util.Scanner;
/**
 *Triangle.java
 *Descriprtion: This program Receives 3 variables from the user (each variable represent one side of triangle), 
 *and calculate the area and perimeter of trangle. 
 *@author Liel Adir
 *@version 30-11-2019 
*/

public class Triangle
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in); // new object for Scanner.class
        System.out.println("This program calculate the area" + " and the perimeter of the given triangle.");
        System.out.println("Please enter the three lengths" + " of the triangle's sides");

        //############ Input from the User ############
        int a = scan.nextInt(); // receive 1st triangle side value from the user, and save it in 'a' Integer variable. 
        int b = scan.nextInt(); // receive 2nd triangle side new value from the user, and save it in 'b' Integer variable.
        int c = scan.nextInt(); // receive 3rd triangle side new value from the user, and save it in 'c' Integer variable.

        //############ Condition for legal entered triangle ############ 
        if(a+b<=c || a+c<=b || b+c<=a) // condition = if the sum of two sides of the triangle is smaller than the third side and if one of the sides equals or smaller than 0 an Error message display to the user.
        {                                                                        
            System.out.println("Incorrect triangle's sides lengths, please Re-enter a valid lengths");
        }
        else
        {    
            //############ Caculate and print triangle Perimeter ############    
            int trianglePerimeter = a+b+c; // Calculate triangle perimeter (Sum of three sides).
            System.out.println("The perimeter of the given triangle is = " + trianglePerimeter); // Output.

            //############ Caculate and print triangle Area ############
            double halfTrianglePerimeter = (double)trianglePerimeter/2; // Calculate half result of triangle perimeter and casting to 'double'. 
            double triangleArea = Math.sqrt(halfTrianglePerimeter * (halfTrianglePerimeter - a) * (halfTrianglePerimeter - b) * (halfTrianglePerimeter - c)); // Calculate triangle area by "Heron" Formula, using Math.sqrt class for Square root result.  
            System.out.println("The area of the given triangle is = " + triangleArea); 
        }
    }
}