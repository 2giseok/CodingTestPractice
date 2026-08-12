import java.util.*;
class FileInfo {
    String head;
    String tail;
    int number;
    String file;
    
    public FileInfo(String head, String tail, int number,String file) {
        this.head = head;
        this.tail = tail;
        this.number= number;
        this.file=file;
    }
}


class Solution {
    public String[] solution(String[] files) {
        String[] answer;
        int n  = files.length;
        
        FileInfo[] fileInfos  = new FileInfo[n];
        
   
        for(int i=0; i<n; i++) {
            
           int len = files[i].length();
            int startNumber = -1;
            int endNumber =-1;
            
            for(int j=0; j<len; j++) {
                
                if( j - startNumber >=5 && startNumber != -1) {
                    endNumber =j; break;
                }
                
                char a = files[i].charAt(j);
               if (Character.isDigit(a)) {
                if (startNumber == -1) startNumber = j;
                } else {
                if (startNumber != -1) {
                endNumber = j;
                break;
            }
            }
            }
            if(endNumber == -1) endNumber = len;
            
            String head = files[i].substring(0, startNumber);
            String number = files[i].substring(startNumber, endNumber);
            String tail = files[i].substring(endNumber);
            int num = Integer.parseInt(number);
            fileInfos[i] = new FileInfo(head,tail,num,files[i]);
        
        }
        
        Arrays.sort(fileInfos, (o1,o2) -> {
            int headCompare = o1.head.compareToIgnoreCase(o2.head);
            
            if( headCompare ==0) {
                
                return Integer.compare(o1.number, o2.number);
            }
            return headCompare;
        });
        
        answer = new String[n];
        for(int i=0; i<n; i++) {
            answer[i] = fileInfos[i].file;
        }
     return answer;   
    }
}