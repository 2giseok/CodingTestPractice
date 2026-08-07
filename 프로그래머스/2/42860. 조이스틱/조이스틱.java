import java.util.*;
class Solution {
    public int solution(String name) {
        
         int answer = 0;
     
        
        int move = name.length() -1;
        for(int i=0; i<name.length(); i++) {
            
              char a = name.charAt(i);
            int target=Math.abs(Math.min(a-'A','Z' -a+1)); 
            
            answer += (int) target;   
            
            int nextIndex = i +1;
            while(nextIndex <name.length() && name.charAt(nextIndex) =='A') {
                    nextIndex++;
                }
            
            int caseOne = (i*2) + name.length() -nextIndex;
            int caseTwo = (name.length() - nextIndex)*2 + i;
            
            move = Math.min(move, Math.min(caseOne,caseTwo));
        }
        answer +=move;
        
        
        return answer;
    }
}