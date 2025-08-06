package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4659 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            boolean answer = true;


           String a= br.readLine();

            if (a.equals("end")) {
                break;
            }

           char[] arr =new char[a.length() +2];
           int count =0;

            for(int i=0; i<a.length(); i++) {
                arr[i] = a.charAt(i);
            }
            for(int i=0; i<a.length()-1; i++) {
                if(arr[i] == arr[i+1]) {
                    if( arr[i]  !='e' && arr[i] !='o') {
                        answer = false;
                        break;

                    }


                }


                if(arr[i] =='a' ||arr[i] == 'e' ||arr[i] =='i'||arr[i] =='o'||arr[i] =='u' ) {

                    if(arr[i+1] =='a' ||arr[i+1] == 'e' ||arr[i+1] =='i'||arr[i+1] =='o'||arr[i+1] =='u') {
                        if(arr[i+2] =='a' ||arr[i+2] == 'e' ||arr[i+2] =='i'||arr[i+2] =='o'||arr[i+2] =='u') {
                            answer = false;
                            break;
                        }
                    }

                }
                if(arr[i] !='a' && arr[i] != 'e' &&arr[i] !='i'&&arr[i] !='o'&&arr[i] !='u' ) {
                    if(arr[i+1] !='a' &&arr[i+1] != 'e' &&arr[i+1] !='i'&&arr[i+1] !='o'&&arr[i+1] !='u' ) {
                        if(arr[i+2] !='a' &&arr[i+2] != 'e' &&arr[i+2] !='i'&&arr[i+2] !='o'&&arr[i+2] !='u' ) {
                            answer = false;
                             break;

                        }
                    }
                }

            }

            for(int i=0; i<a.length(); i++) {

                if(arr[i] =='a' ||arr[i] == 'e' ||arr[i] =='i'||arr[i] =='o'||arr[i] =='u' ) count ++;
            }
            if( count ==0) {
               answer=  false;
            }

            if(answer) {
                System.out.println("<" +a+ "> is acceptable.");
            } else {
                System.out.println("<" +a+ "> is not acceptable.");
            }



        }

    }
}
