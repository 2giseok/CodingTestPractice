package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n  =Integer.parseInt(br.readLine());

        int[] arr = new int[20000001];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st= new StringTokenizer (br.readLine());
        int count= 10000000;
        for(int i=0; i< n; i++) {
            int num  = Integer.parseInt(st.nextToken());
            arr[num+count] ++;
            
            
        }
        int m =  Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++) {
            int  z = Integer.parseInt(st.nextToken());

            sb.append(arr[z+count]).append(" ");
            
            
        }
        System.out.print(sb);
    }
}
