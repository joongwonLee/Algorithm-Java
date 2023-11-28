import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] cardPacks;

    static int[] minPrices;
    static int minTotalPrice;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stn = new StringTokenizer(br.readLine());
        cardPacks = new int[N+1];

        for(int i=1; i<=N; i++) {
            cardPacks[i] = Integer.parseInt(stn.nextToken());
        }

    }

    static void solve() {
        minTotalPrice = Integer.MAX_VALUE;

        // dp를 위한 함수 초기화
        minPrices = new int[N+1];
        for(int i=1; i<=N; i++) minPrices[i] = Integer.MAX_VALUE;
        minPrices[1] = cardPacks[1];

        // N==1일때는 체크 필요 x, 바로 return
        if(N==1) return;

        // i개를 살 때 최소 비용을 계산 
        for(int i=2; i<=N; i++) {
            // 처음 i개 팩을 산 값으로 초기화 
            minPrices[i] = cardPacks[i];
            for(int j=1; j<=i-1; j++) {
                // j개 산 최소 비용 + i-j개 팩 값의 최솟값을 갱신하며 dp 테이블 저장 
                minPrices[i] = Math.min(minPrices[j]+cardPacks[i-j], minPrices[i]);
            }
        }

    }

    static void output() {
        minTotalPrice = minPrices[N];
        System.out.println(minTotalPrice);
    }
}
