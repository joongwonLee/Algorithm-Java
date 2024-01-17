import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int N;
    static boolean[] isNotPrimeNum;

    static int[] resultArr;
    static int[] primeLink;

    static int nowColor;

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
        resultArr = new int[N+1];
        primeLink = new int[N+1];
        calcPrimeNum();

        nowColor = 1;
        resultArr[1] = nowColor;

        sb = new StringBuffer();
        sb.append(resultArr[1]+" ");

        if(N==1) return;

        for(int i=2; i<=N; i++) {

            // 소수일 때 -> 그냥 현재 컬러+1해서 대입
            if(!isNotPrimeNum[i]) {
                resultArr[i] = ++nowColor;
            } else { // 소수가 아닐 때, 소수의 배수인 소수의 컬러 그대로 대입
                resultArr[i] = resultArr[primeLink[i]];
            }

            sb.append(resultArr[i]+" ");
        }
    }

    // 에라토스테네스의 채를 이용해 소수 판별
    static void calcPrimeNum() {

        isNotPrimeNum = new boolean[N+1];

        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++) {

            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<=N; j+=i) {
                isNotPrimeNum[j] = true;
                primeLink[j] = i;
            }
        }
    }

    static void output() {
        System.out.println(nowColor);
        System.out.print(sb);
    }
}
