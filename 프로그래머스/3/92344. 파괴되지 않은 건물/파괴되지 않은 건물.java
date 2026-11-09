import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int startX=0;
        int startY=0;
        int endX=0;
        int endY=0;
        
        int[][] len = new int[board.length+1][board[0].length +1];
        
        for(int i=0; i<skill.length; i++) {
            
            startX = skill[i][1];
            startY=skill[i][2];
            endX=skill[i][3];
            endY=skill[i][4];
            int num =  skill[i][0] == 1? -skill[i][5] : skill[i][5];
            
            len[startX][startY] +=num;
            len[startX][endY+1] -=num;
            len[endX+1][startY] -=num;
            len[endX+1][endY+1] +=num;
            
        }
        for(int i=0; i<board.length; i++) {
            for(int j=1;j<board[0].length; j++) {
                len[i][j] += len[i][j-1];
            }
        }
           for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if( i> 0) {
                    len[i][j] += len[i-1][j];
                }
                if(board[i][j] + len[i][j] > 0 ) {
                    answer ++;
                }
            }
           }
        return answer;
    }
}