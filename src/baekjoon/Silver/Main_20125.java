package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20125 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr= new char[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int heartRow = 0;
        int heartCol = 0;

        // 머리 위치 찾기
        outer:
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( arr[i][j]== '*') {
                    heartRow = i + 1;
                    heartCol = j;
                    break outer;
                }
            }
        }

        System.out.println((heartRow + 1) + " " + (heartCol + 1));

        // 왼팔
        int leftArm = 0;
        for (int i = heartCol - 1; i >= 0; i--) {
            if (arr[heartRow][i] == '*') leftArm++;
            else break;
        }

        // 오른팔
        int rightArm = 0;
        for (int i = heartCol + 1; i < n; i++) {
            if (arr[heartRow][i] == '*') rightArm++;
            else break;
        }

        // 허리
        int waist = 0;
        int waistEnd = heartRow;
        for (int i = heartRow + 1; i < n; i++) {
            if (arr[i][heartCol] == '*') {
                waist++;
                waistEnd = i;
            } else break;
        }

        // 왼다리
        int leftLeg = 0;
        if (heartCol - 1 >= 0) {
            for (int i = waistEnd + 1; i < n; i++) {
                if (arr[i][heartCol - 1] == '*') leftLeg++;
                else break;
            }
        }

        // 오른다리
        int rightLeg = 0;
        if (heartCol + 1 < n) {
            for (int i = waistEnd + 1; i < n; i++) {
                if (arr[i][heartCol + 1] == '*') rightLeg++;
                else break;
            }
        }

        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
