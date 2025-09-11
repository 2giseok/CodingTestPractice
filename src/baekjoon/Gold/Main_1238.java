package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
    static  int n ;
    static  int m ;
    static  int x;
    static  ArrayList<int[]>[] graph;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

         graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList();

        }
        for(int i=0; i< m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[start].add(new int[] { end,dist});

        }
int max = 0;
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            int result = dijkstra(i, x);
            int result1 = dijkstra(x,i);
            arr[i] = result1+result;

            max = Math.max(arr[i] ,max);

        }
        System.out.println(max);


    }

    private static int dijkstra(int i, int x) {
        PriorityQueue<int[]> queue=  new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] arr =new int[n+1];
        for(int j=1; j<=n; j++) {

            arr[j] = Integer.MAX_VALUE;
        }

        queue.add(new int[] { i, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node= current[0];
            int dist = current[1];

            if ( arr[node ] < dist) continue;

            if ( node ==x) {
                return dist;

            }

            for(int[] next: graph[node]) {
                int nextnode = next[0];
                int nextdist = next[1];


             if ( dist+ nextdist < arr[nextnode])  {

                    arr[nextnode] = dist+nextdist;
                    queue.add(new int[] {nextnode, nextdist + dist});

                }


            }




        }


        return -1;

    }




}
