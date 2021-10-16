import java.util.Scanner;
 
public class ArrayImageCreator {
   public static void main(String[] args) {
	processImageArray();
   }
 
   static void processImageArray() {

	Scanner reader = new Scanner(System.in);
	System.out.println("Enter the number of rows");
	
	int rowCount = reader.nextInt();
	System.out.println("Enter number of columns");
	
	int columnCount = reader.nextInt();

	int[][] array = new int[rowCount][columnCount];
	System.out.println("Starting input of array elements...\n");
	
	for (int i = 0; i < rowCount; i++) {
		for (int j = 0; j < columnCount; j++) {
			System.out.println("Enter element of row " + (i + 1) + 
                                   ", column " + (j + 1));
		
			array[i][j] = reader.nextInt();
		}
	}

	reader.close();
	System.out.println("Entered array is : ");
	
	displayArray(array);
	
	int[][] mirrorImage = new int[rowCount][columnCount];

	for (int row = 0; row < rowCount; row++) { 
           
           int imageColumn = 0; 
           
            for (int column = columnCount - 1; column >= 0; column--) {
		
		int element = array[row][column];
	
		mirrorImage[row][imageColumn] = element;
		
		imageColumn++;
	}
   }
	System.out.println("Mirror image of array is : ");

	displayArray(mirrorImage);
 
   }

   static void displayArray(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	   int[] row = array[i];
	   for (int j = 0; j < row.length; j++) {
		int element = array[i][j];
		System.out.print(element + " ");
	   }
	   System.out.println();
	}
   }
}