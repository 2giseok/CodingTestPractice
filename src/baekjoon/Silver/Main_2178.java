package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] =  line.charAt(j)-'0';


            }

        }
        int result =    bfs();
        System.out.println(result);


    }

    public static  int bfs() {
        int[] x = {1,0,-1,0};
        int[] y = {0,-1,0,1};
        Queue<int[]>queue = new LinkedList<>();

        queue.add(new int[] {0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] current  = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int dist = current[2];
            for(int i=0; i<4; i++) {
                int dx=  nx +x[i];
                int dy = ny + y[i];

                if(dx >= n || dx <0 || dy >=m || dy <0 || board[dx][dy] ==0) continue;

                if ( dx == n -1 && dy == m -1) {
                    return dist+1;
                }

                if ( board[dx][dy] ==1 && !visited[dx][dy]) {

                        queue.add(new int[] {dx,dy,dist +1});
                        visited[dx][dy] = true;

                }

            }

        }
        return -1;




    }


}