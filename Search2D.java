class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        // If the first item in the first row is too large then the
        // target couldn't possibly be in the grid.
        if(matrix[0][0] > target) return false;
        
        // Find the right row by checking the start and end to see
        // if the target should be in there.
        for(int i = 0; i < matrix.length; i++) {
            int lastIndex = matrix[i].length - 1;
            if(matrix[i][0] <= target && matrix[i][lastIndex] >= target) {
                // This is the right row
                for(int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == target) return true;
                    if(matrix[i][j] > target) return false;
                }
            }
        }
        // There wasn't a row that should have held the target
        return false;
    }
}

void main(String[] args) {
    int[][] matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]];
    int target = 3;

    // Check the matrix for the target number
    System.out.println(new Search2D().searchMatrix(matrix, target));
}