class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // add all the edge on top left right botom to queue
       for (int i=0; i<row; i++) {
           if (board[i][0] == 'O') {
               board[i][0] = '+';
               queue.offer(new int []{i, 0});
           }
           if (board[i][col - 1] == 'O') {
               board[i][col - 1] = '+';
               queue.offer(new int []{i, col - 1});
           }
       }
        for (int i=0; i<col; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '+';
                queue.offer(new int [] {0, i});
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = '+';
                queue.offer(new int [] {row - 1, i});
            }
        }
        bfs(queue, row, col, board);
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void bfs(Queue<int[]> queue, int row, int col, char [][] board) {
        final int [][] directions = new int [][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int [] currentPos = queue.poll();
            int x = currentPos[0];
            int y = currentPos[1];
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || board[newX][newY] != 'O')
                    continue;
                board[newX][newY] = '+';
                queue.offer(new int [] {newX, newY});
            }
        }
    }
}
