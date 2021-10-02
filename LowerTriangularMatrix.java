public class LowerTriangular
{
    public static void main(String[] args) {
        int row, col;

        int rawMatrix[][] = {
                {5, 6, 7},
                {8, 7, 4},
                {1, 6, 2}
        };

        row = rawMatrix.length;
        col = rawMatrix[0].length;

        if(row != col){
            System.out.println("This is not a square Matrix , Try Again !!!");
        }
        else {

            System.out.println("Raw Matrix >>> ");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(rawMatrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            System.out.println("Lower Triangular matrix >>> ");
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(j > i)
                        System.out.print("0 ");
                    else
                        System.out.print(rawMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}