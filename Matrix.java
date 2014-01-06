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
			for(int j=0; j<this.numOfColumn;j++){
				System.out.print(this.matrix[i][j] +" ");
			}
			System.out.println();
		}
	}
	/**
	 * Get the specified row from the matrix
	 * @param m the row to get
	 * @return a matrix which is a row in the matrix
	 * @throws Exception
	 */
	public Matrix getRow(int m) throws Exception{
		if(m<1||m>this.numOfRow)
			throw new Exception("No such row exists");
		Matrix row = new Matrix(1, this.numOfColumn, this.matrix[m-1]);
		return row;
	}
	/**
	 * Get the specified column from the Matrix 
	 * @param n the nth column to obtain
	 * @return the nth column
	 * @throws Exception
	 */
	public Matrix getColumn(int n) throws Exception{
		if(n<1|| n>this.numOfColumn)
			throw new Exception("No such column exists");
		double data[] = new double[this.numOfRow];
		for(int i=0; i<this.numOfRow;i++){
			data[i] = this.matrix[i][n-1];
			
		}
		Matrix column = new Matrix(this.numOfRow,1,data);
		return column;
	}
	
	/**A small test of the class*/
	public static void main(String args[]){
		double a[] = {1,2,3,4,5,6};
		Matrix m = new Matrix(3,2,a);
		m.printMatrix();
		try {
			//m.getRow(1).printMatrix();
			m.getColumn(2).printMatrix();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
