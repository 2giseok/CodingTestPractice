import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int n  = sticker.length;
        
        if( n <=2) {
            for(int i=0; i<n; i++) {
                answer = Math.max(answer,sticker[i]);
                return answer;
            }
        }
       int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0],sticker[1]);
        
        dp2[1] = sticker[1];
        
        for(int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1] ,dp2[i-2]+sticker[i]);
        }
        for(int i=2; i<n-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        answer= Math.max(dp[n-2], dp2[n-1]);
        return answer;
    }
}