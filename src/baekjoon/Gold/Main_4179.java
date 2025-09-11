package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    static  int m;
    static  int n;
    static Queue<int[]>queue = new LinkedList<>();
    static  Queue<int[]> firequeue = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
        m  =Integer.parseInt(st.nextToken());



        char[][] arr = new char[n][m];
        int[][] move = new int[n][m];
        int[][] fire = new int[n][m];

        for(int i=0; i<n; i++) {


            for(int j=0; j< m; j++) {
                fire[i][j] = -1;
                move[i][j] = -1;

            }
        }




        for(int i=0; i< n; i++) {
            String a=  br.readLine();

            for(int j=0; j< m;  j++) {
                arr[i][j]  = a.charAt(j);

                if (arr[i][j] == 'J') {
                  queue.add(new int[] {i,j,0});
                  move[i][j] = 0;


                }
                if ( arr[i][j] =='F') {


                    firequeue.add(new int[] {i,j});
                    fire[i][j] =0;


                }
            }


        }



        int result = bfs(arr,fire,move);

        if(result ==0) {
            System.out.println("IMPOSSIBLE");

        } else {
            System.out.println(result);
        }



    }

    private static int bfs(char[][] arr,int[][] fire,int[][]move) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while (!firequeue.isEmpty()) {

            int[] cur  = firequeue.poll();
            int fireX = cur[0];
            int fireY = cur[1];


            for(int i=0; i<4; i++) {
                int firenx = dx[i] + fireX;
                int fireny = dy[i] + fireY;

                if( firenx < 0 || firenx >=n || fireny <0 || fireny >= m) continue;
            if( arr[firenx][fireny] == '#') continue;
            if(  fire[firenx][fireny] != -1) continue;

            fire[firenx][fireny] = fire[fireX][fireY]+1;

                    firequeue.add(new int[] {firenx,fireny});





            }




        }

        while (!queue.isEmpty()) {
        int[] current = queue.poll();

        int x=  current[0];
        int y = current[1];
        int count =current[2];


        if(x== n-1 || x==0 || y ==0 || y== m-1) {
            return count +1;
        }


        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(arr[nx][ny] =='#') continue;
            if(move[nx][ny] != -1) continue;


            if( nx < 0 || nx> n || ny < 0 || ny >m) continue;
            if(fire[nx][ny] != -1 && count+1 >= fire[nx][ny] ) continue;


            move[nx][ny] = count +1;
                queue.add(new int[] { nx,ny, count+1});






        }



        }


return 0 ;
    }
}
