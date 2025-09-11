package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2631 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int n  =Integer.parseInt(br.readLine());

        int[] arr= new int[n];

        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }

        List<Integer> lis = new ArrayList<>();

        for(int i=0; i< n; i++) {
            if ( lis.isEmpty()) {

            lis.add(arr[i]);
            continue;
            }

            if(lis.get(lis.size()-1) < arr[i]) {
                lis.add(arr[i]);
            }
            else if (lis.get(lis.size()-1) > arr[i])  {

                for(int j=0; j< lis.size(); j++) {
                    if (lis.get(j) > arr[i]) {

                        lis.set(j,arr[i]);
                        break;
                    }


                }


            }


            }

        int count= arr.length- lis.size();
        System.out.print(count);
        }



    }

