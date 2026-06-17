import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y=  5;
        boolean[][][][] visited=  new boolean[11][11][11][11];
        
        for(char c : dirs.toCharArray()) {
            
            int n = x;
            int m =y;
            
            switch(c) {
                case'U':
                 
                    if( y+1 <=10) {
                        y+=1;
                    }
                    break;
                case 'D':
                      if( y-1 >=0) {
                        y-=1;
                    }
                    break;
                case 'R':
            
                      if( x+1 <=10) {
                        x+=1;
                      }
                    break;
                case 'L':
                     if( x-1 >=0) {
                        x-=1;
                    }
                    break;     
            }
           if(visited[m][n][y][x] || visited[y][x][m][n] || n ==x &&m ==y) {
               continue;
           }
         answer++;
            visited[m][n][y][x] = true;
            
        }
        return answer;
    }
}