package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12869 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int  n = Integer.parseInt(br.readLine());
      int[] scv =  new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());

        }
        int count =0;
        int temp =0;
        if (n ==1) {
            while ( scv[0] >0 ) {
          scv[0] -= 9;
          count ++;

        }   }
        if ( n==2) {

            while ( scv[0] >0 || scv[1] >0) {
                if( scv[1] > scv[0]) {
                    temp = scv[0];
                    scv[0]=  scv[1];
                    scv[1] = temp ;

                }
                scv[0] -= 9;
                scv[1] -= 3;
                count ++;
            }


        } if(n==3) {
             count =  (bfs(scv[0],scv[1],scv[2],0));


        }
        System.out.println(count);
    }

    private static int bfs(int x, int y, int z, int num) {
        Queue<int[]>queue = new LinkedList<>();
        int[][] attck  = {
                {9, 3, 1},
                {9, 1, 3},
                {1, 9, 3},
                {1, 3, 9},
                {3, 1, 9},
                {3, 9, 1}
        };
        boolean[][][] visited=new boolean[61][61][61];
        queue.add(new int[] {x,y,z,0});
        visited[x][y][z] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int dx = current[0];
            int dy = current[1];
            int dz = current[2];

            if(dx <=0 && dy <=0 && dz <=0) return current[3];

            for(int[] d : attck) {
                int nx = Math.max(0, dx- d[0]);
                int ny = Math.max(0, dy-d[1]);
                int nz = Math.max(0, dz-d[2]);

                if(!visited[nx][ny][nz]) {
                    visited[nx][ny][nz] = true;
                    queue.add(new int[] {nx,ny,nz,current[3]+1});
                }
            }
        }
        return  -1;
    }
}
