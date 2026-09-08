import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
     
        
      int n  = numbers.length;
        int[] answer= new int[n];
        
        for(int i=0; i<n; i++) {
            
           String target = Long.toBinaryString(numbers[i]);
            int dist = 0;
            int  h =0;
            while( target.length()> h) {
                h =(int)  Math.pow(2, dist ++) -1;
            }
            int m  = h  -  target.length();
            StringBuilder sb=  new StringBuilder();
            for(int j=0; j<m ; j++) {
                sb.append("0");
            }
            sb.append(target);
            String result = sb.toString();
            answer[i] =  nodeChecking(result);
            
        }
       return answer;
    }
    public int nodeChecking(String result) {
        
        int m =  result.length();
        
        if( m==1 ) return 1; 
        
        
        int mid =  result.length()/2;
        String left =  result.substring(0,mid);
        String right = result.substring(mid+1,m);
        
        if(result.charAt(mid) =='0') {
            if( left.contains("1") || right.contains("1")) {
                return 0;
            }
        }
      
           if(nodeChecking(left) ==1 && nodeChecking(right) ==1) {
               return 1;
           } else {
               return 0;
           }
        
        
        
        
    }
}