package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9527 {
    static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        dp = new long[64];
        dp[0] = 0;

        for (int i = 1; i < 64; i++) {
            dp[i] = dp[i - 1] * 2 + (1L << (i - 1));
        }


        long result1 = bitcount(n-1);
        long result2 = bitcount(m);

        System.out.println(result2 - result1);

    }


    private static long bitcount(long n) {

        if( n<=0) {
            return 0;
        }
int k=0;
        while ((1L<< (k+1) <=n)) {

            k++;
        }

        long result = dp[k];

        result +=(n  - (1L<<k) +1);
        result += bitcount(n - (1L <<k));
        return result;
    }
}