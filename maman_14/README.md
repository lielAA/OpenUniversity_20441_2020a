# Main Purpose

This class contain 4 different exercises (which is not depend one each other), That come prove student abilities in effectiveness and complexity code, and recursion problem. 

##Exe14.java methods

- <b>public static int subStrC(String s, char c)</b> --> This static subStrC method receive string s and char c, and returns how many sub-strings existing in s, that start and finished in char c, and contain char c inside only 1 time.For example: s = "cabcabc" c = 'c' --> return 1 
<I>Time Complications = O(n) ; Memory Complications = O(1)</I>   
- <b>public static int subStrMaxC(String s, char c, int k)</b> -->  This static subStrMaxC method receive string s, char c and integer k. and returns how many sub-strings existing in s, that start and finished in char c, and contain maximum k times the char c.
<I>Time Complications = O(n) ; Memory Complications = O(1)</I>
- <b>public static void zeroDistance (int [] a)</b> --> This static zeroDistance method receive 1D array, that contain cells with value of 1 OR 0. The method replace all '1' cells in array, 
with the minimum distance from '1' cell to his closest '0' cell (from right OR left).
<I>Time Complications = O(n) ; Memory Complications = O(1)</I>    
- <b>public static boolean isTrans (String s, String t)</b> --> This static isTrans recursive method receive string s and string t. The method return 'true' if string t is transformation of s and 'false' if t is not transformation.String t is Transformation of s if: all chars in s existing in t (by the order of s) at least one time, and t not contain chars that not in s.  
- <b>public static int countPaths (int [][] mat)</b> --> This static countPaths recursive method calculate how many legal paths are possible in matrix of numbers (matrix cell values are between 0-99). Valid paths defined as: a set of cells in the array, starting with the first cell (Row 0 and column 0), and advances the array by the unity and tens of digits in the cell (up to the last cell in the array). 
for example: if cell mat[2][3] == 15, so path could move (row by 1 and column by 5) OR (row by 5 and column by 1)

