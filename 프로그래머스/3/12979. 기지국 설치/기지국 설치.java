import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int[][] board = new int[stations.length][2];
        
        for(int i=0; i< stations.length; i++) {
            
         if  (stations[i] - w >0)  {
             board[i][0] = stations[i] -w; 
         }
            else {
                board[i][0] = 0;
            }
        if(stations[i] +w < n ) {
            board[i][1] = stations[i] +w;
        }
            else {
                board[i][1] = n;
                  }
            
        }
        
     int start= 1 ;
        int end = 0;
        int result =0;
       
        for(int i=0; i< board.length; i++) {
            
            end =  board[i][0] -1;
          result +=  checking (start, end , w);
            start = board[i][1] +1;
        }
        result += checking(start,n,w);
        

        answer= result;
        return answer;
    }
    public int checking( int start, int end, int len) {
        
        if( start > end ) return 0;
        int dist = end - start +1;
        
        int result = len *2 +1;
        
        if( dist % result ==0) return dist/result;
        
        return  dist / result +1;
        
        
    }
}