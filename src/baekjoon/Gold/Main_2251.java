package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2251 {
    static int[] arr=new int[3];
    static boolean[] answer = new boolean[201];

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());



        for(int i=0; i<3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        bfs( );


        for(int i=0; i<201; i++) {
            if( answer[i]) System.out.print(i + " ");
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        //최대 200까지 가능
        boolean[][] visited= new boolean[201][201];
        //큐에는 a,b에 현재 물의 양을 추가
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        answer[arr[2]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a= current[0];
            int b =  current[1];
            int c=  arr[2] -a-b;

            //물통은 3개 이므로 중복일때를 제외하구 1~3 탐색
            for(int from =0; from<3; from++) {
                for(int to =0; to <3;  to ++) {
                    if ( from== to) continue;

                    int[] next = {a,b,c};
                    //현재 줄려는 물통의 물이나 받는곳에서 현재 받을수 잇는 물양중 적은거로 체크

                    int move = Math.min(next[from], arr[to]- next[to]);

                    next[from] -=move;
                    next[to] +=move;

                    if(!visited[next[0]][next[1]])  {
                        visited[next[0]][next[1]] = true;
                        queue.add(new int[] {next[0],next[1]});

                        if(next[0] ==0) {
                            answer[next[2]] = true;
                        }
                    }

                }
            }

        }




    }
}
