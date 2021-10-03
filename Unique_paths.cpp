class Solution {
public:
    
    int dfs(vector<vector<int>>& obstacleGrid,int i,int j,vector<vector<int>>& memo){
        if(memo[i][j]!=-1)
            return memo[i][j];
        
        if(i>=obstacleGrid.size() || j>=obstacleGrid[0].size() || i<0 || j<0 ||obstacleGrid[i][j]==1)
            return memo[i][j]=0;
        
         if(i==obstacleGrid.size()-1 && j==obstacleGrid[0].size()-1 )
            return memo[i][j]=1;
        
        int right=dfs(obstacleGrid,i+1,j,memo);
        int left=dfs(obstacleGrid,i,j+1,memo);
        return memo[i][j]=right+left;
        
        
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
       
        int path=0;
       vector<vector<int>>memo(obstacleGrid.size()+1,vector<int>(obstacleGrid[0].size()+1,-1));
        path= dfs(obstacleGrid,0,0,memo);
            
        return path;
    }
};