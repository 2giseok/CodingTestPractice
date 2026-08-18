import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        Set<String>set = new HashSet<>();
        
       StringBuilder sb = new StringBuilder();
       int n =  relation[0].length;
        Set<Integer> result = new HashSet<>();
       
        for(int i=1; i< (1 <<n); i++) {
           
            set = new HashSet<>();
            for(int r = 0; r<relation.length; r++) {
                 sb = new StringBuilder();
            for(int j=0; j<n; j++ ) {
                
                if((i& (1<<j)) != 0) {
                    sb.append(relation[r][j]);
                }
            }
                set.add(sb.toString());
            }
            boolean visited= true;
            if(set.size() ==relation.length ) {
                for(int key: result) {
                    if((i &key) ==key) {
                        visited=false;
                        break;
                    }
                }
                if(visited) {
                    result.add(i);
              
                }
            }
            
        }
        answer = result.size();
        return answer; 
    }
}