import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int K;
    static boolean[] isNotPrimeNum;

    static int idxCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
    }

    static void solve() {

        calcPrimeNum();
        idxCnt = 0;

        // K번 반복하면서 소수 탐색 
        while(K-->0) {
            // 숫자 증가시키면서 소수가 될때까지 반복 
            while(isNotPrimeNum[++idxCnt]) {}
        }
    }

    // 에라토스테네스의 채를 이용해 소수 판별
    static void calcPrimeNum() {
        isNotPrimeNum = new boolean[100_000_001];

        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;

        for(int i=2; i<=Math.sqrt(100_000_000); i++) {

            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<=100_000_000; j+=i) {
                isNotPrimeNum[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(idxCnt);
    }
}
