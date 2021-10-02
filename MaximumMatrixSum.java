import java.util.*;
//Question URL-https://leetcode.com/problems/maximum-matrix-sum/
class Solution{
    public long maxMatrixSum(int[][] matrix) {
        int count=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        for (int ele[]:matrix)
        {
            for (int x:ele)
            {
                if (x<0)
                {
                    count++;
                }
                sum+=Math.abs(x);
                min=Math.min(min,Math.abs(x));
            }
        }
        if (count%2!=0)
        {
            sum-=min*2;
        }
        return sum;
    }


}