// Must change the class name to "Solution" in LeetCode
class WordSearch {
    private String word;
    private int m;
    private int n;
    private boolean[][] vis;
    private char[][] board;
    
    private final int MOVEX[] = { 1, 0, -1, 0 };
    private final int MOVEY[] = { 0, -1, 0, 1 };
    private final int MOVEN = 4;
    
    /**
    Find word using backtracking and DFS.
    */
    private boolean find( int row, int col )
    {
        return find( row, col, 0 );
    }
    
    private boolean find( int row, int col, int idx )
    {
        if ( idx >= word.length() )
        {
            return true;
        }
        if ( row < 0 || m <= row || col < 0 || n <= col )
        {
            return false;
        }
        if ( !vis[row][col] && board[row][col] == word.charAt(idx) )
        {
            vis[row][col] = true;
            for ( int i = 0; i<MOVEN; i++ )
            {
                int newRow = row + MOVEX[i];
                int newCol = col + MOVEY[i];
                if ( find( newRow, newCol, idx+1 ) )
                {
                    return true;
                }
            }
            vis[row][col] = false;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.vis = new boolean[m][n];
        
        for ( int row=0; row<m; row++ )
        {
            for ( int col=0; col<n; col++ )
            {
                vis[row][col] = false;
            }
        }
        
        for ( int row=0; row<m; row++ )
        {
            for ( int col=0; col<n; col++ )
            {
                if ( find( row, col ) )
                {
                    return true;
                }
            }
        }
        return false;
    }
}
