package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13144 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[n];
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int left = 0;
        long count = 0;

       Set<Integer> lists = new HashSet<>();

        for(int right = 0; right <n; right ++) {


            if (lists.contains(arr[right])) {
                while (lists.contains(arr[right])) {

                    lists.remove(arr[left++]);

                }
                lists.add(arr[right]);
                count += right - left + 1;



            }
            else  {
                lists.add(arr[right]);
                count += right - left + 1;
            }
        }

        System.out.println(count);



    }
}
