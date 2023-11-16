
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int R,C;
    static char[][] map;

    static ArrayList<int[]> wolvies;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] isVisited;

    static int totalSheepCnt;
    static int totalWolfCnt;

    static int livingSheepCnt;
    static int livingWolfCnt;

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

    static void solve() {

        totalSheepCnt = 0;
        totalWolfCnt = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='o') totalSheepCnt++;
                else if(map[i][j]=='v') totalWolfCnt++;
            }
        }

        isVisited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!isVisited[i][j]&&map[i][j]=='v') {
                    BFS(i, j);
                }
            }
        }
    }

    static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList();
        isVisited[x][y] = true;
        queue.add(new int[]{x, y});

        int sheepCnt = 0;
        int wolfCnt = 1;

        while(!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];

                if(inRange(nextX, nextY)&&!isVisited[nextX][nextY]&&map[nextX][nextY]!='#') {
                    if(map[nextX][nextY]=='o') sheepCnt++;
                    else if(map[nextX][nextY]=='v') wolfCnt++;
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

        if(sheepCnt > wolfCnt) totalWolfCnt -= wolfCnt;
        else totalSheepCnt -= sheepCnt;
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<R && y>=0 && y<C;
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(totalSheepCnt+" "+totalWolfCnt);
        System.out.println(sb);
    }
}
