package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_15989 {
    static  boolean[][][] visited;
    static  int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];
        dp[0][0] =1;

        for(int j=1; j<4; j++) {
            for(int i=0; i<=10000; i++) {
                if(i >=j) {
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                } else
                    dp[i][j] = dp[i][j-1];


            }
        }
        for(int i=0; i<n; i++) {
            int a= Integer.parseInt(br.readLine());
            System.out.println(dp[a][3]);
        }


        }
    }



