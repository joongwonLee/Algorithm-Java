import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int n, k;
    static int[] coins;

    static int[] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stn.nextToken());
        k = Integer.parseInt(stn.nextToken());

        coins = new int[n];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        // 동전을 여러 개 쓸 수 있으므로 -> 일반적인 1차원 dpTable로 해결
        dpTable = new int[k+1];
        dpTable[0] = 1;

        for(int i=0; i<coins.length; i++) {
            int coin = coins[i];
            for(int j=1; j<=k; j++) {
                if(j < coin) continue;
                dpTable[j] += dpTable[j-coin];
            }
        }
    }

    static void output() {
        System.out.println(dpTable[k]);
    }
}
