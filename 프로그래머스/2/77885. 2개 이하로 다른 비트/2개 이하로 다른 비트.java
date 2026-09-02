import java.util.*;
class Solution {
    long count = 0;
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int n  = numbers.length;
        
        for(int i=0; i<n; i++) {
            count = 0;
                if( numbers[i] %2 ==0 ) {
                    answer[i] = numbers[i] +1;
                } else if( numbers[i] %2 ==1 ) { 
                answer[i] = checking(numbers[i]);
                }
            
            
        }
        return answer;
    }
    
    public long checking (long target) {
        
        StringBuilder sb=  new StringBuilder();
        
        sb.append("0");
        String word=  Long.toBinaryString(target);
        sb.append(word);
        
        String ans = sb.toString();
        
        int m =  ans.length();
        
        String[] arr= new String[m];
        for(int i=0; i< m; i++) {
            char num =  ans.charAt(i);
            
            arr[i] = String.valueOf(num);
        }
        // 0111
        for(int i=m-1; i >0; i--) {
            
            if(arr[i].equals("1") && arr[i-1].equals("0") ) {
                
                arr[i] = "0";
                arr[i-1]="1";
                break;
            }
            
        }
        
        String result ="";
        
        for(int i=0; i< m; i++) {
            result +=arr[i];
        }
        
        return  Long.parseLong(result ,2);
        
        
        
    }
   
}