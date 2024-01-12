import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static boolean[] isNotPrimeNum;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void solve() {
        // 에라스토테네스의 채를 이용해 소수 판별
//        calcPrimeNum();
        // N자리 수의 (소수) 규칙을 가진 수 뽑아내기
        perm(0, "");
    }

    // N글자의 (소수)규칙을 가진 수를 순열으로 계산
    static void perm(int cnt, String primeStr) {

        // N글자를 뽑아내면 해당 수를 출력하고 리턴
        if(cnt==N) {

            System.out.println(primeStr);
            return;
        }

        // 첫자리 수는 2도 포함이 가능하므로 1부터 9까지 순회
        if(cnt==0) {
            for(int i=1; i<=9; i++) {
                int num = Integer.parseInt(primeStr+String.valueOf(i));
                // 소수 판별 후 소수라면 다음 자릿수를 위한 함수 재귀 호출
                if(isPrimeNum(num)) {
                    perm(cnt+1, String.valueOf(num));
                }
            }
        }
        // 두번째 자리부터는 홀수만 체크
        else {
            for(int i=1; i<=9; i+=2) {
                int num = Integer.parseInt(primeStr+String.valueOf(i));
                // 소수 판별 후 소수라면 다음 자릿수를 위한 함수 재귀 호출
                if(isPrimeNum(num)) {
                    perm(cnt+1, String.valueOf(num));
                }
            }
        }
    }

    // 메모리 초과(4MB)라 수를 입력 받으면 소수인지 아닌지 리턴하는 함수 사용
    static boolean isPrimeNum(int N) {

        if(N==1) return false;
        if(N==2||N==3) return true;

        // 제곱근이 될 수 있는 후보 순회
        // x^2가 될 수 있는 x까지 순회
        for(int i=2; i<=Math.sqrt(N); i++) {
            if(N%i==0) return false; // 나눠지면 소수가 x
        }

        return true;
    }

    // 에라스토테네스의 채를 이용해 소수 판별
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
}
