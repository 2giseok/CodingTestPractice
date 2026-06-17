import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        int n =  prices.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                answer[i] = j-i;
                
                if(prices[j] < prices[i]) {
                    answer[i] = j -i;
                    break;
                }
            }
            
        }
        
        
        return answer;
    }
}