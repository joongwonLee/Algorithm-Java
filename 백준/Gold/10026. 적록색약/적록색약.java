
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int N;
    static char[][] map;

    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    static int noColorWeakCnt, colorWeakCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        noColorWeakCnt = 0; colorWeakCnt = 0;

        for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
    }

    static void solve() {
        isVisited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i,j);
                    noColorWeakCnt++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]=='G') map[i][j] = 'R';
            }
        }

        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i,j);
                    colorWeakCnt++;
                }
            }
        }
    }

    static void dfs(int x, int y) {

        for(int i=0; i<dx.length; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(inRange(nx, ny)&&!isVisited[nx][ny]&&map[x][y]==map[nx][ny]) {
                isVisited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(noColorWeakCnt+" "+colorWeakCnt);
        System.out.println(sb);
    }
}
