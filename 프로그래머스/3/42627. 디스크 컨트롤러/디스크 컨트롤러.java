import java.util.*;
class Solution {
  
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
        
          Arrays.sort(jobs,(o1,o2) -> {
            return o1[0] - o2[0];
        });
        
        int total =0;
        int time =  0;
        int count =0;
        int jobIdx =0;
        
        while( count < jobs.length) {
            
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
                queue.add(new int[] {jobs[jobIdx][0], jobs[jobIdx][1]});
                jobIdx ++;
            }
            
            
        if(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            time += current[1];
            total += time - current[0];
            
             count ++;
            
        } else {
            time = jobs[jobIdx][0];
        }
        
        }
        
        
        int answer= total/jobs.length;
        
        return answer;
        
    }
   
}

// 3-0 12 -1, 17 -3  // 3 11 14