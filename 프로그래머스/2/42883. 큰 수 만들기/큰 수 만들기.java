import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        
        int count =0;
        Stack<Integer>stack = new Stack<>();
        for(int i=0; i<number.length(); i++) {
                  
            char a = number.charAt(i);
            int target = a -'0';
            
         
            
            while(!stack.isEmpty() && count <k && target>stack.peek()) {
                
                  stack.pop();
                count ++;
            }
            
          
            
             stack.push(target);
           
            
        }
        
        while( count < k) 
        {
            stack.pop();
            count ++;
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        StringBuffer sb = new StringBuffer(ans);
        answer = sb.reverse().toString();
        
        return answer;
        
    }
}