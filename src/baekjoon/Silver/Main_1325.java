package baekjoon.Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {
    static  int n,m,a,b;
    static   ArrayList<Integer>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
         n  =Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        graph=  new ArrayList[n +1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
      
        for(int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
           a=  Integer.parseInt(st.nextToken());
           b = Integer.parseInt(st.nextToken());
            
            graph[b].add(a);

        }
        int[] result=  new int[n+1];
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++ ) {
            result[i] = bfs(i);
            num = Math.max(num , result[i]);
        }

        for(int i=1; i<=n; i++ ) {
            if( num == result[i]) {
                sb.append(i).append(" ");
            }

        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        
        



    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited= new boolean[n+1];
        visited[start] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count ++;
                }
            }

        }

    return count;
    }
}
