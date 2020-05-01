package Supermarket;

/**
 * This class represents a Matrix by Two-dimensional array that represent image in black and white colors. 
 * <br>Any cell in the Matrix represent by integer number between 0-255, while 0 show pure white, and 255 show pure black.
 * @author Liel Adir
 * @version 28-12-2019
 */
public class Matrix 
{
	private int[][] _array; // 2D array.
	final int BLACK = 255; // represent black color. 
	final int WHITE = 0; // represent white color.
	final int AVERAGE_CENTER_CELLS_NUMBERS = 9; // Divisor number for center cells
	final int AVERAGE_EDGE_SIDES_CELLS_NUMBERS = 6; // Divisor number for edge sides cells 
	final int AVERAGE_CORNER_CELLS_NUMBERS = 4; // Divisor number for corners cells
	final int AVERAGE_CENTER_CELLS_1D_NUMBERS = 3; // Divisor number for center cells for one-dimension matrix
	final int AVERAGE_CORNER_CELLS_1D_NUMBERS = 2; // Divisor number for corner cells for one-dimension matrix
	/**
	 * Constructs a size1 by size2 Matrix of zeros.
	 * @param size1 represent number of lines in array
	 * @param size2 represent number of columns in array
	 */
	public Matrix(int size1, int size2)
	{
		_array = new int[size1][size2]; // empty 2D array  
	}

	/**
	 * Constructs a Matrix of 2D array, the dimensions as well as values of this Matrix, 
	 * <br>Will be the same as the dimensions and values of the 2D array. 
	 * @param array Two-dimensional of integer array.
	 */
	public Matrix(int[][] array)
	{
		_array = new int[array.length][array[0].length];
		for(int i=0 ; i<array.length ; i++) // index represent number of lines
		{
			for(int j=0 ; j<array[0].length ; j++) // index represent number of column
			{
				_array[i][j] = array[i][j];
			}
		}
	}
	/**
	 * Return new Matrix, that represent the negative of the origin image (by colors).
	 * <br> Any number in the matrix will be BLACK minus the cell himself.
	 * <br> For example: 255 became to 0 (255-255) ; and 150 became to 105 (255-150).   
	 * @return Matrix the negative of the origin image (by colors).
	 */
	public Matrix makeNegative()
	{
		Matrix negativeMatrix = new Matrix(_array); // pointer object to 'array'
		int [][] newMatrix = negativeMatrix._array;  // copy object to new array (prevent aliasing)

		for(int i=0 ; i<newMatrix.length ; i++) // index represent number of lines
		{
			newMatrix[i][0] = BLACK - newMatrix[i][0]; // make negative for lines
			for(int j=1 ; j<newMatrix[0].length ; j++) // index represent number of column
			{
				newMatrix[i][j] = BLACK - newMatrix[i][j]; // make negative for column 
			}
		}
		return negativeMatrix;
	}
	/**
	 * Return new Matrix, that represent the image without noise.
	 * <br>Any number in origin array will be averaged himself and his closest neighbors. 
	 * @return Matrix the image without noise (averaged neighbors Matrix).  
	 */
	public Matrix imageFilterAverage()
	{
		Matrix imageFilter = new Matrix(_array);
		int[][] newMatrix = imageFilter._array; // copy object to new array (prevent aliasing)
		int tempAverage = 0;

		if(newMatrix.length==1 || newMatrix[0].length==1)
		{
			// matrix size = 1xn
			if(newMatrix.length==1)
			{
				for(int j=0 ; j<newMatrix[0].length ; j++) // index represent number of lines
				{
					{
						// average for corners [0][0] ; [0][end]   
						if(j==0 || j==newMatrix[0].length-1)
						{
							if(j==0) // average for corners [0][0]
							{
								tempAverage = _array[0][j+1];
								newMatrix[0][j] = (_array[0][j] + tempAverage)/AVERAGE_CORNER_CELLS_1D_NUMBERS;
							}
							else // average for corners [0][end]
							{
								tempAverage = _array[0][j-1];
								newMatrix[0][j] = (_array[0][j] + tempAverage)/AVERAGE_CORNER_CELLS_1D_NUMBERS;
							}
						}
						// average for center cells (without edge cells)
						else
						{
							tempAverage = _array[0][j-1] + _array[0][j+1];
							newMatrix[0][j] = (_array[0][j] + tempAverage)/AVERAGE_CENTER_CELLS_1D_NUMBERS;
						}
					}
				}
			}
			// matrix size = nx1
			else
			{
				for(int i=0 ; i<newMatrix.length ; i++) // index represent number of lines
				{
					{
						// average for corners [0][0] ; [end][0] 
						if(i==0 || i==newMatrix.length-1)
						{
							if(i==0) // average for corners [0][0]
							{
								tempAverage = _array[i+1][0];
								newMatrix[i][0] = (_array[i][0] + tempAverage)/AVERAGE_CORNER_CELLS_1D_NUMBERS;
							}
							else // average for corners [end][0]
							{
								tempAverage = _array[i-1][0];
								newMatrix[i][0] = (_array[i][0] + tempAverage)/AVERAGE_CORNER_CELLS_1D_NUMBERS;
							}

						}
						// average for center cells (without edge cells)
						else
						{
							tempAverage = _array[i-1][0] + _array[i+1][0];
							newMatrix[i][0] = (_array[i][0] + tempAverage)/AVERAGE_CENTER_CELLS_1D_NUMBERS;
						}

					}
				}
			}
		}
		else
		{
			for(int i=0 ; i<newMatrix.length ; i++) // index represent number of lines
			{
				// average for center cells (without edge sides)
				if((i> 0 && i<newMatrix.length-1)) // index represent number of column
				{
					for(int j=1 ; j<newMatrix[0].length ; j++)
					{
						// average for center cells (without edge sides)
						if((j>0 && j<newMatrix[0].length-1))
						{
							// average only for cell neighborers 
							tempAverage = _array[i+1][j] + _array[i-1][j] + // for indexes in same column
									_array[i][j+1] + _array[i][j-1] + // for indexes in same line 
									_array[i-1][j-1] + _array[i-1][j+1] + // for upper diagonal line
									_array[i+1][j-1] + _array[i+1][j+1]; // for bottom diagonal line
							newMatrix[i][j] = (_array[i][j] + tempAverage)/AVERAGE_CENTER_CELLS_NUMBERS; // final average result with current cell
						}	
					}
				}
				// average for upper & bottom sides (without the corners) 
				else if(i==0 || i==newMatrix.length-1)
				{
					//tempAverage = 0;
					for(int j=0 ; j<newMatrix[0].length ; j++)
					{
						if(j>0 && j<newMatrix[0].length-1)
						{
							// for upper side (without corners)
							if(i==0)
							{
								tempAverage = _array[i][j-1] + _array[i][j+1] + // for indexes in same line 
										_array[i+1][j] + // for index in same column  
										_array[i+1][j-1] + _array[i+1][j+1]; // for bottom diagonal line
							}
							//for bottom side (without corners)
							else
							{
								// average only for cell neighborers 
								tempAverage = _array[i][j-1] + _array[i][j+1] + // for indexes in same line 
										_array[i-1][j] + // for index in same column 
										_array[i-1][j-1] + _array[i-1][j+1]; // for upper diagonal line
							}
							newMatrix[i][j] = (_array[i][j] + tempAverage)/AVERAGE_EDGE_SIDES_CELLS_NUMBERS; // final average result with current cell 
						}
						// average for corners [0][0] ; [0][end] ; [end][0] ; [end][end] 
						else
						{
							if(j==0 && i==0) // average for [0][0]
							{
								tempAverage = _array[i][j+1] + _array[i+1][j] + _array[i+1][j+1];
							}
							else if(j==0 && i== newMatrix.length-1) // average for [end][0]
							{
								tempAverage = _array[i][j+1] + _array[i-1][j] + _array[i-1][j+1];
							}
							else if(j == newMatrix[0].length-1 && i== 0)  // average for [0][end]
							{
								tempAverage = _array[i][j-1] + _array[i+1][j] + _array[i+1][j-1];
							}
							else // average for [end][end] 
							{
								tempAverage = _array[i][j-1] + _array[i-1][j] + _array[i-1][j-1] ;
							}

							newMatrix[i][j] = (_array[i][j] + tempAverage)/AVERAGE_CORNER_CELLS_NUMBERS; //final average result with current cell
						}
					}
				}
				// average for left & right sides (without the corners) 
				for(int j=0 ; j<newMatrix[0].length ; j++)
				{

					if((i>0 && i<newMatrix.length-1) && (j==0 || j==newMatrix[0].length-1))
					{
						// for left side (without corners)
						if(j==0)
						{
							// average only for cell neighborers 
							tempAverage = _array[i-1][j] + _array[i+1][j] + // for indexes in same column
									_array[i][j+1] + // for index in same line
									_array[i-1][j+1] + _array[i+1][j+1]; // for right diagonal line
						}
						// for right side (without corners)
						else
						{
							// average only for cell neighborers 
							tempAverage = _array[i-1][j] + _array[i+1][j] + // for indexes in same line
									_array[i][j-1] + // for index in same line
									_array[i-1][j-1] + _array[i+1][j-1]; // for left diagonal line
						}
						newMatrix[i][j] = (_array[i][j]+tempAverage)/AVERAGE_EDGE_SIDES_CELLS_NUMBERS; // final average result with current cell
					}
				}
			}
		}
		return imageFilter;
	}
	/**
	 * Return new Matrix that rotate the Matrix 90° by Clockwise (to right). 
	 * @return Matrix rotated 90° by Clockwise.
	 */
	public Matrix rotateClockwise() 
	{
		Matrix rotateClockwise = new Matrix(_array);
		int[][] originArray = rotateClockwise._array; // copy object to new array (prevent aliasing) 
		Matrix newArr = new Matrix(originArray[0].length, originArray.length); // create empty array with opposite size of origin array  
		int[][] rotateArray = newArr._array; // copy object to new array (prevent aliasing)

		for(int j=rotateArray[0].length-1 ; j>=0 ; j--) // index represent number of column 
		{
			for(int i=0 ; i<rotateArray.length ; i++) // index represent number of lines 
			{
				rotateArray[i][j] = originArray[rotateArray[0].length-1-j][i];
			}
		}
		return newArr; // return rotated ClockWise array 
	}
	/**
	 * Return new Matrix that rotate the Matrix 90° by counter Clockwise (to left). 
	 * @return Matrix rotated 90° by counter Clockwise.
	 */
	public Matrix rotateCounterClockwise() 
	{
		Matrix rotateClockwise = new Matrix(_array);
		int[][] originArray = rotateClockwise._array; // copy object to new array (prevent aliasing)  
		Matrix newArr = new Matrix(originArray[0].length, originArray.length); // create empty array with opposite size of origin array  
		int[][] rotateArray = newArr._array; // copy object to new array (prevent aliasing)  

		for(int j=0 ; j<rotateArray[0].length ; j++) // index represent column 
		{
			for(int i=0 ; i<rotateArray.length ; i++) // index represent lines 
			{
				rotateArray[i][j] = originArray[j][rotateArray.length-1-i]; // 
			}
		}
		return newArr; // return rotated counter ClockWise array. 
	}
	/**
	 * returns a String that represents Matrix of integer numbers, any number between 0-255. 
	 * @overrides toString in class java.lang.Object
	 * @return String that represents this Matrix in the following format:
	 * <pre>
	 *  <br>10	13	15
	 *  <br>17	25	255
	 *  <br>124	83	78
	 *  <br>
	 */
	public String toString()
	{
		String str = "";
		for(int i=0 ; i<_array.length ; i++) // index represent lines
		{
			str+= _array[i][0];
			for(int j=1 ; j<_array[i].length ; j++) // index represent column
			{
				str += "\t" + _array[i][j];
			}
			if(i<_array.length) // 
			{
				str += "\n"; // at the last array line --> jump line
			}
		}
		return str;
	}
}
