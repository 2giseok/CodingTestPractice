package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_25757 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String x= st.nextToken();
        boolean[] visited= new boolean[100001];
        Set<String> player = new HashSet<>();


        for(int i=0; i<n; i++) {
           String name = br.readLine();
           player.add(name);




        }
        int count = player.size();
        if(x.equals("Y")) {
            System.out.println(count);
        }
        if(x.equals("F")) {
            int num = count/2;
            System.out.println(num);
        }
        if(x.equals("O")) {
            int num = count/3;
            System.out.println(num);
        }
    }
}
