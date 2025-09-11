package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14658 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int n  =Integer.parseInt(st.nextToken());
        int m  =Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k  =Integer.parseInt(st.nextToken());

        int[][] arr= new int[k][2];

        for(int i=0; i< k; i++) {
            st=  new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());



        }





        int count= 0 ;
        int num = 0;
        for(int i=0; i< k; i++ ) {
            for(int j=0; j<k; j++) {
                int left= arr[i][0];
                int down = arr[j][1];

                if ( left > n -l) left=  n-l;
                if ( down > m-l) down = m-l;

                int right = left + l;
                int up = down +l;
                count = 0 ;
                for(int h=0; h <k; h++) {
                    int x=  arr[h][0];
                    int y=  arr[h][1];
                    if (left <=  x && right >= x && up >= y && down <= y) {
                        count ++;

                    }
                    num =  Math.max(count,num);


                }





            }

        }

        System.out.println( k-num);
    }
}
