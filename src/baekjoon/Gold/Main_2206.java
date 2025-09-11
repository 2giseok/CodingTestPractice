package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
    static  int n,m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n  =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i< n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }


        }
        int result =      bfs(arr);
        System.out.println(result);
    }

    private static int bfs(int[][] arr) {
        int[] dx =  {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<int[]>queue =new LinkedList<>();
        boolean[][][] visited= new boolean[n][m][2];

        queue.add(new int[] {0,0,0,1});
        visited[0][0][0]= true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int count = current[2];
            int sum = current[3];

            if ( x == n-1 && y== m-1) {
                return sum;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx  <0 || nx>=n || ny <0 || ny >= m ) continue;


              if ( arr[nx][ny] ==0 && !visited[nx][ny][count]) {
                  queue.add(new int[] {nx,ny, count , sum+1});
                  visited[nx][ny][count] = true;

              }  else if (count ==0 && !visited[nx][ny][1]) {
                  queue.add(new int[] { nx,ny,1,sum +1});
                  visited[nx][ny][1] = true;

              }







            }



        }



return -1;

    }
}
