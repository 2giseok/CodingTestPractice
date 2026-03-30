import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        int n  =arr.length ;
        
        String[] ops =  new String[n/2];
        int[] nums =new int[n/2 +1];
        int b = 0;
        int m = 0;
        
        for(int i=0; i<n; i++) {
            if(arr[i].equals("+") || arr[i].equals("-")) {
                
                ops[b++] = arr[i];
            } else {
                
                nums[m++] = Integer.parseInt(arr[i]);
                
            }
            
        }
        
        int[][] minDP = new int[nums.length][nums.length];
        int[][] maxDP = new int[nums.length][nums.length];
        
        for(int i=0; i<nums.length; i++) {
            
            minDP[i][i] =  nums[i];
             maxDP[i][i] =  nums[i];
            
        }
        
        
        for(int len=1; len<nums.length; len++) {
            for(int i=0;i <nums.length - len ; i++) {
                
                int j = i +len;
                
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    
                    if(ops[k].equals("+")) {
                        
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j] , minDP[i][k] + minDP[k+1][j]);
                        
                    }
                    
                    else if (ops[k].equals("-")) {
                           maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j] , minDP[i][k]- maxDP[k+1][j]);
                        
                    }
                    
                }
                
            }
            
        }
        answer = maxDP[0][nums.length-1];
        return answer;
    }
}