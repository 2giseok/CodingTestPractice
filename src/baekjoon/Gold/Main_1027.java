package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr= new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int count = 0;
        int num ;

        for(int i=0; i< n; i++) {
            num = 0;


            long rnum = 0;
            long rden = 1;
            boolean right = false;
            boolean left = false;


            for(int  j =i+1; j< n; j++) {
                long result=  (arr[j] - arr[i]) ;
                        long result1 = j-i;



            if (!right || result * rden > rnum * result1) {
                rden=result1; rnum = result;
                right = true;
                num++;
            }
            }


            long lnum = 0;
            long lden =1;
            for(int k = i-1 ; k >=0; k--) {
                long result = (arr[i] - arr[k]) ;
                long result1 = i - k;

                if (!left || result * lden < result1 * lnum) {
                    left = true;

                    lnum = result; lden = result1;

                    num++;
                }
            }

            count =  Math.max(count, num);

        }

        System.out.println(count);

    }
}
