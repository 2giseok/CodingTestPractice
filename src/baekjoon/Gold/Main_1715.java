package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1715 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> num = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i< n; i++) {
            int m=  Integer.parseInt(br.readLine());
         queue.add(m);
        }
        int sum =0;
        while (queue.size() > 1) {
           int a=  queue.poll();
            int b = queue.poll();
            int c=  a+b;
            sum += c;

            queue.add(c);
        }




        System.out.println(sum);

    }
}
