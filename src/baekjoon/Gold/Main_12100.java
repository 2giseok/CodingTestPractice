package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());


            }
        }

        System.out.println(dfs(board, 0));

    }

    private static int dfs(int[][] board, int x) {


        if (x == 5) return max(board);
        int best = max(board);
        for (int dir = 0; dir < 4; dir++) {
            int[][] nextboard = move(board, dir);
            if (!same(board, nextboard)) {
                best = Math.max(best, dfs(nextboard, x + 1));

            }
        }
        return best;
    }

    private static boolean same(int[][] board, int[][] nextboard) {

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( board[i][j] != nextboard[i][j]) return  false;

            }
        }


        return true;
    }

    private static int[][] move(int[][] board, int dir) {
        int[][] copyboard = copies(board);
        if (dir == 0) {

            leftmove(copyboard);
            plus(copyboard);
            leftmove(copyboard);

        } else if (dir == 1) {
          copyboard =  spincount(copyboard,dir);
            leftmove(copyboard);
            plus(copyboard);
            leftmove(copyboard);
            copyboard =      revsespincount(copyboard,dir);

        } else if (dir == 2) {
            copyboard =     spincount(copyboard,dir);
            leftmove(copyboard);
            plus(copyboard);
            leftmove(copyboard);
            copyboard =     revsespincount(copyboard,dir);
        } else {
            copyboard =     spincount(copyboard,dir);
            leftmove(copyboard);
            plus(copyboard);
            leftmove(copyboard);
            copyboard =     revsespincount(copyboard,dir);

        }
        return copyboard;
    }

    private static int[][] revsespincount(int[][] copyboard, int dir) {
        int k = dir;
        if ( k ==0) return  copyboard;
        return  revsespincount(revsespin(copyboard) , k-1);

    }

    private static int[][] spincount(int[][] copyboard, int dir) {
        int k = dir ;
        if ( k==0) return copyboard;
        return  spincount(spin(copyboard), dir -1);

    }

    private static void plus(int[][] board) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                if (board[i][j] !=0  && board[i][j] == board[i][j+1] ) {
                    board[i][j]*=2;
                    board[i][j+1] = 0;
                    j++;


                }


            }
        }

    }

    private static int[][] revsespin(int[][] board) {


        int[][] r=  new int[n][n];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    r[j][n - 1 - i] = board[i][j];

                }

            }

       return r;
    }


    private static int[][] spin(int[][] copyboard) {
        int[][] r= new int[n][n];


            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    r[n - 1 - j][i] = copyboard[i][j];

                }

        }
return r;
    }

    private static void leftmove(int[][] board) {

       for(int i=0; i<n; i++) {
           int w =0;
           for(int j=0; j<n; j++) {
               if( board[i][j] !=0) {
                   if ( w!=j ) {
                       board[i][w] = board[i][j];
                       board[i][j] = 0;
                   }
                   w ++;
               }

           }
       }




    }

    private static int[][] copies(int[][] board) {
        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = board[i][j];

            }
        }
        return b;
    }


    private static int max(int[][] board) {
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num = Math.max(num, board[i][j]);

            }

        }
        return num;

    }

}