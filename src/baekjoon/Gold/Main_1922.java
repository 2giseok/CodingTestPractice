package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main_1922 {

    static  class Edge {
        int from,to,weight;
        Edge(int from, int to ,int weight) {
            this.from = from;
            this.to = to;
            this.weight =weight;
        }
    }

    static int[] parent;
    static  int n,m;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parent =new int[n+1];

        m  =Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        for(int i=1; i<=m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,c));

        }

        edges.sort(Comparator.comparingInt(e-> e.weight));

        for(int i=1; i<=n; i++) parent[i] = i;
int result =0;

        for(Edge e : edges) {
            if(find(e.from) != find(e.to)) {
                union(e.from, e.to);
                result += e.weight;
            }

        }
        System.out.println(result);

    }

    private static void union(int x, int y) {
        x=  find(x);
        y = find(y);
        if(x!=y) parent[y]=x;

    }

     static int find(int x) {

        if (x == parent[x]) return x;


        return parent[x] = find(parent[x]);
    }


}
