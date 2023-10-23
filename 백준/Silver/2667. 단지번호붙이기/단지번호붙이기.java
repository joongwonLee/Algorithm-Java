
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int N;
    static char[][] map;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    static boolean[][] isVisited;

    static int homeCnt;
    static ArrayList<Integer> homeCntList;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
    }

    static void solve() {
        isVisited = new boolean[N][N];
        homeCntList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]&&map[i][j]=='1') {
                    homeCnt = 1;
                    isVisited[i][j] = true;
                    DFS(i, j);
                    homeCntList.add(homeCnt);
                }
            }
        }
    }

    static void DFS(int x, int y) {

        for(int i=0; i<dx.length; i++) {
            int nx = x+dx[i]; int ny = y+dy[i];

            if(inRange(nx, ny)&&!isVisited[nx][ny]&&map[nx][ny]=='1') {
                isVisited[nx][ny] = true;
                homeCnt++;
                DFS(nx, ny);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    static void output() {
        Collections.sort(homeCntList);
        sb = new StringBuffer();

        sb.append(homeCntList.size()+"\n");
        for(int cnt: homeCntList) sb.append(cnt+"\n");

        System.out.println(sb);
    }
}
