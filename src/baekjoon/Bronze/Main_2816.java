package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i].equals("KBS1")) {
                String temp = "";
                for (int j = i; j > 0; j--) {
                    System.out.print(4);
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
                break;
            } else System.out.print(1);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("KBS2")) {
                String temp = "";
                for (int j = i; j > 1; j--) {
                    System.out.print(4);
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

                break;

            } else System.out.print(1);
        }
    }
}
