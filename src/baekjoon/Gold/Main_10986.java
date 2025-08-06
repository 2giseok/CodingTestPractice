package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
         st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int[] mod = new int[n];
        mod[0] = 1;

        long sum = 0;
        for(int i=0; i<m; i++) {
            sum +=arr[i];
            int r = (int) (sum% n);
            if(r<0) r+=n;
            mod[r] ++;


        }
        long count  = 0;

        for(int i=0; i<n; i++) {
            count +=(long) mod[i] *(mod[i] -1) /2;

        }
        System.out.println(count);
    }
}
