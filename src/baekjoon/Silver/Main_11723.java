package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
        int n =  Integer.parseInt(br.readLine());

        long[] arr= new long[1048577];
        StringTokenizer st;
        String a;
        int x;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            a=st.nextToken();

            if(a.equals("all")) {
                for(int j=1; j<=20; j++) {
                    arr[1 <<j] = 1;
                }
continue;
            }

            if(a.equals("empty")) {
                for(int j=1; j<=20; j++) {
                    arr[1 <<j] = 0;
                }

                continue;

            }
            x = Integer.parseInt(st.nextToken());

            if(a.equals("add")) {
                arr[1 <<x] = 1;
            }
            if (a.equals("remove")) {
                arr[1 << x] = 0;
            }
            if(a.equals("check")) {
                if(arr[1 <<x] != 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            if(a.equals("toggle")) {
                if(arr[ 1 <<x] ==0) arr[1 <<x] = 1;
                else  arr[1 <<x] =0;

            }






        }
        System.out.print(sb);
    }
}
