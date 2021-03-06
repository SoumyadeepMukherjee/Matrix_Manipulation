import java.util.*;

class rank {
     
    static final int r = 3;
    static final int c = 3;
     
    // function for exchanging two rows of a matrix
    static void swap(int a[][], int r1, int r2, int col)
    {
        for (int i = 0; i < col; i++)
        {
            int temp = a[r1][i];
            a[r1][i] = a[r2][i];
            a[r2][i] = temp;
        }
    }
     
    // Function to display a matrix
    static void display(int a[][], int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
             
            for (int j = 0; j < col; j++)
             
                System.out.print(" " + a[i][j]);
                           
            System.out.print("\n");
        }
    }
     
    // function for finding rank of matrix
    static int rankOfMatrix(int a[][])
    {
         
        int rank = c;
     
        for (int row = 0; row < rank; row++)
        {
            // Diagonal element is not zero
            if (a[row][row] != 0)
            {
                for (int col = 0; col < r; col++)
                {
                    if (col != row)
                    {
                        double mul = (double)a[col][row] / a[row][row];
                                     
                        for (int i = 0; i < rank; i++)
                         
                            a[col][i] -= mul * a[row][i];
                    }
                }
            }

            else
            {
                boolean reduce = true;
     
                // Finding the non-zero element in current column
                for (int i = row + 1; i < r; i++)
                {
                    if (a[i][row] != 0)
                    {
                        swap(a, row, i, rank);
                        reduce = false;
                        break ;
                    }
                }
     
                if (reduce)
                {
                    rank--;
     
                    for (int i = 0; i < r; i ++)
                        a[i][row] = a[i][rank];
                }
                row--;
            }
        }
         
        return rank;
    }
     
    public static void main (String[] args)
    {
        int a[][] = {{10, 20, 10},
                       {-20, -30, 10},
                       {30, 50, 0}};
                        
        System.out.print("Rank of the matrix is : " + rankOfMatrix(a));
    }
}
