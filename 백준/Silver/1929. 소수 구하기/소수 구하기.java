import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stn.nextToken());
        N = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        isNotPrime = new boolean[N+1];
        calc_prime_number(N);

        for(int i=M; i<=N; i++) {
            if(!isNotPrime[i]) System.out.println(i);
        }
    }

    /**
     * 에라토스테네스의 체를 이용한 소수 구하기
     * k = 2부터 N의 제곱근까지 반복하며 k를 제외한 k의 배수를 소수에서 제외시킴
     */
    static void calc_prime_number(int N) {

        // 0과 1은 소수가 x
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 데이터의 최솟값인 1이 들어오면 판별 x
        if(N==1) return;

        // 2부터 N의 제곱근까지 순회
        for(int i=2; i<=Math.sqrt(N); i++) {

            if(isNotPrime[i]) continue;

            // 각 배수를 모두 소수가 아님으로 표시
            for(int j=i*2; j<=N; j+=i) {

                isNotPrime[j] = true;
            }
        }
    }
}
