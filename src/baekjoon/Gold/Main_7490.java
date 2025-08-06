package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main_7490 {
    static  int n;
    static List<String>result;
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));


        
        int  a = Integer.parseInt(br.readLine());

         while ( a -- > 0) {
             n = Integer.parseInt(br.readLine());

             result = new ArrayList<>();
             dfs(1, "1");

             Collections.sort(result);
             for (String expr : result) {
                 System.out.println(expr);
             }
             System.out.println();
         }
        
    }

    private static void dfs(int i, String number) {

    if( i == n)  {
        if( function (number.replace(" ", ""))==0) {
            result.add(number);
        }
        return ;
    }

    dfs( i+1, number+ " " +  (i +1));
        dfs( i+1, number+ "+" +  (i +1));
        dfs( i+1, number+ "-" +  (i +1));
    }


    private static int function(String replace) {
        int sum = 0;
        int num = 0;
        char op = '+';

        for(int i=0; i<replace.length(); i++) {

            char a= replace.charAt(i);

            if(Character.isDigit(a)) {
                num = num * 10 + (a -'0');
            }

            if ( !Character.isDigit(a) || i ==replace.length()-1 ) {
                if( op== '+') {
                    sum += num;
                }
                else if ( op =='-') {
                    sum -= num;
                }

                op = a;
                num = 0;

            }


        }




    return sum;
    }
}
