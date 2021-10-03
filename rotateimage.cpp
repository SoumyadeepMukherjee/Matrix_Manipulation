class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
         for(int i=0;i<matrix[0].size();i++){          //transpose matrix
            for(int j=i+1;j<matrix.size();j++){
                swap(matrix[i][j],matrix[j][i]);
            }
        }
        for(int i=0;i<matrix[0].size();i++){       //matrix mirror 
            for(int j=0;j<matrix.size()/2;j++){
               swap(matrix[i][j],matrix[i][matrix.size()-j-1]) ;
            }
        }
    }
};