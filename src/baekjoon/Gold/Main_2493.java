package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class  Tower {
    int index;
    int height;


    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] result = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Tower> stack =new Stack<>();

        for(int i=1; i<=n; i++) {
            while (!stack.isEmpty() && stack.peek().height < arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek().index;
            } else {
                result[i] =0;
            }


            stack.push(new Tower(i, arr[i]));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);




    }


}






