import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int R,C;
    static char[][] map;

    static int[][] isVisited;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int treasureDist;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    /**
     * 1. map의 모든 land에 대해 BFS 탐색
     *  1-1. isVisited 체크는 depth(int)로
     * 2. map의 모든 isVisited를 탐색하면서 최댓값 출력 -> 보물 사이의 최단 거리: 두 land 사이의 최장 거리
     */
    static void solve() {

        treasureDist = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='L') {
                    BFS(i, j);
                }
            }
        }
    }

    static void BFS(int startR, int startC) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});

        isVisited = new int[R][C];
        for(int i=0; i<R; i++) Arrays.fill(isVisited[i], -1);
        isVisited[startR][startC] = 0;

        while(!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];

            for(int i=0; i<4; i++) {
                int nextR = nowR+dr[i];
                int nextC = nowC+dc[i];

                if(inRange(nextR, nextC)&&map[nextR][nextC]=='L'&&isVisited[nextR][nextC]==-1) {
                    isVisited[nextR][nextC] = isVisited[nowR][nowC]+1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }

        // 두 land 사이의 거리에 대해 최장 거리 갱신
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                treasureDist = Math.max(treasureDist, isVisited[i][j]);
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C;
    }

    static void output() {
        System.out.println(treasureDist);
    }
}
