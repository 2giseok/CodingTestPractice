package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main_24042 {
    static int m,a,b;
    static  int n;
    static  long num;
    static ArrayList<int[]>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList();
        }

        for(int i=0; i<m; i++) {
        st = new StringTokenizer(br.readLine());
        a =Integer.parseInt(st.nextToken());
        b =Integer.parseInt(st.nextToken());

        graph[a].add(new int[] {b,i});
        graph[b].add(new int[] {a,i});


        }
       long result =  Dijkstra();
        System.out.println(result);


    }

    private static long Dijkstra() {
       PriorityQueue<long[]> queue = new PriorityQueue<>((Comparator.comparingLong(o -> o[1])));

        queue.add(new long[] {1,0});
        long[] board = new long[n+1];
        Arrays.fill(board,Long.MAX_VALUE);
        board[1] = 0;

        while (! queue.isEmpty()) {


            long[] current=  queue.poll();
            long x = current[0];
            long dist = current[1];

            int h  =(int) x;


            if ( x == n) return dist;

            for( int[] next : graph[h]) {
                int nx = next[0];
                int nextdist = next[1];

                if ( dist > board[h]) continue;
                int k = nextdist;
                long wait = ((k - (dist % m) + m) % m);
                long newTime = dist + wait + 1;

                if (board[nx] > newTime) {
                    board[nx] = newTime;
                    queue.add(new long[]{nx, newTime});
                }

            }




        }
    return -1 ;
    }
}
