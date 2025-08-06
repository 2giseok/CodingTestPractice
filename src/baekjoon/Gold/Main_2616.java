package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2616 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long [] a=  new long[n+1];
        long[] arr= new long[n+1];
        for(int i=1; i<=n; i++) {
           a[i] = Integer.parseInt(st.nextToken());
           arr[i] = arr[i-1]+ a[i];

        }
        int m = Integer.parseInt(br.readLine());
        long[] acc= new long[n+1];

        for(int i=m; i<=n; i++) {
            acc[i] = arr[i] - arr[i-m];

        }

        long[] dp1= new long[n+1];
        long[] dp2= new long[n+1];
        long[] dp3= new long[n+1];

        for(int i=m; i<=n; i++) {
            dp1[i]= Math.max(dp1[i-1],acc[i] );
            dp2[i] = Math.max(dp2[i-1], dp1[i-m] + acc[i] );
            dp3[i] = Math.max(dp3[i-1], dp2[i-m] + acc[i]);
        }

        System.out.println(dp3[n]);



    }
}
