package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5972 {
    static  int z,x,c;
    static  int n;
    static   List<int[]>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m  =Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] =new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            z = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[z].add(new int[] {x,c});
            graph[x].add(new int[] {z,c});
        }
        dijkstra(1);
    }

    private static void dijkstra(int x) {
        int[] dists = new int[n+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->Integer.compare(o1[1],o2[1]) );
        pq.add(new int[] {x,0});
        dists[x] = 0;

        while (!pq.isEmpty()) {

            int[] current=  pq.poll();

            int now= current[0];
            int cost=  current[1];

            if(dists[now]< cost) continue;

           for(int [] next :graph[now]) {
               int nextnode = next[0];
               int nextcost = next[1];

               if( dists[nextnode] > dists[now]+ nextcost) {
                   dists[nextnode] = dists[now] + nextcost;
                   pq.add(new int[] {nextnode,dists[nextnode]});
               }

           }


        }
        System.out.println(dists[n]);
    }
}
