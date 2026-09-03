import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        
        int  m  =enemy.length;
        int dist = 0;
        int count = 0;
      
     
        for(int i=1; i<= m; i++) {
            
            dist += enemy[i-1];
            queue.add(enemy[i-1]);
            
              if(dist > n && k > 0) {
               int num = queue.poll();
                dist -=num;
                
                k--;
                count = i ;
                
            } else if( dist > n && k==0) {
                count = i-1;
                break;
            } else if ( dist ==n && k ==0) {
                  count  = i;
                  break;
              }
            
            
        }
        if( count ==0 ) {
            count=  m;
        }
        answer  = count;
        return answer;
    }
}