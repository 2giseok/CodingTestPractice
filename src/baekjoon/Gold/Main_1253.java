package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
    static  int count =0;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[n];

        for(int i=0; i<n; i++) {
        arr[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i< n; i++) {
            int l = 0; int r=  n-1;
          while (l <r  ) {
              if ( l ==i ) { l ++; continue;}
              if( r ==i)  {r --; continue; }

              long idx = (long ) arr[l] + arr[r];

              if ( idx== arr[i] )  { count ++; break;}
              else if (arr[i] < idx ) {
                  r-- ;

              } else  l ++;


          }


        }


        System.out.println(count);






    }

}
