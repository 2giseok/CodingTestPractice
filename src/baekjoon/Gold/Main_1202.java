package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
        import java.util.function.Function;

public class Main_1202 {
    static    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    static  int[][] num;
    static  int[] bag;
    static  int n,m,b,c;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n =Integer.parseInt(st.nextToken());
        m  =Integer.parseInt(st.nextToken());
        num  = new int[n][2];
        bag=  new int[m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());



        }

        for(int i=0 ; i< m; i++) {
            bag[i]  =Integer.parseInt(br.readLine());

        }


        Arrays.sort(bag);
        Arrays.sort(num, Comparator.comparingInt(a -> a[0]));


        dijkstra();








    }

    private static void dijkstra() {

        long count = 0 ;


        for(int i=0, j=0; i< m; i++) {
            while (j < n) {
                if ( bag[i] < num[j][0]) break;


                queue.add( num[j++][1]);
            }

            if ( !queue.isEmpty()) {
                count += queue.poll();



            }




        }

        System.out.println(count);


    }
}
