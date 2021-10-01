#include <stdio.h>
int main()
{
    int r, i, j;
    printf("Enter number of rows:");
    scanf("%d", &r);
    int a[r][r];
    printf("Enter %d matrix elements:\n", r * r);
    for (i = 0; i < r; i++)
    {
        for (j = 0; j < r; j++)
            scanf("%d", &a[i][j]);
    }
    printf("Matrix Elements:\n");
    for (i = 0; i < r; i++)
    {
        printf("\n");
        for (j = 0; j < r; j++)
        {
            printf("%d\t", a[i][j]);
        }
    }
    printf("\nMirror Image of Matrix:\n");
    for (i = 0; i < r; i++)
    {
        printf("\n");
        for (j = r - 1; j >= 0; j--)
        {
            printf("%d\t", a[i][j]);
        }
    }
    return 0;
}
