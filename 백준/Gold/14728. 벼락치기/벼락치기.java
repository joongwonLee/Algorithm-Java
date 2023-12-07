import java.nio.Buffer;
import java.util.*;
import java.io.*;

// 평범한 배낭 문제와 거의 동일한 문제
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, T;
    static int[] timesPerChap;
    static int[] pointsPerChap;

    static int[] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        T = Integer.parseInt(stn.nextToken());

        timesPerChap = new int[N];
        pointsPerChap = new int[N];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(stn.nextToken());
            int S = Integer.parseInt(stn.nextToken());

            timesPerChap[i] = K;
            pointsPerChap[i] = S;
        }
    }

    static void solve() {
        dpTable = new int[T+1];


        for(int i=0; i<timesPerChap.length; i++) {
            int time = timesPerChap[i];
            int point = pointsPerChap[i];
            for(int j=T; j>=time; j--) {
                dpTable[j] = Math.max(dpTable[j], dpTable[j-time] + point);
            }
        }
    }

    static void output() {
        System.out.println(dpTable[T]);
    }
}
