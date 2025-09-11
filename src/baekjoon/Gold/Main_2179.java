package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2179 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

      List<String> lists = new ArrayList<>();

      for(int i=0; i< n; i++) {
          lists.add(br.readLine());
      }

int maxcount =0 ;
      int answer1 = 0;
      int answer2 = 0;
      for(int i=0 ;i<n; i++) {
          String a=  lists.get(i);
          for(int j=i+1; j< n; j++) {
              int count = 0;
              String b= lists.get(j);

              int num = Math.min(b.length(), a.length());

              for(int k=0; k <num; k++) {

                  if(a.charAt(k) == b.charAt(k))  count++;
                  else  break;

              }
              if ( maxcount < count) {
                  answer1 = i;
                  answer2 =j;

                  maxcount = count;
              }




          }
      }

      System.out.println(lists.get(answer1));
      System.out.println(lists.get(answer2));


        }
    }

