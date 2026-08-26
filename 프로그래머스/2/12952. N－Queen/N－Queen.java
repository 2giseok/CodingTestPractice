import java.util.*;
class Solution {
    int[] board=  new int[12];
    int count = 0;
    public int solution(int n) {
        
        int answer = 0;
        
         dfs(0,n);
        answer = count;
        
        return answer;
    }
    public void dfs(int x,int n ) {
        
        if(x == n ) {
            count ++;
            return ;
        }
        
        for(int i=0; i<n; i++) {
            board[x] = i;
            if(checking(x)) {
                dfs(x+1, n);
            }
        }
    }
    public boolean checking(int x) {
        
        for(int i=0; i<x; i++) {
            
            if(board[x] == board[i] ||x -i == Math.abs(board[x] - board[i]) ) {
                return false;
            }
            
        }
        return true;
        
    }
    
}