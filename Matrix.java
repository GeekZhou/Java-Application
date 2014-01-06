package matrixManiplation;

import java.util.IllegalFormatException;

/**
 * This class contains on Object Matrix double double type
 * The Matrix is m*n two dimensional array
 * @author zhengzhou
 */
public class Matrix {
	/** The number of rows*/
	public int numOfRow;
	/** The number of columns*/
	public int numOfColumn;
	/** The matrix*/
	public double matrix[][];
	
	public Matrix(int m, int n){
		this.numOfRow = m;
		this.numOfColumn = n;
		this.matrix = new double [m][n];
	}
	/**
	 * Construct a matrix from give array
	 * @param m the row of the matrix 
	 * @param n the column of the matrix  
	 * @param ma the data to be filled in the matrix
	 */
	public Matrix(int m, int n, double[] ma){
		if(ma.length!= m*n)
			try {
				throw new Exception("Can not create such matrix");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.numOfRow = m;
		this.numOfColumn = n;
		this.matrix = new double [m][n];
		int index = 0;
		for(int i=1; i<=m;i++){
			for(int j=1; j<=n;j++){
				this.matrix[i-1][j-1] = ma[index];
				index++;
			}
		}
	}
	
	/**
	 * Print the content in the Matrix
	 */
	public void printMatrix(){
		for(int i=0; i<this.numOfRow;i++){
			System.out.println();
			for(int j=0; j<this.numOfColumn;j++){
				System.out.print(this.matrix[i][j] +" ");
			}
		}
	}
	
	/**A small test of the class   */
	public static void main(String args[]){
		double a[] = {1,2,3,4,5,6};
		Matrix m = new Matrix(3,2,a);
		m.printMatrix();	
	}
}
