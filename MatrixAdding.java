public class MatrixAdding {
  public static void main(String[] args) {
    int row = 3, col = 3, i, j;

    int matrix_a[][] = { { 1, 2, 3 }, { 3, 4, 6 }, { 7, 8, 9 } };
    int matrix_b[][] = { { -1, 9, 8 }, { 8, 4, 12 }, { 7, 9, 15 } };
    int result[][] = new int[row][col];

    for (i = 0; i < row; i++)
      for (j = 0; j < col; j++)
        result[i][j] = matrix_a[i][j] + matrix_b[i][j];

    System.out.println("Sum of matrix_a and matrix_b is : -");

    for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++)
        System.out.print(result[i][j] + " ");

      System.out.println();
    }
  }
}