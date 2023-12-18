
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    static boolean[] isNotPrime;

    // 소수들의 연속 부분합을 저장하는 배열
    static ArrayList<Integer> contPartSum;

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
        isNotPrime = new boolean[N+1];
        calc_prime_num(N);

        contPartSum = new ArrayList<>();
        contPartSum.add(2);

        // 에라토스테네스의 채로 구한 소수들의 연속 부분합을 arraylist에 저장
        for(int i=3; i<=N; i++) {
            if(!isNotPrime[i]) {
                int prevSum = contPartSum.get(contPartSum.size()-1);
                contPartSum.add(prevSum+i);
            }
        }

        result = 0; // 결과값을 저장하는 result 변수

        for(int sum: contPartSum) {
//            System.out.print(sum+" ");
            if(sum==N) result++;
        }

        // 투포인터를 활용해 연속된 부분합 중 N을 만족하는 값을 찾음
        int start = 0; int end = 1;
        while(end<contPartSum.size()) {

            int sum = contPartSum.get(end) - contPartSum.get(start);

            if(sum>=N) {
                if(sum==N) result++;
                start++;
            } else {
                end++;
            }
        }
    }

    // 에라토스테네스의 채를 이용해 소수 구하기
    static void calc_prime_num(int N) {

        isNotPrime[0] = true; isNotPrime[1] = true;

        if(N==1) return;

        for(int i=2; i<=Math.sqrt(N); i++) {

            if(isNotPrime[i]) continue;

            for(int j=i*2; j<=N; j+=i) {
                isNotPrime[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(result);
    }

}
