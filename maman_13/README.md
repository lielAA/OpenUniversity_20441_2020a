# Main Purpose
Stock class is continuation for maman_12 (date and fooditem classes).
Stock represent the stock of all fooditems in the supermarket.

Matrix class represents a Matrix by Two-dimensional array that represent image in black and white colors. 
Any cell in the Matrix represent by integer number between 0-255, while 0 show pure white, and 255 show pure black.

## Stock.java
Stock represent the stock of all fooditems in the supermarket.
It use Date.java and FoodItem.java methods.

### methods
- public Matrix makeNegative() --> Return new Matrix, that represent the negative of the origin image (by colors).
Any number in the matrix will be BLACK minus the cell himself.
For example: 255 became to 0 (255-255) ; and 150 became to 105 (255-150).   
- public Matrix imageFilterAverage() --> Return new Matrix, that represent the image without noise. Any number in origin array will be averaged himself and his closest neighbors. 
- public Matrix rotateClockwise() --> Return new Matrix that rotate the Matrix 90° by Clockwise (to right). 
- public Matrix rotateCounterClockwise() --> Return new Matrix that rotate the Matrix 90° by counter Clockwise (to left).
- public String toString() --> returns a String that represents Matrix of integer numbers, any number between 0-255. 
