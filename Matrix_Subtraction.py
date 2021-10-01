//Python program to find the subtraction of 2 matrices

matrix1 = [[17, 11, 12],
   [13, 14, 15],
   [16, 10, 18]]
matrix2 = [[1, 2, 3],
   [4, 5, 6],
   [7, 8, 4]]
rmatrix = [[0, 0, 0],
   [0, 0, 0],
   [0, 0, 0]]
for i in range(len(matrix1)):
    for j in range(len(matrix1[0])):
        rmatrix[i][j] = matrix1[i][j] - matrix2[i][j]
for r in rmatrix:
    print(r)
