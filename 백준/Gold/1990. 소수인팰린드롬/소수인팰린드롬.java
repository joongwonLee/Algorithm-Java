import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int a,b;

    static boolean[] isNotPrimeNum;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        a = Integer.parseInt(stn.nextToken());
        b = Integer.parseInt(stn.nextToken());
    }

    static void solve() {

        isNotPrimeNum = new boolean[b+1];
        calc_prime_num(b);

        // a부터 b까지 모든 수를 순회
        for(int i=a; i<=b; i++) {

            // 만약 해당 수가 소수라면
            if(!isNotPrimeNum[i]) {

                char[] numCharSet = String.valueOf(i).toCharArray();
                boolean isPalin = true;

                // 팰린드롬 수인지 판별 
                for(int j=0; j<numCharSet.length/2; j++) {
                    if(numCharSet[j]!=numCharSet[numCharSet.length-1-j]) isPalin = false;
                }

                if(isPalin) System.out.println(i);
            }
        }
    }

    // 에라스토텔레스의 채를 통해 소수 거르기
    static void calc_prime_num(int N) {

        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++) {
            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<=N; j+=i) {
                isNotPrimeNum[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(-1);
    }
}
