import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int T, N;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        isNotPrime = new boolean[1_000_001];
        calc_prime_num(1_000_000);

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            input();
            solve();
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void solve() {

        int cnt = 0;

        for(int i=N/2; i>=2; i--) {
            // 두 나눠진 수가 소수일 경우 -> 카운트+1 (골드바흐의 파티션 생성)
            if(!isNotPrime[i] && !isNotPrime[N-i]) cnt++;
        }

        System.out.println(cnt);
    }

    // 에라스토텔레스의 채를 사용하여 소수 계산
    static void calc_prime_num(int n) {

        isNotPrime[0] = true; isNotPrime[1] = true;

        for(int i=2; i<=Math.sqrt(n); i++) {

            if(isNotPrime[i]) continue;

            for(int j=i*2; j<=n; j+=i) {
                isNotPrime[j] = true;
            }
        }
    }

}
