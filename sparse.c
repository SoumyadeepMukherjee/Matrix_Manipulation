/* C Program to check Matrix is a Sparse Matrix or Not */
 
#include<stdio.h>
 
int main()
{
 	int i, j, rows, columns, a[10][10], Total = 0;
  
 	printf("\n Please Enter Number of rows and columns  :  ");
 	scanf("%d %d", &i, &j);
 
 	printf("\n Please Enter the Matrix Elements \n");
 	for(rows = 0; rows < i; rows++)
  	{
   		for(columns = 0;columns < j;columns++)
    	{
      		scanf("%d", &a[rows][columns]);
    	}
  	}
     
 	for(rows = 0; rows < i; rows++)
  	{
   		for(columns = 0; columns < j; columns++)
    	{
    		if(a[rows][columns] == 0)
    		{
    			Total++;    		
			}
   	 	}
  	}
  	if(Total > (rows * columns)/2)
  	{
  		printf("\n The Matrix that you entered is a Sparse Matrix ");
	}
	else
	{
		printf("\n The Matrix that you entered is Not a Sparse Matrix ");
	}
  	
 	return 0;
}
