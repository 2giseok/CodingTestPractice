package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8979 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr= new int[n+1][4];
        int[] A = new int[4];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());


            if ( arr[i][0] ==m) {
                A[0] = arr[i][0];
                A[1] = arr[i][1];
                A[2] = arr[i][2];
                A[3] = arr[i][3];

            }

        }


        int count=1;


        for(int i=1; i<=n; i++) {

            if( arr[i][0] == m) continue;

            if( arr[i][1] > A[1] ||
            arr[i][1] == A[1] && arr[i][2] > A[2] ||
            arr[i][1] == A[1] && arr[i][2] == A[2] && arr[i][3] > A[3])
                count ++;
        }


            System.out.println(count);


        }


    }


