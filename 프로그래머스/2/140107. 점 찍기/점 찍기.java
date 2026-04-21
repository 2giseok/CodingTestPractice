import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
      double  n  =0;
       for(int i=0; i<=d; i+=k) {
           long x =(long) d*d;
           long y =(long) i*i;
           n =  Math.sqrt(x-y);
           
           
           
           answer +=(long) (n/k)+1;
           
           
       }
        
        return answer;
    }
}