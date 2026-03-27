import java.util.*;
class Solution {
    int[] dy = {1,0,-1,0};
     int[] dx = {0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        boolean[][] visited = new boolean[102][102];
        
        
        for(int i=0; i< rectangle.length; i++) {
            
            checking(visited , rectangle[i]);
            
        }
        for(int i=0; i< rectangle.length; i++) {
            
            unchecking(visited , rectangle[i]);
            
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {characterY*2,characterX*2,0});
        
        while(!queue.isEmpty()) {
            
            int[] current= queue.poll();
            
            int ny = current[0];
            int nx = current[1];
            int dist =current[2];
            
            if(ny ==itemY*2 && nx == itemX*2) {
                
                return dist/2;
                
            }
            
            
            for(int i=0; i<4; i++) {
                
                int x =  nx +dx[i];
                int y = ny + dy[i];
                
                if(visited[y][x]) {
                    
                    queue.add(new int[] {y,x, dist+1});
                    visited[y][x] = false;
                    
                }
            }
            
        }
        
        
        return -1;
    }
    
    public void checking(boolean[][] visited,  int[] arr) {
        
        int startX =arr[0]*2;
        int endX = arr[2]*2;
        int startY = arr[1]*2;
        int endY = arr[3]*2;
        
        for(int i = startX ;i<= endX; i++ ) {
            
            visited[startY][i] = true;
            visited[endY][i] = true;
            
        }
        
        for(int j=startY ; j <= endY; j++) {
            
            visited[j][startX]  = true;
            visited[j][endX] = true;
            
        }
        
      
        
        
    }
    
     public void unchecking(boolean[][] visited,  int[] arr) { 
         
           int startX =arr[0]*2;
        int endX = arr[2]*2;
        int startY = arr[1]*2;
        int endY = arr[3]*2;
         
           for(int i= startX +1 ; i<endX; i++) {
            for(int j= startY+1 ;j<endY; j++) {
                
                if (visited[j][i]) {
                    visited[j][i] = false;
                }
                
            }
            
        }
     
     }
}