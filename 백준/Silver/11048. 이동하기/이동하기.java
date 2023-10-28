
import java.util.*;
import java.io.*;

// DFS로 접근하는 것 보다
// Memoization 접근 방식이 더 효율적 !
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static int[][] maze;
    static int[][] candySum;
    static boolean[][] isVisited;

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    static int maxCandyCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        maze = new int[N+1][M+1];
        candySum = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                maze[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
    }

    static void solve() {
//        isVisited = new boolean[N+1][M+1];
//        isVisited[1][1] = true;
//        maxCandyCnt = Integer.MIN_VALUE;
//        DFS(1,1,maze[1][1]);
        candySum[1][1] = maze[1][1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                candySum[i][j] = Math.max(maze[i][j]+candySum[i-1][j], maze[i][j]+candySum[i][j-1]);
//                candySum[i][j] = Math.max(candySum[i][j], maze[i][j]+maze[i-1][j-1]);
            }
        }
    }

//    static void DFS(int x, int y, int candy) {
//
//        if(x==N&&y==M) {
//            maxCandyCnt = Math.max(maxCandyCnt, candy);
//            return;
//        }
//
//        for(int i=0; i<dx.length; i++) {
//            int nx = x+dx[i];
//            int ny = y+dy[i];
//
//            if(inRange(nx, ny)&&!isVisited[nx][ny]) {
//                isVisited[nx][ny] = true;
//                DFS(nx, ny, candy+maze[nx][ny]);
//                isVisited[nx][ny] = false;
//            }
//        }
//    }
//
//    static boolean inRange(int x, int y) {
//        return x>=1&&x<=N&&y>=1&&y<=M;
//    }

    static void output() {

//        for(int i=1; i<=N; i++) {
//            for(int j=1; j<=M; j++) {
//                System.out.print(candySum[i][j]+" ");
//            }
//            System.out.println();
//        }

        sb = new StringBuffer();
        sb.append(candySum[N][M]);
        System.out.println(sb);
    }
}
