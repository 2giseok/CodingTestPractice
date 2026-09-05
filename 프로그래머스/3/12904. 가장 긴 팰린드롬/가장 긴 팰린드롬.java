import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        
        int left = 0;
        int right = s.length()-1;
        
        
      
        for(int i=0; i< s.length(); i++ ) {
            
            for(int j=s.length() -1; j>i; j--) {
                if( j-i +1 < answer) continue;
                if(checking(i,j,s)) {
                    int result =  j-i +1;
                    answer=  Math.max(result,answer);
                }
            }
        }
        
  

        return answer;
    }
    public boolean checking(int left, int right , String s) {
        
        int dist = right - left;
        
        for(int i=0; i<dist; i++) {
            if(s.charAt(left +i) != s.charAt(right - i)) {
                return false;
            }
        }
        
        return true;
        
    }
}