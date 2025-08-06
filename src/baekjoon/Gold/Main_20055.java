package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055 {
    static  int n ,m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        st=  new StringTokenizer(br.readLine());
        int[] arr= new int[n*2];
        int[] roboot = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int count = 0;
        int zerocount = 0;

        while (zerocount < m) {
            zerocount =0;

            move(arr,roboot);
            robootmove(roboot, arr);

            if(roboot[0] ==0 && arr[0] !=0) {

                roboot[0] = 1;
                arr[0] -=1;
            }


            for(int i=0; i<arr.length; i++) {
                if(arr[i] ==0) {
                    zerocount ++;
                }

            }

            count++;


        }
        System.out.println(count);


    }

    private static void robootmove(int[] roboot, int[] arr) {
        if(roboot[n-1] ==1) {
            roboot[n-1] = 0;

        }
        for(int i = n-1; i>0; i--) {
            if(arr[i] >0 && roboot[i] !=1 && roboot[i-1] ==1) {
                arr[i] -=1;
                roboot[i] = 1;
                roboot[i-1] = 0;

            }
        }
        if(roboot[n-1] ==1) roboot[n-1] = 0;
    }


    private static void move(int[] arr,int[] roboot) {
       int  temp = arr[arr.length-1];

        for(int i= arr.length-1; i>=1; i--) {
           arr[i] = arr[i-1];

        }
        arr[0] = temp;

        for(int i=n-1; i>=1; i--) {
            if( roboot[i-1] ==1) {
                roboot[i-1] = 0;
                roboot[i]=1;

            }
        }
    }
}
