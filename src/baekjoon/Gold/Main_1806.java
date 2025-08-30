package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m  =Integer.parseInt(st.nextToken());
        int[] arr= new int[n];
        st =new StringTokenizer(br.readLine());
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());


        }
        long sum = 0 ;
        int num =  Integer.MAX_VALUE;
       int left = 0 ;

       for(int i=0; i< n; i++) {
           sum += arr[i];

           while (sum >= m ) {
                num = Math.min(num , i - left +1);
               sum -= arr[left++];

           }


       }
    if ( num == Integer.MAX_VALUE) {
        System.out.println(0);
    } else {
        System.out.println(num);
    }


    }
}
