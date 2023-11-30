
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T, N, M;
    static int[] coins;
    static int[] dpTable;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N];

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int coin = Integer.parseInt(stn.nextToken());
            coins[i] = coin;
        }

        // M: 총 금액 1<=M<=10000
        M = Integer.parseInt(br.readLine());
        // 1원부터 M원까지 가짓수를 저장하는 dp 테이블 생성
        dpTable = new int[M+1];
    }

    static void solve() {

        // 조건 체크: M이 1이면 dpTable[1] 갱신 후 바로 return
        if(M==1) {
            if(coins[0]==1) dpTable[1] = 1;
            else dpTable[1] = 0;
            return;
        }

        // dp 점화식 다시 한 번 보기!! 
        dpTable[0] = 1;
        for(int coin: coins) {
            for(int i=coin; i<=M; i++) {
                dpTable[i] += dpTable[i-coin];
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(dpTable[M]);

        System.out.println(sb);
    }
}
