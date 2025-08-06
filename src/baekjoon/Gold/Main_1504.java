package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1504 {
    static  int n,m,a,b,c,q,w;
    static ArrayList<int[]>[]graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n =Integer.parseInt(st.nextToken());
         m  = Integer.parseInt(st.nextToken());

         graph = new ArrayList[n+1];

         for(int i=1; i<=n; i++) {
             graph[i] = new ArrayList<>();
         }

         for(int i=0; i<m; i++) {
             st=  new StringTokenizer(br.readLine());
             a=Integer.parseInt(st.nextToken());
             b=Integer.parseInt(st.nextToken());
             c=Integer.parseInt(st.nextToken());
             graph[a].add(new int[] {b,c});
             graph[b].add(new int[] {a,c});
         }
        st=  new StringTokenizer(br.readLine());
         q=Integer.parseInt(st.nextToken());
         w=  Integer.parseInt(st.nextToken());

         int result = bfs();
    System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int max= 100001 ;
        int[] num = new int[n+1];

        boolean[] visited=  new boolean[n+1];
        queue.add(new int[] {1,0});
        visited[1] =true;
        while (!queue.isEmpty()) {
            int[] current=  queue.poll();
            int node = current[0];
            int dist = current[1];
            for(int[] next :graph[node]) {
                int nextnode = next[0];
                int nextdist = next[1];

                if(visited[nextnode]) {
                   if( num[nextnode] > dist + nextdist)
                       num[nextnode] = dist+nextdist;

                } else {
                    visited[nextnode] = true;
                    num[nextnode] = dist + nextdist;
                    queue.add(new int[]{nextnode, dist + nextdist});

                }
                if (nextnode ==n&&visited[q] && visited[w]) {
                    max  =Math.min(max, nextdist + dist);

                }
            }


        }
        if( visited[n]) {
            return max;
        }
        return -1;
    }
}
