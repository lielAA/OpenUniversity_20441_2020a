import java.util.Scanner;
/**
 *Congruent.java
 *Description: This program Received X and Y coordinates axis for two different triangles (3 vertexs for each triangle), 
 *Verify for legal triangles, and calculate 3 sides lengths for each triangle.  
 *In the end, the program verify if these two triangles are congruent.
 *@author Liel Adir
 *@version 30-11-2019 
*/
public class Congruent
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program received 3 vertexes from two triangels, Calculate the length of each trianle side,"+ 
                           " in the end Check if this two triangles are congruents.");
                           
        //############## Received 3 vertex's coordinates for the 1st triangle from the user, caclculate and print 3 sides length ################                    
        double x11 ,x12, x13 ,y11 , y12, y13; // variables for 3 vertexs (each vertex contain X and Y values).
        
        System.out.println("Please enter 3 Vertex's for the first triangle");        
        //######################
        System.out.println("Please enter X axis coordinate for 1st Vertex: ");
        x11 = scan.nextInt(); // Received X axis variable for the 1st vertex from the user 
        System.out.println("Please enter Y axis coordinate for 1st Vertex: ");
        y11 = scan.nextInt(); // Received Y axis variable for the 1st vertex from the user
        
        System.out.println("Please enter X axis coordinate for 2nd Vertex: ");
        x12 = scan.nextInt(); // Received X axis variable for the 2nd vertex from the user
        System.out.println("Please enter Y axis coordinate for 2nd Vertex: ");
        y12 = scan.nextInt();// Received Y axis variable for the 2nd vertex from the user
        
        System.out.println("Please enter X axis coordinate for 3rd Vertex: ");
        x13 = scan.nextInt(); // Received X axis variable for the 3rd vertex from the user
        System.out.println("Please enter Y axis coordinate for 3rd Vertex: ");
        y13 = scan.nextInt(); // Received Y axis variable for the 3rd vertex from the user
        System.out.println("The first triangle is (" + x11 + ", " + y11 + ")" +"(" + x12 + ", " + y12 +")" +"(" + x13 + ", " + y13 +")");
        
        //############# Calculate 3 sides length for the 1st triangle ############# 
        
        double a1, b1, c1; // variables for 3 sides lengths of the 1st triangle.
        a1 = Math.sqrt(Math.pow((x11-x12), 2) + Math.pow((y11-y12), 2)); // Calculate 1st side by "distance between 2 points" formula.
        b1 = Math.sqrt(Math.pow((x12-x13), 2) + Math.pow((y12-y13), 2)); // Calculate 2nd side by "distance between 2 points" formula.
        c1 = Math.sqrt(Math.pow((x11-x13), 2) + Math.pow((y11-y13), 2)); // Calculate 3rd side by "distance between 2 points" formula.
        
        //############# Condition for legal entered triangle #############
        
        if(a1+b1<=c1 || a1+c1<=b1 || b1+c1<=a1) // if sum of 2 sides of the triangle is smaller than the third --> illegal triangle
            System.out.println("Incorrect triangle's sides lengths, please Re-enter a valid lengths");
        else
            System.out.println("The lengths are " + a1 + ", " + b1 + ", " + c1  + "." + "\n\n\n");
        
        //############# Received 3 vertex's coordinates for the 2nd triangle from the user, caclculate and print 3 sides length ############
        
        double x21 ,x22, x23 ,y21 , y22, y23; // variables for 3 vertexs (each vertex contain X and Y values).
        
        System.out.println("Please enter 3 Vertex's for the second triangle");
        //#######################
        System.out.println("Please enter X coordinate axis for 1st Vertex: ");
        x21 = scan.nextInt(); // Received X axis variable for the 1st vertex from the user
        System.out.println("Please enter Y coordinate axis for 1st Vertex: ");
        y21 = scan.nextInt(); // Received Y axis variable for the 1st vertex from the user
        
        System.out.println("Please enter X coordinate axis for 2nd Vertex: ");
        x22 = scan.nextInt(); // Received X axis variable for the 2nd vertex from the user
        System.out.println("Please enter Y coordinate axis for 2nd Vertex: ");
        y22 = scan.nextInt(); // Received Yaxis variable for the 2nd vertex from the user
        
        System.out.println("Please enter X coordinate axis for 3rd Vertex: ");
        x23 = scan.nextInt(); // Received X axis variable for the 3rd vertex from the user
        System.out.println("Please enter Y coordinate axis for 3rd Vertex: ");
        y23 = scan.nextInt(); // Received Y axis variable for the 3rd vertex from the user
        System.out.println("The second triangle is (" + x21 + ", " + y21 + ")" +"(" + x22 + ", " + y22 +")" +"(" + x23 + ", " + y23 +")"); 
        
        //############# Calculate 3 sides length for the 2nd triangle ############# 
        
        double a2, b2, c2; // variables for 3 sided of the 2nd triangle.
        a2 = Math.sqrt(Math.pow((x21-x22), 2) + Math.pow((y21-y22), 2)); // Calculate 1st side by "distance between 2 points" formula.
        b2 = Math.sqrt(Math.pow((x22-x23), 2) + Math.pow((y22-y23), 2)); // Calculate 2nd side by "distance between 2 points" formula.
        c2 = Math.sqrt(Math.pow((x21-x23), 2) + Math.pow((y21-y23), 2)); // Calculate 3rd side by "distance between 2 points" formula.
        
        //############# Condition for legal entered triangle #############
        
        if(a2+b2<=c2 || a2+c2<=b2 || b2+c2<=a2) // if sum of 2 sides of the triangle is smaller than the third --> illegal triangle
            System.out.println("Incorrect triangle's sides lengths, please Re-enter a valid lengths");
        else    
            System.out.println("The lengths are " + a2 + ", " + b2 + ", " + c2  + ".");
         
       //############ Verify if two triangles are congruents ###########################
       //############ Compare all sides from triangle one, to all sides from triangle two #############
       
        if((a1==a2 && b1==b2 && c1==c2) || 
           (a1==a2 && b1==c2 && c1==b2) || 
           (a1==b2 && b1==a2 && c1==c2) || 
           (a1==b2 && b1==c2 && c1==a2) ||
           (a1==c2 && b1==a2 && c1==b1) ||
           (a1==c2 && b1==b2 && c1==a2))
           System.out.println("The triangles are congruent");
           else
                System.out.println("The triangles are not congruent");
    }
}