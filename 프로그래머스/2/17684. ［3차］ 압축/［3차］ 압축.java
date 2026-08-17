import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int start = 1;
        int i =0;
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(char c = 'A'; c<='Z'; c++) {
            map.put(String.valueOf(c),start++);
        }
         
        while(i <msg.length()) {
      
            String ans= String.valueOf(msg.charAt(i));

                String word = ans;
            
            if( i < msg.length() -1) {
                    
                for(int j=i+1; j< msg.length(); j++) {
                    
                    String a = String.valueOf(msg.charAt(j));
                   word +=a;
                    
                    if(map.containsKey(word)) {
                        ans = word;
                    }
                    
                    if(!map.containsKey(word)) {
                        map.put(word,start++);
                        break;
                    }
                    
                
            }
            }
           int index =  map.get(ans);
            result.add(index);
            
            i+=ans.length();
            
            
            
        }
        int[] answer = new int[result.size()];
        int count =0;
        for(int r : result ) {
            answer[count ++] = r;
            
        }
        
        return answer;
       
    }
}