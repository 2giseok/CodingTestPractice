package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17822_2 {
    static  int n,m,t,x,d,k;
    static  int[][] board;

    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        t  = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st=  new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());



            }


        }
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            x=  Integer.parseInt(st.nextToken());
            d =  Integer.parseInt(st.nextToken());
            k =  Integer.parseInt(st.nextToken());

            if( d == 0 ) {
                spin(x,k);
            }

            else if (d ==1) {
                reversespin(x,k);

            }



            boolean erase = check();

            if (!erase) {
                adjust();
            }

        }
        int result =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result +=board[i][j];
            }

        }
        System.out.println(result);

    }

    private static void adjust() {
        int sum =0;
        int count =0;

        for(int i=0; i<n; i++) {
            for( int j=0;j <m; j++) {
                if (board[i][j] == 0) continue;

                if(board[i][j]!=0) {
                    count ++;
                    sum += board[i][j];


                }
            }
        }

        if ( count == 0) return ;
        double avg =(double)  sum/count;
        for(int i=0; i<n; i++) {


            for (int j = 0; j < m; j++) {
                if(board[i][j] ==0) continue;


                if (board[i][j] > avg) {
                    board[i][j] -= 1;
                } else if (board[i][j] < avg) {
                    board[i][j] += 1;
                }

            }
        }





    }

    private static boolean check() {
        boolean foundSame = false;
        boolean[][] visited = new boolean[n][m];

        // 좌우 인접 비교 (같은 원판에서만)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nj = (j + 1) % m; // 원형이므로
                if (board[i][j] != 0 && board[i][j] == board[i][nj]) {
                    visited[i][j] = true;
                    visited[i][nj] = true;
                    foundSame = true;
                }
            }
        }

        // 상하 인접 비교 (다른 원판 간)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i + 1][j]) {
                    visited[i][j] = true;
                    visited[i + 1][j] = true;
                    foundSame = true;
                }
            }
        }

        // 같은 수 삭제
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    board[i][j] = 0;
                }
            }
        }

        return foundSame;
    }


    private static void reversespin(int x, int k) {

        for(int i=x-1; i<n; i+=x) {

            int[] temp = new int[m];
            for(int j=0; j<m; j++) {
                temp[(j-k + m)%m] = board[i][j];


            }
            board[i] = temp;

        }

    }

    private static void spin(int x, int k) {
        for(int i=x-1; i<n; i+=x) {

            int[] temp = new int[m];
            for(int j=0; j<m; j++) {
                temp[(j+k)%m] = board[i][j];


            }
            board[i] = temp;

        }

    }
}
