package programmers.lv1;

import java.io.BufferedReader;

public class Main_142086 {
    public int[] solution(String s) {
int[] answer = new int[s.length()];
boolean[] visited= new boolean[26];
char[] arr = new char[s.length()];
for(int i=0; i<s.length(); i++) {
    arr[i] = s.charAt(i);

    if ( !visited[arr[i] - 'a'] ) {

        visited[arr[i]-'a'] = true;
        answer[i] = -1;
    } else {
         answer[i] = get(arr, i);

    }
}


        return answer;
    }

    private int get(char[] arr, int i) {
        int y =-1;
        for(int x = 0; x< i; x++) {

            if ( arr[x]== arr[i]) {
                y= i - x;

            }
        }


        return y;
    }
}

