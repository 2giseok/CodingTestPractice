package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22251 {
    static  int[] bit = {
            0b1111110,
            0b0110000,
            0b1101101,
            0b1111001,
            0b0110011,
            0b1011011,
            0b1011111,
            0b1110000,
            0b1111111,
            0b1111011
    };
    static  int n,x,k,p;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

       n  =Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
int count = 0;


String target = String.format("%0" + k + "d",x);

        for(int i=1; i<=n; i++) {
            if ( i == x) continue;

            String now = String.format("%0" + k + "d",i);


        int result = change(now,target);

        if ( result <= p) {
            count ++;
        }

        }

        System.out.println(count);
    }


    private static int change(String now, String x) {

        int num = 0;


        for(int i=0; i< x.length(); i++ ) {
            int a= now.charAt(i) -'0';
            int b= x.charAt(i) - '0';


               num += Integer.bitCount(bit[a] ^ bit[b]);



            }


        return num;
        }



    }

