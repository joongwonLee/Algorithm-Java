
import java.util.*;
import java.io.*;


/**
 * 로봇 청소기의 청소 단계
 *
 * 1. 현재 칸 청소 -> 실제 청소는 1단계에서만 함
 *
 * 2. 현재 칸 기준 사방의 칸이 모두 청소가 되어 있다면,
 *  2-1. 후진이 가능하면 후진 후 1단계로 이동
 *  2-2. 후진이 불가능하면(벽 땜에) 작동을 멈춤 -> 이 때까지 청소한 칸의 개수를 구하기
 *
 * 3. 현재 칸 기준 사방의 칸 중 청소가 안된 칸이 있다면,
 *  3-1. 반시계 방향으로 90도 회전 후, 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않았으면 1칸 전진 후 1단계로 이동
 *
 */
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static int r, c, d;
    static boolean[][] map;
    static boolean[][] isCleaned;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int numOfClean;

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

        stn = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stn.nextToken());
        c = Integer.parseInt(stn.nextToken());
        d = Integer.parseInt(stn.nextToken());

        map = new boolean[N][M];

        for(int r=0; r<N; r++) {
            stn = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                int a = Integer.parseInt(stn.nextToken());
                if(a == 1) map[r][c] = true;
            }
        }
    }

    static void solve() {

        numOfClean = 0;
        isCleaned = new boolean[N][M];

        while(true) {

            // step1. 현재 칸 청소
            if(!isCleaned[r][c]) {
                isCleaned[r][c] = true;
                numOfClean++;
            }


            // 사방향 모두 확인
            int num = 0; // 청소가 안 된 곳의 개수
            for(int i=0; i<dr.length; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(!map[nr][nc] && !isCleaned[nr][nc]) num++;
            }

            // step2. 사방이 모두 청소되어 있다면,
            if(num==0) {
                // 현재 방향 기준 후진한 칸이 이동할 수 있는 곳이라면,
                int br = r+dr[d];
                int bc = c+dc[d];
                if(!map[br][bc]) {
                    r = br;
                    c = bc;
                }
                else { // 후진 불가능이면 작동 종료
                    break;
                }
            }
            else { // step3. 사방 중 청소가 안된 곳이 있다면,
                // 반시계 방향으로 회전
                if(d==0) d=3;
                else d-=1;

                // 전진하는 칸:
                // d==0(북쪽), dr[2], dc[2]
                // d==1(동쪽), dr[3], dc[3]
                // d==2(남쪽), dr[0], dr[0]
                // d==3(서쪽), dr[1], dr[1]
                int fr = 0; int fc = 0;
                if(d<=1) {
                    fr = r+dr[d+2];
                    fc = c+dc[d+2];
                } else {
                    fr = r+dr[d-2];
                    fc = c+dc[d-2];
                }

                if(!map[fr][fc] && !isCleaned[fr][fc]) {
                    r = fr;
                    c = fc;
                }
            }
        }

    }

//    static boolean inRange(int r, int c) {
//        return r>=0 && r<N && c>=0 && c<M;
//    }

    static void output() {
        sb = new StringBuffer();
        sb.append(numOfClean);
        System.out.println(sb);
    }
}
