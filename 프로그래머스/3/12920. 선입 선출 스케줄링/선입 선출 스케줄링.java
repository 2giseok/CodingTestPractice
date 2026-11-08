import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        
        int count = 0;
        
        if(cores.length > n ) {
            return n;
        }
        
        int coresMin =  cores[0];
        
        for(int i=0; i<cores.length; i++) {
            coresMin = Math.min(cores[i],coresMin);
        }
        
        int left = 0;
        long right = (long) coresMin* n;
        
        while( left < right) {
            long  mid = (long) (left + right)/2;
             count=  cores.length;
            
            for(int i=0; i< cores.length; i++ ) {
                count += mid/cores[i];
            }
            if( count>=n) {
                right  = mid;
            } else {
                left = (int) mid +1;
                
            }
        }
        long time = left;
         count =  cores.length;
        for(int j=0; j<cores.length; j++) {
            count += (time-1)/cores[j];
        }
        
        for(int i=0; i< cores.length; i++) {
            if( time % cores[i] ==0) {
                count ++;
            }
            
            if( count ==n) {
                return i+1;
            }
        }
        
        int answer = 0;
        return answer;
    }
}