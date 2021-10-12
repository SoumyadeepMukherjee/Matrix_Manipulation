
import java.util.*;
/*
* Question:  Sort and Print 2D matrix
* row: 5
* col: 5
* elements: 1 2 3 4 0 1 8 7 1 2 0 2 2 2 4 5 9 3 1 7 5 3 4 6 9
*
* Input:    1 2 3 4 0
            1 8 7 1 2
            0 2 2 2 4
            5 9 3 1 7
            5 3 4 6 9


* Output:   0 0 1 1 2
            9 8 7 1 2
            7 2 2 2 3
            6 9 3 1 3
            5 5 4 4 4
 */
public class SortPrintMatrixBoundaryElements {
    public static void main(String[] args)
    {
        int rows=0,cols=0,i=0,j=0,k=0,temp=0,count=0;
        int arr[][],b[];

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ROW OF MATRIX");
        rows=sc.nextInt();
        System.out.println("ENTER THE NUMBER OF COLUMN OF MATRIX");
        cols=sc.nextInt();

        arr=new int[rows][cols];
        System.out.println("ENTER THE ELEMENTS IN MATRIX");
        for(i=0;i< rows;i++)
        {
            for(j=0;j< cols;j++)
            {
                arr[i][j]=sc.nextInt();
                /*counting the number of boundary elements*/

                if(i==0||i==(rows-1)||j==0||j==(cols-1))
                {
                    count++;
                }
            }
        }
        b=new int[count];
        System.out.println("ORIGINAL MATRIX");
        printMatrix(rows, cols, arr);

        sortPrint2DMatrix(arr, rows, cols);
    }

    private static void sortPrint2DMatrix(int[][] arr, int rows, int cols) {
        List<Integer> boundaryList=new ArrayList<>();
        /*
        logic:
          Add all the boundary elements in the ArrayList, sort the list
          and them print every row according to the ArrayList
         */

        /*
        step 1: add the boundary elements in the list : boundaryList
         */
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (j == cols - 1 || (i == rows - 1) || j == 0 || i == 0)
                    boundaryList.add(arr[i][j]);
            }
        }

        /*
        step 2: sort that boundaryList
         */
        Collections.sort(boundaryList);


        /*
        step 3: print the matrix according to the boundaryList
         */
        System.out.println("SORTED MATRIX");
        // first N elements from boundaryList
        for (int i = 0; i < cols; i++)
            System.out.print(boundaryList.get(i)+" ");
        System.out.println();

        for (int i = 0; i < rows - 2; i++)
        {
            // Print elements from last
            System.out.print(boundaryList.get(boundaryList.size() - i - 1)+" ");

            // Print middle elements
            // from original matrix
            for (int j = 1; j < cols - 1; j++)
                System.out.print(arr[i + 1][j]+" ");

            // Print elements from front
            System.out.print(boundaryList.get(cols + i)+" ");
            System.out.println();
        }


        /*
        for the last row in the matrix, we need elements from
        [cols + rows - 2] to [cols + rows - 2 + cols] indices
        For example, in our case:
            boundaryList:        [1, 2, 3, 4, 0, 2, 4, 7, 9, 6, 4, 3, 5, 5, 0, 1]
            sorted boundaryList: [0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 9]

            for the last row, we need from (4, 4, 4, 5, 5) in the last row.

            reverse this sublist(to print the sorted boundary elements) and print
         */
        List<Integer> subList=boundaryList.subList(cols+rows-2,cols+rows-2+cols);
        Collections.reverse(subList);
        // Printing last row

        for (int i = 0; i < subList.size(); i++)
            System.out.print(subList.get(i)+" " );
    }


    private static void printMatrix(int rows, int cols, int[][] arr) {
        int i,j;
        for(i=0;i< rows;i++)
        {
            for(j=0;j< cols;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
