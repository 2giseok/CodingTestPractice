package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String a= br.readLine();
        String target = br.readLine();
        char[] B = target.toCharArray();
        int m  =B.length;

        char[] arr=  new char[a.length()];
        int top = 0;
        for(int i=0; i< a.length(); i++) {
            arr[top ++] = a.charAt(i);


            if ( top >= m && arr[top -1] == B[m-1]) {
                boolean ckeck = true;

                for(int k=0; k<m; k++) {

                    if(arr[top-m+k] != B[k]){  ckeck = false; break; }

                }
                if ( ckeck) top -=m;



            }


                }

        if ( top ==0) {
            System.out.println("FRULA");
        } else {
            System.out.print(new String(arr, 0, top));
        }
            }

        }








