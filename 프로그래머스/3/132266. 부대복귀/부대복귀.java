import java.util.*;
class Solution {
    List<List<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i< roads.length; i++) {
            
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        for(int j=0; j<sources.length; j++) {
          answer[j] =   dijstra(sources[j], destination,n);
        }
        return answer;
    }
    
    public int dijstra(int start , int end,int board) {
        
       Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {start,0});
        
        int[] dist = new int[board+1];
        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[start] = 0 ;
        
        while(!queue.isEmpty()) {
            
            int[] current=  queue.poll();
            
            int node = current[0];
            int count = current[1];
            
            if( dist[node] > count) continue;
            
            for(int next : graph.get(node)) {
                if(dist[next] > count+1) {
                    dist[next] = count +1;
                    queue.add(new int[] {next, count+1});
                }
            }
        }
        if(dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}