/*
 * Matrix Addition using pointers only
 * Using malloc
 * Author  Krishna Pai
 * Date    1-Oct-2021
 */

#include <stdio.h>
#include <stdlib.h>
void input(int *a, int *b, int row, int col);
void add(int *a, int *b, int *ans, int r, int c);
void main()
{
    int row, col;
    printf("Enter row(s): ");
    scanf("%d", &row);
    printf("Enter column(s): ");
    scanf("%d", &col);
    int *A, *B, *answer;
    A = (int *)malloc(row * col * sizeof(int));
    B = (int *)malloc(row * col * sizeof(int));
    answer = (int *)malloc(row * col * sizeof(int));
    input(A, B, row, col);
    add(A, B, answer, row, col);
}
void input(int *a, int *b, int row, int col)
{
    int i, j;
    printf("Enter matrix A: \n");
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
        {
            scanf("%d", ((a + i * col) + j));
        }
    }
    printf("\nEnter matrix B:\n");
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
        {
            scanf("%d", ((b + i * col) + j));
        }
    }
}
void add(int *a, int *b, int *ans, int r, int c)
{
    printf("\nAddition Matrix:\n");
    int i, j;
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            *((ans + i * c) + j) = *((a + i * c) + j) + *((b + i * c) + j);
            printf("%d\t", *((ans + i * c) + j));
        }
        printf("\n");
    }
}