package baekjoon.Gold;
import java.util.*;
import java.io.*;
public class Main_2138 {
    static int n;
    static char[] b;
    public static void main(String[] args)throws  IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n  = Integer.parseInt(br.readLine());

        char[] a= br.readLine().toCharArray();
         b=  br.readLine().toCharArray();

      int one =   function(a.clone(), false);
        int zero = function(a.clone(), true);

        int min = Math.min(one, zero);


        System.out.println(min == Integer.MAX_VALUE ? -1 : min);


    }

    static int function(char[] arr, boolean check) {
       int count = 0;
        if( check) {
            press(arr,0);
            count ++;
        }

        for(int i=1; i<n; i++) {
            if ( arr[i-1] != b[i-1]) {
                press(arr,i);
                count ++;
            }
        }

        if(Arrays.equals(arr, b)) return count ;

        else return Integer.MAX_VALUE;

    }

    static void press(char[] arr, int x) {

        for(int j= x-1; j<= x+1; j++ ) {
            if( j >=0 && j < n) {

                arr[j] = (arr[j] == '0') ? '1' : '0';
            }

        }


    }
}
