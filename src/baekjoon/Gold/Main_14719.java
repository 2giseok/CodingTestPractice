package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m  =Integer.parseInt(st.nextToken());
        int[][] board= new int[n][m];


            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int a=  Integer.parseInt(st.nextToken());
                for(int i=0; i<a; i++) {
                    board[i][j] = 1;
                }
            }

            int sum = 0;
            int len = 0;
            for(int i=0; i <n; i++) {
                int count = 0;
                for(int j=0; j<m; j++) {
                    if( board[i][j] ==1) {
                        count ++;

                        if(count >=2) {
                            for(int q= len; q<j; q++  ){
                                if( board[i][q] ==0) {
                                    board[i][q] = 1;
                                    sum++;
                                }
                            }

                        }
                        len = j;
                    }
                }
            }

            System.out.println(sum);
        }

    }

