package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24337 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = Math.max(a, b);

        if (a + b - 1 > n) {
            System.out.println(-1);
            return;
        }

if ( a==1 ) {
    arr[a-1] = result;
   for(int i=0; i< b-1; i++) {
      arr[n-i-1] = i +1;
   }

    for(int i=0; i<n; i++) {
        if(arr[i]==0) arr[i]=1;
    }


} else if ( b ==1) {
    arr[n-1] = result;
    int abc =  n -a;
    int plus  = 0;
    for(int i=0; i<abc; i++) {
        arr[plus++] = 1;

    }
    for(int i=1; i <= a-1; i++) {
        arr[plus++] = i;

    }
    for(int i=0; i<n; i++) {
        if ( arr[i] ==0 ) arr[i]=1;
    }





} else {
  int abc = n - (a+b-1);
  int idx =0;
  for(int i=0; i< abc; i++) arr[idx++] = 1;

  for(int i=1; i<=a; i++)  arr[idx++] = i;

  arr[n-b] = result;

  for(int i=1; i < b; i++) {
      arr[n-b +i] = b-i;

  }





    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            arr[i] = 1;
        }
    }


}




        StringBuilder sb = new StringBuilder();
        for(int i=0; i< n; i++) {
        if( i > 0 ) {
            sb.append(' ');

        }
        sb.append(arr[i]);
        }
        System.out.println(sb);



    }
}
