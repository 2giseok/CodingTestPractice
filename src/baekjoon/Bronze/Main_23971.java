package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_23971 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h=  Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    int count = 0;
        for(int i=0; i<h; i+=1+n) {
            for(int j=0; j<w; j+=1+m) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
