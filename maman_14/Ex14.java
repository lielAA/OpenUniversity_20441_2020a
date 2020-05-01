package Maman14;

/**
 * This class contain 4 different exercises (which is not depend one each other),
 * <br>That come prove student abilities in effectiveness and complexity code, and recursion problem.    
 * @author Liel Adir
 * @version 01-02-2020
 */
public class Ex14 
{
	/**
	 * This static subStrC method receive string s and char c, and returns how many sub-strings existing in s, 
	 * <br>that start and finished in char c, and contain char c inside only 1 time.
	 * <br>For example: s = "cabcabc" c = 'c' --> return 1  
	 * <br><b>Time Complications = O(n) ; Memory Complications = O(1)<b>   
	 * @param s string of chars.  
	 * @param c char that substring is start and finished in. 
	 * @return Integer that represent how many sub-strings existing in s that start and finished in c and contain char c inside only 1 time
	 */
	public static int subStrC(String s, char c)
	{
		int count = 0; // count c chars in s
		//if s is empty string OR s contain only 1 char OR s contain only 2 chars and they equals to c char 
		if((s.equals("")) || (s.length() == 1) || (s.length() == 2 && s.charAt(0) == c && s.charAt(1) == c))
			return 0;
		else
		{
			for(int i=0; i<s.length(); i++)
			{
				if(s.charAt(i) == c) // if this char in s equal to c 
					count ++; // increase by 1 count 
			}
			if(count > 2)
				return count-2; // number of substring in s are equals to (number of c in s)-2  
			return 0;
		}
	}
	/**
	 * This static subStrMaxC method receive string s, char c and integer k.
	 * <br>and returns how many sub-strings existing in s, that start and finished in char c, 
	 * <br>and contain maximum k times the char c. 
	 * <br><b>Time Complications = O(n) ; Memory Complications = O(1)<b> 
	 * @param s string of chars.
	 * @param c char that substring is start and finished in.
	 * @param k maximum times char c could be contain in substring
	 * @return Integer that represent how many sub-strings existing in s that start, finished and contain maximum k times the char c.
	 */
	public static int subStrMaxC(String s, char c, int k) 
	{
		int countC = 0; // number of chars c appears in String s  
		int maxC = 0; // 

		if((s.equals(""))) // if s is empty string
			return 0;
		// if s contain only 2 chars and they equals to c char 
		else if(s.length() == 2 && s.charAt(0) == c && s.charAt(1) == c)
			countC = 2;
		// sum number of c chars in string s
		else	
		{
			for(int i=0; i<s.length(); i++)
			{
				if(s.charAt(i) == c)
					countC ++;
			}
		}
		// if k==0 OR if s contain only 2 chars and they equals to c char
		if(k==0 || (s.length() == 2 && s.charAt(0) == c && s.charAt(1) == c))
			return countC-1;  
		else
		{
			// move k times in string and only if j < (number of c chars in s)
			for(int j=0 ; j<=k && j < countC ; j++)
			{
				maxC += (countC-1-j);
			}
		}
		return maxC;
	}
	/**
	 * This static zeroDistance method receive 1D array, that contain cells with value of 1 OR 0.
	 * <br>The method replace all '1' cells in array, 
	 * <br>with the minimum distance from '1' cell to his closest '0' cell (from right OR left).
	 * <br><b>Time Complications = O(n) ; Memory Complications = O(1)<b>   
	 * @param a array with '0' OR '1' cells values. 
	 */
	public static void zeroDistance (int [] a) 
	{
		int pointerZero = 0; // point to cell with 0
		int dist = 0; // distance between cell with zero to cell with one 
		int tempVal = 0; // save temporary cell value after first loop  
		boolean pointerOnFlag = false; // flag for pointer zero 

		// First loop - find all cell that are not 0 and there is at least one zero cell(a[i] == 0) to their left side 
		// Calculate the difference between one cell(a[i] == 1) to closest left zero cell, and save the result inside one cell(a[i] = 1).   
		for(int i=0 ; i<a.length-1 ; i++)
		{
			// if cell is 0 (a[i] == 0)
			if(a[i] == 0 )
			{
				pointerOnFlag = true;
				pointerZero = i; // keep pointer zero
				// if next cell is not 0.
				if(a[i+1] != 0 )
					a[i+1] = (i+1) - pointerZero; // cell quantity compare to difference between closest pointerZero to current cell 
				else
					continue; // jump to next iteration
			}
			// if cell is 1 and we already found pointerZero
			if(a[i] != 0 && pointerOnFlag)
			{
				a[i] = i - pointerZero;	// cell quantity compare to difference between closest pointerZero to current cell	
			}
			// if cell is 1 but we still not found pointerZero
			else if(a[i] != 0 && !(pointerOnFlag))
				a[i] = a.length - i; // cell value compare to a length - i (verify for biggest number that in next loop will replaced)
		}
		// calculation for last cell in array 
		if(a[a.length-1] != 0)
		{
			a[a.length-1] = ((a.length-1) - pointerZero);
		}

		pointerOnFlag = false; // reset to false - pointerOn
		for(int j=a.length-1 ; j>0 ; j--)
		{
			if(a[j] == 0) // find pointer zero
			{
				pointerOnFlag = true; // turn on zero flag
				pointerZero = j; 
				if(a[j-1] != 0) // if next cell is 1
				{
					dist = pointerZero - (j-1); // calculate his distance from closest rigth zero
					continue;
				}
				else 
					continue;
			}
			// if cell is not 0 and we found zero - check if right zero is closest that left one 
			if(a[j] != 0 && pointerOnFlag)
			{
				dist = pointerZero - j;
				tempVal = a[j]; // keep in temporary variable
				a[j] = dist;  
				if(dist > tempVal)
					a[j] = tempVal; // replace if right zero is closest than left zero 
			}
		}
		// // calculation for first cell in array
		if(a[0] != 0)
		{
			dist = pointerZero - 0;
			tempVal = a[0];
			a[0] = dist;
		}
		if(dist < tempVal && a[0] != 0)
			a[0] = dist;
	}

	/**
	 * This static isTrans recursive method receive string s and string t.
	 * <br>The method return 'true' if string t is transformation of s and 'false' if t is not transformation.  
	 * <br>String t is Transformation of s if: all chars in s existing in t (by the order of s) at least one time,
	 * <br>and t not contain chars that not in s. 
	 * @param s source string.
	 * @param t transformation string.
	 * @return true if t transformation of s OR false if t not transformation of s. 
	 */
	public static boolean isTrans (String s, String t) 
	{
		// if s length and t length are 0 --> its mean that the recursion arrived to the end
		// and t is transformation of s
		if(s.length() == 0 && t.length() == 0)
		{
			return true;
		}
		// if recursion arrived to end of s but t is not done OR 
		// if s is bigger than t (couldn't be transformation) OR
		// if first s char and first t char are not equals. 
		if((s.length() == 0) || s.length() > t.length() || s.charAt(0) != t.charAt(0))
			return false;
		//two option are possibles:
		//option 1 - try to substring both s and t string (check next char in strings).
		//option 2 - keep s string as now (don't change) and substring (by 1) only t (check next char only in t string)
		else
			return isTrans(s.substring(1), t.substring(1)) || isTrans(s, t.substring(1));

	}
	/**
	 * This static countPaths recursive method calculate how many legal paths are possible in matrix of numbers (matrix cell values are between 0-99).
	 * <br>Valid paths defined as: a set of cells in the array, starting with the first cell (Row 0 and column 0),
	 * <br>and advances the array by the unity and tens of digits in the cell (up to the last cell in the array).   
	 * <br>for example: if cell mat[2][3] == 15, so path could move (row by 1 and column by 5) OR (row by 5 and column by 1)  
	 * @param mat 2D array (matrix) of integer numbers between 0-99
	 * @return integer number that represent how many legal paths are possible in matrix.
	 */
	public static int countPaths (int [][] mat)
	{
		// call to overloading method with first cell in matrix. 
		return countPaths(mat, 0, 0);
	}

	//This static overloading countPaths recursive method calculate how many legal paths are possible in matrix of numbers (matrix cell values are between 0-99).
	//Valid paths defined as: a set of cells in the array, starting with the first cell (Row 0 and column 0),
	//and advances the array by the unity and tens of digits in the cell (up to the last cell in the array).   
	//for example: if cell mat[2][3] == 15, so path could move (row by 1 and column by 5) OR (row by 5 and column by 1)	 
	private static int countPaths(int [][] mat, int row, int column)
	{
		// if deviated from array borders/sizes (by row or column) OR cell value is 0 (can't moved anywhere)  
		if(row > mat.length-1 || column > mat[0].length-1 || mat[row][column] == 0)
			return 0;
		// if we arrived successfully to last cell in array (mat[mat.length-1][mat[0].length-1]) return +1 (its mean there is 1 path)    
		if(row == mat.length-1 && column == mat[0].length-1)
			return 1;
		// if cell dozens number and units number is equals (e.g "22" || "55" etc.) - move to next cell by this number. 
		if(mat[row][column]%10 == mat[row][column]/10)
			return countPaths(mat, row+mat[row][column]/10, column+mat[row][column]/10);
		// try moving by 2 ways : 
		// option 1 --> move rows by dozens number and column by units number.
		// option 2 --> move rows by units number and column by dozens number.
		else
			return countPaths(mat, row+mat[row][column]/10, column+mat[row][column]%10) + // move rows by dozens number and column by units number
					countPaths(mat, row+mat[row][column]%10, column+mat[row][column]/10); // move rows by units number and column by dozens number
	}
}