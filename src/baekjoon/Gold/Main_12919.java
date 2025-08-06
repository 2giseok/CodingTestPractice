package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_12919 {
    static  boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        dfs(a, b);


        if (found) {
            System.out.println(1);

        } else System.out.println(0);


    }
    private static void dfs(String a, String b) {
        if (a.length() > b.length()) return;

        if(a.equals(b)) {
            found = true;
            return ;
        }



             if (b.endsWith("A")) {
                dfs(a, b.substring(0, b.length() - 1));
            }

            if (b.startsWith("B")) {

                b = new StringBuilder(b).reverse().toString();
                dfs(a, b.substring(0,b.length()-1));

            }




    }
}
