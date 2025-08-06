package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2668 {

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr= new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
        List<Integer> graph=  new ArrayList<>();
for(int i=1; i<=n; i++) {
     bfs(arr, i,  graph);

}

//System.out.println(graph.size());
StringBuilder sb= new StringBuilder();
boolean[] vistied = new boolean[n+1];
int count =0;
for(int num : graph) {
    if(!vistied[num]) {
        sb.append(num).append("\n");
        vistied[num] = true;
        count ++;
    }
}
        System.out.println(count);
        System.out.println(sb);

    }

    private static void bfs(int[] arr,int start,List<Integer> result) {
        boolean[] visited= new boolean[arr.length];

        List<Integer>path = new ArrayList<>();

        Queue <Integer> queue= new LinkedList<>();


        queue.add( start);
        visited[start]= true;
        path.add(start);

        while (!queue.isEmpty()) {
            int current= queue.poll();

            int node=  arr[current];



            if(!visited[node]) {
                visited[node] = true;
                path.add(node);
                queue.add( node);

            }
            if( node == start) {
                result.addAll(path);
                return ;

            }


        }

    }
}
