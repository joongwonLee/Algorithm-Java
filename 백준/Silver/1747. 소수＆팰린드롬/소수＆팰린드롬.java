import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    static boolean[] isNotPrimeNum;

    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }

    static void solve() {

        result = 0;
        calcPrimeNum();

        for(int i=N; i<=2_000_000; i++) {

            if(!isNotPrimeNum[i]&&isPalindrome(i)) {
                result = i;
                return;
            }
        }
    }

    // 에라토스테네스의 채를 이용해 소수 판별
    // 입력 데이터의 최대 수가 1,000,000이므로 적당히 큰 수 2,000,000까지 소수 판별 (만약 시간초과라면 값 줄이기)
    static void calcPrimeNum() {

        isNotPrimeNum = new boolean[2_000_001];

        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;

        for(int i=2; i<=Math.sqrt(2_000_001); i++) {

            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<=2_000_000; j+=i) {
                isNotPrimeNum[j] = true;
            }
        }
    }

    // 해당 수가 팰린드롬인지 판별
    static boolean isPalindrome(int num) {

        String strNum = String.valueOf(num);

        for(int i=0; i<strNum.length()/2; i++) {
            char first = strNum.charAt(i);
            char second = strNum.charAt(strNum.length()-1-i);

            if(first!=second) return false;
        }

        return true;
    }

    static void output() {
        System.out.println(result);
    }
}
