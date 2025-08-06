package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20437 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  =Integer.parseInt(br.readLine());

        while ( n-- >0) {

            int temp = 0;
            String str = br.readLine();
            char[] arr= new char[str.length()];
            int[] count = new int[28];
            for(int i=0; i<arr.length; i++) {
                arr[i] = str.charAt(i);
                count[arr[i] -'a'] +=1;

                temp = Math.max(temp, count[arr[i] -'a']);


            }
            int num = Integer.parseInt(br.readLine());

            if (temp < num ) {
                System.out.println(-1);
                continue;

            }

           int max= 0;
           int min = Integer.MAX_VALUE;

            for(int i=0; i<arr.length; i++) {


                int c = arr[i] - 'a';


                if (count[c] >= num) {
                    int numcount = 1;


                    for (int j = i + 1; j < arr.length; j++) {

                        if( arr[i] == arr[j]) {
                            numcount ++;
                        }
                        if(numcount == num) {
                            int len = j - i +1;
                            max = Math.max(max, len);
                            min = Math.min(min, len);
                            break;

                        }

                    }

                }

            }


                System.out.println(min + " " + max);

        }
    }
}
