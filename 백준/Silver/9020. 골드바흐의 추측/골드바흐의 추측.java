import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int T, n;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        // n의 범위가 4~10000이므로, 한 번에 소수를 계산해 놓음
        isNotPrime = new boolean[10001];
        calc_prime_num(10000);

        for(int i=0; i<T; i++) {
            input();
            solve();
        }
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void solve() {

        // 골드바흐 파티션이 여러개일 경우, 두 소수의 차가 작은 수를 출력해야 하므로
        // 차이가 가장 작을 수 있는 n/2부터 탐색 
        for(int i=n/2; i>=2; i--) {

            if(!isNotPrime[i] && !isNotPrime[n-i]) {
                System.out.println(i+" "+(n-i));
                return;
            }
        }
    }

    // 에라스토테네스의 채를 이용한 소수 구하기
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
