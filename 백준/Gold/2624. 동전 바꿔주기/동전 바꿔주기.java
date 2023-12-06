import java.util.*;
import java.io.*;

/**
 * 동전의 갯수가 정해져 있는 문제 => 2차원 dp 풀이
 */
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int T, K; // T: 지폐의 금액, K: 동전의 가지 수

    static ArrayList<int[]> coinInfo; // 동전 금액과 개수 저장
    static int[][] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        coinInfo = new ArrayList<>();

        for(int i=0; i<K; i++) {
            stn = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(stn.nextToken());
            int count = Integer.parseInt(stn.nextToken());

            coinInfo.add(new int[] {price, count});
        }

        coinInfo.add(new int[]{0,0});
    }

    static void solve() {
        /**
         * dp[N번 동전][현재 금액] += dp[N-1번 동전][현재 금액-(N번 동전 금액 * 0~N번 동전 개수)]
         */
        dpTable = new int[K+1][T+1];

        coinInfo.sort(Comparator.comparingInt(c -> c[0]));

        for(int i=0; i<=K; i++) dpTable[i][0] = 1;

        for(int i=1; i<=K; i++) {

            int price = coinInfo.get(i)[0];
            int count = coinInfo.get(i)[1];

            for(int cost = 1; cost <= T; cost++) {
                for(int cnt = 0; cnt <= count; cnt++) {
                    if(cost - (price*cnt) < 0) break;
                    dpTable[i][cost] += dpTable[i-1][cost - (price * cnt)];
                }
            }
        }
    }

    static void output() {
        System.out.println(dpTable[K][T]);
    }
}
