import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
      
        int count = brown + yellow;
        int[][] block = new int[count][1];
        int x= 0 ;
        int y  =0;
        
        for(int i=1; i<count/2; i++) {
             x= count/i;
            y = i;
            block = new int[x][y];
            
            int dist = checking(block);
            if( dist == yellow) {
                break;
            }
        }
        int[] answer=  {x,y};
        return answer;
    }
    public int checking( int[][] block) {
        int n  = block.length;
        int m = block[0].length;
        int dist =0;
        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if( i==0 || j==0 || i== n-1 || j == m-1) {
                    continue;
                } else {
                    dist ++;
                }
            }
        }
        return dist;
    }
}