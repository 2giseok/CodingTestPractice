import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int count =0;
         m  = Change(m);
        for(int i=0; i<musicinfos.length; i++) {
            String[] parts=  musicinfos[i].split(",");
            String start = parts[0];
            String end = parts[1];
            String name=  parts[2];
            String music = Change(parts[3]);
            
            
            int startTime = time(parts[0]);
            int endTime=  time(parts[1]);
            int dist = endTime - startTime;
            
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<dist; j++) {
                sb.append(music.charAt(j % music.length()));
            }
            if(sb.toString().contains(m)) {
                if( dist > count) {
                    count = dist;
                    answer= name;
                }
            }
        }
        
        return answer;
    }
    
    public String Change (String word) {
        word  = word.replace("C#","c");
        word  = word.replace("D#","d");
        word  = word.replace("F#","f");
        word  = word.replace("G#","g");
        word  = word.replace("A#","a");
        return word;
    }
    public int time(String time) {
        
        String[] part = time.split(":");
        int hour = Integer.parseInt(part[0]);
        int minute =  Integer.parseInt(part[1]);
        int total = hour*60 + minute;
        
        return total;
        
    }
}