package labs;

import java.util.Arrays;
import java.util.Random;

public class Lab {
  public void run() {
    int matrixLength = new Random().nextInt(1, 6);
    
    long[][] A = this.generateMatrix(matrixLength);
    long[][] B = this.generateMatrix(matrixLength);
    
    System.out.println("matrix A:");
    this.printMatrix(A);
    
    System.out.println("matrix B:");
    this.printMatrix(B);
    
    long[][] C = this.XORMatrix(A, B);
    System.out.println("A XOR B");
    this.printMatrix(C);
    
    long maxRowSum = 0;
    long maxColSum = 0;
    
    for (int i = 0; i < matrixLength; i++) {
      long maxRow = 0;
      long maxCol = 0;
      
      for (int j = 0; j < matrixLength; j++) {
        maxRow = Math.max(maxRow, C[j][i]);
        maxCol = Math.max(maxCol, C[i][j]);
      }
      
      maxRowSum += maxRow;
      maxColSum += maxCol;
    }
    
    System.out.println(String.format("Max rows sum: %s", maxRowSum));
    System.out.println(String.format("Max cols sum: %s", maxColSum));
  }
  
  private long[][] XORMatrix(long[][] A, long[][] B) {
    long[][] C = new long[A.length][A[0].length];
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        C[i][j] = A[i][j]^B[i][j];
      }
    }
    
    return C;
  }
  
  private long[][] generateMatrix(int length) {
    long[][] matrix = new long[length][length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = Math.abs(new Random().nextLong()) % 100;
      }
    }
    return matrix;
  }
  
  private void printMatrix(long[][] matrix) {
    Arrays.stream(matrix)
      .map(row -> Arrays.toString(row))
      .forEach(System.out::println);
  }
}
