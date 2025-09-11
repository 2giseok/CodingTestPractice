package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22866 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n+1];
        int[][] num = new int[n+1][2];
        int count = 0;
        


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.MAX_VALUE;
        }
        for(int i=1; i<= n; i++) {
            count = arr[i];
            int down = Integer.MAX_VALUE;
            int up = Integer.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {

                if (arr[j] > count) {
                    count = arr[j];
                    num[i][0]++;

                    down = Math.min(down, i - j);


                }


            }
            count = arr[i];
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] > count) {
                    count = arr[j];
                    num[i][0]++;

                    up = Math.min(up, j - i);

                }


            }

            if (up == down) {
                num[i][1] = i - down;

            } else if (up > down) {
                num[i][1] = i - down;

            } else {
                num[i][1] = i + up;


            }
        }

        for(int i=1; i<= n; i++) {
            if(num[i][0] ==0) {
                System.out.println(0);
                continue;
            }
            System.out.println(num[i][0] + " " + num[i][1]);

        }





    }
}
