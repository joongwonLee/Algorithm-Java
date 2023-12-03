import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T, N;
    static ArrayList<Integer> coins;
    static int price;

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

        coins = new ArrayList<>();

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int coin = Integer.parseInt(stn.nextToken());
            coins.add(coin);
        }

        price = Integer.parseInt(br.readLine());
    }

    static void solve() {
        dpTable = new int[price+1];
        /**
         * dpTable[0]을 1로 초기화하는 이유: dpTable를 갱신하는 방식이 이전 dpTable을 참고하기 때문
         */
        dpTable[0] = 1;

        for(int coin: coins) {

            for(int i=1; i<=price; i++) {
                if(i<coin) continue;
                dpTable[i] += dpTable[i-coin];
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(dpTable[price]);
        System.out.println(sb);
    }
}
