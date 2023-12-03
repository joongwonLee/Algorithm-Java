import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int r1, c1, r2, c2;

    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    static Queue<int[]> queue;
    static int[][] visitedDepth;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stn = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(stn.nextToken());
        c1 = Integer.parseInt(stn.nextToken());
        r2 = Integer.parseInt(stn.nextToken());
        c2 = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        bfs(r1, c1);
    }

    static void bfs(int r, int c) {

        queue = new LinkedList<>();
        visitedDepth = new int[N][N];
        visitedDepth[r][c] = 1; // 방문체크 여부를 체크하기 위해 1에서 시작 (int형 배열은 0으로 초기화되므로)

        queue.add(new int[]{r,c});

        while(!queue.isEmpty()) {

            int[] now = queue.poll();

            for(int i=0; i<dr.length; i++) {
                int nextR = now[0]+dr[i];
                int nextC = now[1]+dc[i];
                
                if(nextR==r2&&nextC==c2) {
                	visitedDepth[r2][c2] = visitedDepth[now[0]][now[1]] + 1;
                	return;
                }

                if(inRange(nextR, nextC)&&visitedDepth[nextR][nextC]==0) {
                    visitedDepth[nextR][nextC] = visitedDepth[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0&&r<N&&c>=0&&c<N;
    }

    static void output() {
        System.out.println(visitedDepth[r2][c2]-1);
    }
}
