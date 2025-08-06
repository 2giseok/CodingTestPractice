package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {
    static  int n,m;
    static  char[][] board;
    static Queue<int[]> queue= new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         board=  new char[n][m];

        for(int i=0; i<n; i++) {
            String line= br.readLine();
        for(int j=0; j<m; j++) {
            board[i][j] = line.charAt(j);
            if(board[i][j] == '0') queue.add(new int[] {i,j,0,0});
        }
        }
       int result =  bfs();
        System.out.println(result);
    }

    private static int bfs() {
        boolean[][][] visited= new boolean[n][m][64];
        int[] dx=  { 0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while (!queue.isEmpty()) {
            int[] current= queue.poll();
            int y = current[0];
            int x=  current[1];
            int num = current[2];
            int dist=  current[3];

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx=  x + dx[i];


                if(ny <0 || ny >=n || nx >=m || nx <0  ) continue;


                char c=  board[ny][nx];

                    if ( c == '1') return dist +1;

                if(c == '#') continue;





                if('a' <= c && c<='f') {
                       int newnum =   num | (1<< (c- 'a'));
                       if(!visited[ny][nx][newnum]) {
                           queue.add(new int[]{ny, nx, newnum, dist + 1});
                           visited[ny][nx][newnum] = true;
                       }
                       continue;
                     }

                if('A' <=c && c<='F') {
                    int doorBit = c - 'A';
                    if ((num & (1 << doorBit)) == 0)
                        continue;
                }
                    if (!visited[ny][nx][num] ) {
                        visited[ny][nx][num] = true;
                        queue.add(new int[]{ny, nx, num, dist + 1});
                    }

                }

                }


        return -1;

    }
}
