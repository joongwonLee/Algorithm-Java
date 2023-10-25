
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int M, N;
    static int[][] box;
    static Stack<int[]> stack;
    static ArrayList<int[]> ripedTomatoList;
    static Queue<int[]> queue;

    static boolean[][] isVisited;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    static int day;

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

        isVisited = new boolean[N][M];
        queue = new LinkedList<>();

        box = new int[N][M];
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(stn.nextToken());
                if(box[i][j]==1) {
                    isVisited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }
    }

    static void solve() {

        int size;

        while(true) {
            size = queue.size();
            for(int i=0; i<size; i++) {
                int[] now = queue.poll();
                ripe(now[0], now[1]);
            }
            if(queue.isEmpty()) break;
            day++;
        }
    }

    static void ripe(int x, int y) {
        for(int i=0; i<dx.length; i++) {
            int nx = x+dx[i]; int ny = y+dy[i];
            if(inRange(nx, ny)&&!isVisited[nx][ny]&&box[nx][ny]==0) {
                isVisited[nx][ny] = true;
                box[nx][ny] = 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }


    static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static boolean allRipe() {

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j]==0) {
                    return true;
                }
            }
        }
        return false;
    }


    static void output() {

        sb = new StringBuffer();
        if(allRipe()) sb.append(-1);
        else sb.append(day);
        System.out.println(sb);
    }
}
