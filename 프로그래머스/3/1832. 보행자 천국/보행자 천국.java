import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        right[0][0] =1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(cityMap[i][j] ==1) {
                    continue;
                }
                
                int rightNode = right[i][j];
                int downNode = down[i][j];
                int total = (rightNode + downNode) % MOD;
                
                boolean visited = cityMap[i][j] ==2;
                
                if( j+1 <n ) {
                    right[i][j+1] = visited ? rightNode : total;
                }
                if(i +1 < m) {
                    down[i+1][j] = visited ? downNode : total;
                }
            }
        }
        
        return (right[m-1][n-1] + down[m-1][n-1] ) % MOD;
    }
}