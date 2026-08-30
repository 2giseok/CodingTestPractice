import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = "";
        String index = Integer.toString(n,k);
        int result = 0;
        
           String[] dist = index.split("0");
            for(int i=0; i<dist.length; i++) {
                if(dist[i].equals("")) {
                    continue;
                }
            result  +=   checking(dist[i]);
            }
        answer= result;
        
        return answer;
    }

public int checking(String word) {
    
    boolean visited=  true;
    
    long count = Long.parseLong(word);
    
    if(count <2) {
        return 0;
    }
    
    for(int j=2; j<=Math.sqrt(count); j++) {
        
        if(count % j ==0) {
            visited=  false;
        }
    }
    if(visited) {
        return 1;
    } else {
        return 0;
    }
    
    
}
}