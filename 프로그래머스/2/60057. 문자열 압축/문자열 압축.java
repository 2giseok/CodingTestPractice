import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();

      
        String[] word=  s.split("");
        String dist = "";
        
        for(int i=1; i<=s.length()/2 ; i++) {
            
       StringBuilder sb=  new StringBuilder();
            int count =1;
            dist ="";
        
            
            for(int j=0; j<s.length(); j+=i) {
             
              int idx = Math.min(s.length(), j+i);
                
              String current = s.substring(j, idx);
            
                
                if(dist.equals(current)) {
                    count ++;
                } else {
                    if( count >= 2) {
                        sb.append(count);
                    }
                    sb.append(dist);
               dist = current;
                count =1;
                }
                
                
                
            }
             if( count >= 2) {
                        sb.append(count);
                    }
                    sb.append(dist);
            
            String result = sb.toString();
            answer= Math.min(answer, result.length());
            
            
        }
        return answer;
    }
}