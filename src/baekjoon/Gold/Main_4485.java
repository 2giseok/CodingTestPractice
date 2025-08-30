package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4485 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int d= 1;
        while (true) {

            int n  =Integer.parseInt(br.readLine());
            if ( n==0) {
                break;
            }
            int[][] board = new int[n][n];
            StringTokenizer st;
            for(int i=0; i<n; i++) {
                st= new StringTokenizer(br.readLine());
                for(int j=0; j< n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

          int result =   bfs (board,n);

            System.out.println("Problem" + " " +d +":" + " " + result);

            d++;



        }


    }

    private static int bfs(int[][] board,int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a->a[2]));
        int c=  board.length;
        int[][] copy = new int[n][n];
   for(int i=0; i<c; i++) {
       Arrays.fill(copy[i], Integer.MAX_VALUE);
   }
   copy[0][0] = board[0][0];


        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        queue.add(new int[] {0,0,board[0][0]});


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy =  current[0];
            int cx = current[1];
            int dist = current[2];




            for(int i=0; i< 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];



                if ( ny >=0 && ny < n && nx >=0 && nx < n ) {
                    if ( copy[ny][nx] > dist+ board[ny][nx]) {
                        copy[ny][nx] = dist+board[ny][nx];
                        queue.add(new int[] {ny,nx, dist + board[ny][nx]});
                    }


                }


            }



        }

        return copy[n-1][n-1];



    }
}
