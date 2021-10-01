#include <stdio.h>
#define R 4
#define C 5
void spiralOfMatrix(int enrow, int encol, int arr1[R][C])
{
    int i, rowind = 0, colind = 0;
    while (rowind < enrow && colind < encol)
    {
        for (i = colind; i < encol; ++i)
        {
            printf("%d ", arr1[rowind][i]);
        }
        rowind++;
        for (i = rowind; i < enrow; ++i)
        {
            printf("%d ", arr1[i][encol-1]);
        }
        encol--;
        if ( rowind < enrow)
        {
            for (i = encol-1; i >= colind; --i)
            {
                printf("%d ", arr1[enrow-1][i]);
            }
            enrow--;
        }
        if (colind < encol)
        {
            for (i = enrow-1; i >= rowind; --i)
            {
                printf("%d ", arr1[i][colind]);
            }
            colind++;    
        }        
    }
}
int main()
{
int i,j;
    int arr1[R][C] = { {1,  2,  3,  4,  5},
        {6, 7,  8,  9,  10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}
    };
 //------------- print original array ------------------	
	printf("The given array in matrix form is :  \n");
	for(i = 0; i < R; i++)
	{
	for (j=0;j<C;j++)
	{
	printf("%d  ", arr1[i][j]);
    } 
	printf("\n");
	}
//------------------------------------------------------ 	
printf("The spiral form of above matrix is: \n");	
    spiralOfMatrix(R, C, arr1);
    return 0;
}
