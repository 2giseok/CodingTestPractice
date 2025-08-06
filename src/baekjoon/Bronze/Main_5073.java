package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main_5073 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[] arr= new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int max= 0;
            for(int i=0; i<3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);

            }
            if( arr[0] == 0 && arr[1] ==0 && arr[2] ==0)break;

            if ( abs (max - (arr[0] + arr[1] + arr[2]))  <= max) {
                System.out.println("Invalid");
                continue;
            }
            if(arr[1] ==arr[2] &&arr[0] ==arr[1]  ) {
                System.out.println("Equilateral");
            }
            else if ( arr[0]==arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
                System.out.println("Isosceles");
            }

            else {

            System.out.println("Scalene");
            }
            }


        }
    }

