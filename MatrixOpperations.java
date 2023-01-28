import java.util.*;

public class MatrixOpperations {
	private Vector<Vector<Integer>> matrix;
	
	public MatrixOpperations(Vector<Vector<Integer>> matrix) {
		this.matrix = matrix;
	}
	
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
	
	public int computeDeterminant() throws InvalidDimensionsException {
		return computeDeterminant(matrix,matrix.size()-1);
	}
	
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
