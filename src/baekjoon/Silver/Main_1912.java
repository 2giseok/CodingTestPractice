package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[64];
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;

        for (int i = 1; i<64; i++) {
        dp[i] = dp[i-1]*2 + (1 << (i-1));
        }

       for(int j=0; j<2; j++) {
           int num = arr[j];
           while (num ==0) {


           }

       }
    }
}
