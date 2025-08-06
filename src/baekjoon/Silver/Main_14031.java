package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14031 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while ( n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr= new int[20];
            for(int i=0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            while (true) {
                int count = 0;
                int  temp = 0;
                for(int i=0; i<20; i++) {
                   for(int j=i+1; j<20; j++) {
                       if(arr[i] > arr[j]) {
                            temp = arr[i];
                           arr[i] = arr[j];
                           arr[j] = temp;
                           count ++;
                       }

                   }

                }
                System.out.println(num +" " + count);
                break;

            }

        }
    }
}
