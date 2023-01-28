import java.util.*;

/**
 * a class to execute matrix operations
 * @author Kevin Lorinc
 *
 */
public class MatrixOperationsMain {

	/**
	 * class to execute methods
	 * @param args
	 * @throws InvalidDimensionsException 
	 */
	public static void main(String[] args) throws InvalidDimensionsException {
		int[][] matrix = {{1,2,11, 0, 3},
				          {3,4,5, 41 , 5},
						  {3,5,4, -2 , 6},
						  {1,2,3,4 , 43},
						  {2,3,4,5,6}};
		
		MatrixOperations aMatrix = new MatrixOperations(MatrixOperations.createMatrix(matrix));
		System.out.println(aMatrix.computeDeterminant());
	}

}
