package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String n = br.readLine();

            if (n.equals("end")) {
                break;
            }


            char[] board = new char[9];
            int Xcount = 0;
            int Ocount = 0;
            for (int i = 0; i < 9; i++) {
                board[i] = n.charAt(i);

                if (board[i] == 'X') {
                    Xcount++;
                } else if (board[i] == 'O') {
                    Ocount++;
                }


            }
            int num = Xcount - Ocount;
            if (Xcount < Ocount || num > 1) {

                System.out.println("invalid");
                continue;
            }

            char X = 'X';
            char O = 'O';

            if (check(board, X) && check(board, O)) {
                System.out.println("invalid");
                continue;

            }

            if (check(board, X)) {

                if (Xcount == Ocount + 1) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
                continue;
            }
            if (check(board, O)) {
                if (Xcount == Ocount) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
                continue;

            }
            if (Xcount + Ocount == 9) {

                System.out.println("valid");
            } else {
                System.out.println("invalid");

            }
        }

    }


    private static boolean check(char[] board, char X) {
        int[][] wins = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] win : wins) {

            if (board[win[0]] == X &&
                    board[win[1]] == X &&
                    board[win[2]] == X

            ) {
                return true;
            }

        }

        return false;
    }
}
