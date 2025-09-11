package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1943 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
        for(int k =0; k < 3; k++) {
            StringTokenizer st;
            int n =Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            int sum = 0;
            for(int i = 0; i< n; i++) {
               st = new StringTokenizer(br.readLine());
               arr[i][0] = Integer.parseInt(st.nextToken());
               arr[i][1] = Integer.parseInt(st.nextToken());
               sum += arr[i][0] * arr[i][1];

            }
            int result = sum /2;

            if( sum %2 ==1) {
                sb.append(0).append("\n");
                continue;
            }

            boolean[] dp = new boolean[result+1];
            dp[0] = true;
            for(int i=0; i< n; i++) {
                int cost = arr[i][0];
                int count = arr[i][1];
                int c= 1;
                while ( count >0) {
                    int use = Math.min(c, count);

                    int dist = use * cost;


                    for (int j = result; j >= dist; j--) {
                        if (dp[j - dist]) dp[j] = true;
                    }
                    count -= use;
                    c <<=1;


                }


            }
            if(dp[result]) sb.append(1).append("\n");
            else  sb.append(0).append("\n");

        }

        System.out.println(sb);
    }

}
