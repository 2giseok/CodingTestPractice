import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int maxKey=0;
        int minKey = 0;
        int count = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        int n  = operations.length;
        
        for(int i=0; i<n; i++) {
        
           String[] parts = operations[i].split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);
            
            if(command.equals("I")) {
                map.put(number ,map.getOrDefault(number, 0) +1 );
            }
            
            if(map.size() !=0) {
            if( command.equals("D")) {
               maxKey = map.lastKey();
                 minKey = map.firstKey();
                
               if( number ==1) {
                count =  map.get(maxKey);
                   if(count ==1) {
                       map.remove(maxKey);
                   } else {
                       map.put(maxKey ,count -1);
                   }
                   
               }
                
                 if( number ==-1) {
                count =  map.get(minKey);
                   if(count ==1) {
                       map.remove(minKey);
                   } else {
                       map.put(minKey ,count -1);
                   }
                   
               }
            
            }
            }
        }
        if(map.size() ==0) {
            int[]answer = {0,0};
            return answer;
        }
           maxKey = map.lastKey();
                 minKey = map.firstKey();
        int[] answer = {maxKey, minKey};
        
        
        
        return answer;
    }
}