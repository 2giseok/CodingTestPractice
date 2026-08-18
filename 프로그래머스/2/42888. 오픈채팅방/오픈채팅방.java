import java.util.*;
class Solution {
    public String[] solution(String[] record) {
      
        List<String> list = new ArrayList<>();
        
        Map<String,String> map = new HashMap<>();
      int  n  = record.length;
        for(int i=0; i<n; i++) {
        
            String[] result =  record[i].split(" ");
            if(result.length ==3) {

                String nickname = result[2];
                String uid = result[1];
                
            if(result[0].equals("Enter")) {
                
                
                map.put(result[1], result[2]);
                    }
                if(result[0].equals("Change")) {
                    map.put(result[1],result[2]);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
              String[] result =  record[i].split(" ");
            
            if(result[0].equals("Enter")) {
                String come = map.get(result[1]);
                list.add(come + "님이 들어왔습니다.");
            }
            if(result[0].equals("Leave")) {
                String leave = map.get(result[1]);
                list.add(leave + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        int count = 0;
        for(String ans : list) {
            answer[count++] = ans;
        }
        return answer;
    }
}