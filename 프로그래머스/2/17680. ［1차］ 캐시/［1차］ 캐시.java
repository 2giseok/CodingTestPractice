import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        int n =  cities.length;
        
        if(cacheSize ==0) {
            return n *5;
        }
        
        for(int i=0; i<n; i++) {
            
            String ans =  cities[i].toLowerCase();
            
            if(!list.contains(ans)) {
                answer +=5;
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(ans);
                continue;
            }
            
            if(list.contains(ans)) {
                
                list.remove(ans);
                list.add(ans);
                answer ++;
            }
            
        }
        return answer;
    }
}