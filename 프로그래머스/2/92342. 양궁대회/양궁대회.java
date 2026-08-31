import java.util.*;
class Solution {
    int num = -1;
     int[] answer;
    public int[] solution(int n, int[] info) {
       
        int[] result= new int[11];
      dfs(0,0,result,n,info);
       
    
        
         if ( num == -1) {
          answer=  new int[]{-1};
      }
    
        
        return answer;
    }
    public void dfs( int depth, int count ,  int[] result,int n,int[] info) {
        
        if(depth ==11  ) {
            checking(result,info,count,n);
            return;
        }
        
     
            
            result[depth] = info[depth]+1;
            
            if(count +result[depth] <= n ) {
            dfs(depth+1 , count + result[depth] ,result , n, info);
            }
            result[depth] = 0;
             dfs(depth+1 , count ,result , n, info);
        
        
    }
    
    public void checking (int[] result, int[] info,int count, int n) {
        if( count <n ) result[result.length-1] = n -count;
        
        int m =  info.length;
        int x=  0;
        int y=  0;
        int dist = 10;
        for(int i=0; i< m; i++) {
            if(result[i] > info[i]) x+= dist;
            if( result[i] <= info[i] && info[i] != 0) y+=dist;
            
            dist--;
        }
        if(x > y && x> 0 ) {
            int res =  x-y; 
            
            if( res> num) {
                 answer =  result.clone();
                num =  res;
            }
          else   if( num ==res) {
                if(visited(answer , result)) {
            answer =  result.clone();
                }
            }
        }
        if( count <n ) result[result.length-1] = 0;
    }
    public boolean visited(int[] answer ,int[] result) {
        
        for(int i = result.length-1; i>0; i--) {
            if(result[i] < answer[i]) return false;
            if(result[i] > answer[i]) return true;
           
        }
        return true;
    }
}