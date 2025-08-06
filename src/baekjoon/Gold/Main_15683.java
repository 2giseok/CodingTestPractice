package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV {
    int x,y, type;
    CCTV(int y, int x, int type) {
        this.y=y;
        this.x = x;

        this.type=type;
    }

}

public class Main_15683 {
    static  int[][] map;
    static  int n,m;
    static List<CCTV> cctvs=  new ArrayList<>();
    static  int[] dx= {0,1,0,-1};
    static  int[] dy = {1,0,-1,0};
    static  int sum = Integer.MAX_VALUE;

    static  int[][][] diretions = {
            {},
            {{0},{1},{2},{3}},
            {{0,2},{1,3}},
            {{0,1},{1,2},{2,3},{3,0}},
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
            {{0,1,2,3}}
    };
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         n =Integer.parseInt(st.nextToken());
          m =Integer.parseInt(st.nextToken());

          map = new int[n][m];

          for(int i=0; i<n; i++) {
              st= new StringTokenizer(br.readLine());
              for(int j=0; j<m; j++) {
                  map[i][j]=Integer.parseInt(st.nextToken());
                  if(1 <=map[i][j] && map[i][j] <6) {
                      cctvs.add(new CCTV(i,j ,map[i][j]));

                  }

              }
          }

          dfs(0,map);


System.out.println(sum);
    }

    private static void dfs(int depth, int[][] map) {
       //꽉차면 min사용해서 값 구하기
        if ( depth == cctvs.size()) {
            sum = Math.min(sum, count(map));

            return ;
        }

        CCTV cctv=cctvs.get(depth);
        int type=  cctv.type;


        for(int [] dirs : diretions[type]) {
            int[][] copy = copymap(map);

            for(int dir : dirs) {
            scan(copy,cctv.y,cctv.x, dir);


        }

        dfs(depth+1, copy);

}


    }

    private static int count(int[][] map) {
        int count = 0;
        for(int i=0; i<n;i ++) {
          
            for(int j=0; j<m; j++) {


                if (map[i][j] ==0) count ++;

            }
        }

        return count;
    }

    private static void scan(int[][] board, int y, int x, int dir) {

        int nx =  x +dx[dir];
        int ny = y +dy[dir];

        while (0<=ny && ny <n && 0<=nx && nx < m ) {

            if(board[ny][nx] ==6) break;

            if(board[ny][nx] ==0) board[ny][nx] = -1;
            nx +=dx[dir];
            ny += dy[dir];
        }
    }

    private static int[][] copymap(int[][] map) {

        int[][] dest = new int[n][m];

        for(int i=0; i<n; i++) {
            dest[i] = map[i].clone();
        }

        return dest;
    }
}
