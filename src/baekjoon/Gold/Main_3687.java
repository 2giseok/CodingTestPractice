package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3687 {
    static  int[] matches = {2,3,4,5,6,7};
    static  char[][] tree = {
            {'1'},
            {'7'},
            {'4'},
            {'2'},
            {'0','6'},
            {'8'}

    };
    static  String[] num;
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        num = new String[101];
        num[2] ="1";
        num[3] = "7";
        num[4] = "4";
        num[5] = "2";
        num[6] = "6";
        num[7] = "8";


        String maxresult="";
        String minresult ="";
        int  n =Integer.parseInt(br.readLine());
        int[] arr=  new int[n];
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(br.readLine());


       maxresult =   dp(arr[i]);
        minresult =  smaller(arr[i]);
            System.out.println(minresult +" " + maxresult);
        }






    }

    private static String smaller(int x) {



            for(int  j = 8; j<=x; j++) {
                String best = null;

                for(int i=0; i<matches.length; i++) {
                    int c=  matches[i];
                    if ( j -c < 2) continue;
                    String base = num[j-c];
                    if ( base ==null) continue;

                    for(char d : tree[i]) {
                        if( d== '0' && base.isEmpty()) continue;

                        String cand = base + d;
                        if( best ==null || min_number(cand, best)) best=cand;

                    }


                }
                num[j] = best;



        }

return num[x];
    }

    private static boolean min_number(String s, String s1) {
        if ( s.length() != s1.length()) return  s.length() < s1.length();

        return s.compareTo(s1) < 0;

    }


    private static String dp(int x) {
        String max= "";

        int count = x;

            if ( x %2 ==1) {
                max += "7";
                count -=3;
            }
            while (count >=2) {

                    max  = max +  "1";


                    count -= 2;

            }







        return max;

    }
}
