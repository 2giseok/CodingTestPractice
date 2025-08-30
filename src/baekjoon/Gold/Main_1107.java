package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = Integer.parseInt(br.readLine());

        int target = Math.abs(n - 100);
        boolean[] visited=  new boolean[10];
        if ( num >0) {
        StringTokenizer st=  new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        }
        for(int i=0; i<999999; i++) {
            int len = count(i,visited);
            if (len == 0) continue;
            int sum = len + Math.abs(n - i);
            if( sum < target) target = sum;


        }

        System.out.println(target);







    }

    private static int count(int i,boolean[] visited) {
        int len =  0;
        if ( i ==0 )return visited[i] ? 0 :1;
        while ( i >  0) {
            int num = i % 10;
            if ( visited[num]) return 0;
            len ++;
            i /= 10;


        }

    return len;
    }

}
