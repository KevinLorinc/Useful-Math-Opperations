import java.util.*;

/**
 * creates matrices and performs operations on them
 * @author Kevin Lorinc
 *
 */
public class MatrixOperations {
	private Vector<Vector<Integer>> matrix;
	
	/**
	 * assigns the matrix instance variable
	 * @param matrix the matrix to be assigned
	 */
	public MatrixOperations(Vector<Vector<Integer>> matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * creates a matrix given a 2d int array
	 * @param arrayMatrix the 2d int array to create the matrix out of
	 * @return the matrix of time Vector<Vector<Integer>>
	 * @throws InvalidDimensionsException
	 */
	public static Vector<Vector<Integer>> createMatrix(int[][] arrayMatrix) throws InvalidDimensionsException{
		Vector<Integer> row = new Vector<Integer>();
		Vector<Vector<Integer>> rows = new Vector<Vector<Integer>>();
		
		for(int i = 0;i<arrayMatrix.length;i++) {
			if(arrayMatrix.length != arrayMatrix[i].length) 
				throw new InvalidDimensionsException("Not a Square Matrix");
		}
		
		for(int r=0;r<arrayMatrix.length;r++) {
			for(int c=0;c<arrayMatrix[0].length;c++) {
				row.add(arrayMatrix[r][c]);
			}
			rows.add(row);
			row = new Vector<Integer>();
		}
		
		return rows;
	}
		
	/**
	 * calls the private compute determinant method
	 * @return the determinant of the matrix
	 * @throws InvalidDimensionsException
	 */
	public int computeDeterminant() throws InvalidDimensionsException {
		return computeDeterminant(matrix,matrix.size()-1);
	}
	
	/**
	 * computes the determinant of any nXn square matrix
	 * @param matrix the matrix to compute the determinant of
	 * @param row the current row of which minor matrices are being computed
	 * @return the determinant
	 * @throws InvalidDimensionsException
	 */
	private int computeDeterminant(Vector<Vector<Integer>> matrix,int row) throws InvalidDimensionsException {
		if(matrix == null) return 0;
		for(int i = 0;i<matrix.size();i++) {
			if(matrix.size() != matrix.get(i).size()) 
				throw new InvalidDimensionsException("Not a Square Matrix");
		}
		if(matrix.size() == 1) {
			return matrix.get(0).get(0);
		}
		else {
			Vector<Vector<Integer>> minor = computeMinor(matrix,row);
			if(row != 0)
				return  (int)Math.pow(-1, row) * matrix.get(row).get(0) * computeDeterminant(
						minor,minor.size()-1) + computeDeterminant(matrix,row-1);
			else {
				return  matrix.get(row).get(0) * 
						computeDeterminant(minor,minor.size()-1);
			}
		}					
	}
	
	/**
	 * computes the minor of any nXn matrix by removing the nth row and the first column
	 * @param matrix the matrix to compute the minor of
	 * @param row what row will be removed
	 * @return the minor of the matrix
	 */
	private Vector<Vector<Integer>> computeMinor(Vector<Vector<Integer>> matrix,int row){
		Vector<Vector<Integer>> minor = new Vector<Vector<Integer>>();
		int actualRow = -1;
		for(int r = 0;r<matrix.size();r++) {
			if(r != row) {
				minor.add(new Vector<Integer>());
				actualRow++;
			}
			for(int c = 1;c<matrix.size();c++)
				if(r != row) minor.get(actualRow).add(matrix.get(r).get(c));
		}
		return minor;
	}
}
