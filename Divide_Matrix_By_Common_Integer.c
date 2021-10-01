#include <stdio.h>

int main() {

  int n, m;
  printf("Please enter the number of rows of the matrix:\n");
  scanf("%d", &n);
  printf("Please enter the number of columns of the matrix:\n");
  scanf("%d", &m);

  // Matrix
  int matrix[n][m];

  printf("Enter the elements of the matrix:\n");
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      scanf("%d", &matrix[i][j]);
  }

  int num;
  printf("Please enter the number:\n");
  scanf("%d", &num);

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      matrix[i][j] /= num;
  }

  printf("Resulting matrix is: \n");

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      printf("%d ", matrix[i][j]);
    printf("\n");
  }
}
