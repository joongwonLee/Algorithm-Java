import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int M, N;
    static boolean[][] isChar;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean[][] isVisited;
    static Stack<int[]> stk;

    static int numOfChar;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stn.nextToken());
        N = Integer.parseInt(stn.nextToken());

        isChar = new boolean[M][N];

        for(int i=0; i<M; i++) {

            stn = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                int ipt = Integer.parseInt(stn.nextToken());
                if(ipt==1) isChar[i][j] = true;
            }
        }
    }

    static void solve() {
        numOfChar = 0;
        isVisited = new boolean[M][N];

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                // 글자인 곳이고, 방문하지 않은 곳일 경우 -> dfs 탐색
                // dfs 탐색을 하는 횟수가 글자의 개수
                if(isChar[i][j]&&!isVisited[i][j]) {
                    dfs(i, j);
                    numOfChar ++;
                }
            }
        }
    }

    static void dfs(int startX, int startY) {

        stk = new Stack<>();
        stk.push(new int[]{startX, startY});

        isVisited[startX][startY] = true;

        while(!stk.isEmpty()) {

            int[] now = stk.pop();

            for(int i=0; i<dx.length; i++) {
                int nextX = now[0]+dx[i];
                int nextY = now[1]+dy[i];

                if(inRange(nextX, nextY) && !isVisited[nextX][nextY] && isChar[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    stk.push(new int[]{nextX, nextY});
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<M && y>=0 && y<N;
    }

    static void output() {
        System.out.println(numOfChar);
    }
}
