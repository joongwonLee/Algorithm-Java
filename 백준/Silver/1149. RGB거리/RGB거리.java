import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[][] rgbs;

    public static void main(String[] args) throws IOException  {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rgbs = new int[N][3];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(stn.nextToken());
            int g = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());

            rgbs[i][0] = r; rgbs[i][1] = g; rgbs[i][2] = b;
        }
    }

    /**
     * DP 풀이
     * 1. 재귀 -> 이렇게 꼭 풀어보기 
     * 2. 반복문 
     */
    static void solve() {

        for(int i=1; i<N; i++) {
            // r에 대한 최소 누적합 갱신
            rgbs[i][0] += Math.min(rgbs[i-1][1], rgbs[i-1][2]);
            // g에 대한 최소 누적합 갱신
            rgbs[i][1] += Math.min(rgbs[i-1][0], rgbs[i-1][2]);
            // b에 대한 최소 누적합 갱신
            rgbs[i][2] += Math.min(rgbs[i-1][0], rgbs[i-1][1]);
        }
    }

    static void output() {
        // 각 누적합에 대해 최솟값 출력 
        int minRGBValue = Math.min(Math.min(rgbs[N-1][0], rgbs[N-1][1]), rgbs[N-1][2]);
        System.out.println(minRGBValue);
    }
}