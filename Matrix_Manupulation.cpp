class Solution {
private: 
    vector<int> arr = {0,1,0};
public:
    
    int minPathSum(vector<vector<int>>& grid) {
        vector<vector<int>> dp( grid.size() , vector<int> (grid[0].size(), -1));
        dp[0][0] = dfs(grid,0,0,dp);
        return dp[0][0];
    }
    
    int dfs(vector<vector<int>>& grid, int i,int j,vector<vector<int>>& dp )
    {
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int x,y,result = 10000;
        for(int d=0;d<=1;d++)
        {
            x = i + arr[d];
            y = j + arr[d+1];
            if(x >= 0 && y >= 0 && x < grid.size() && y < grid[x].size())
            {
                result = min(result,dfs(grid,x,y,dp));
            }
        }
        if(result == 10000)
        {
            dp[i][j] = grid[i][j];
            return dp[i][j];
        }
        else
        {
           dp[i][j] = grid[i][j] + result;
           return dp[i][j]; 
        }
        
    }
};