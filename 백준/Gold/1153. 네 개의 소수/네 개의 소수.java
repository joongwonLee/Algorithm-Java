import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static boolean[] isNotPrime;
    static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    /**
     * 골드바흐의 추측
     * 2보다 큰 짝수에 대해 짝수는 두 소수로 나눌 수 있다.
     *
     * 이를 이용해 어떠한 수를 네 개의 소수로 분해
     *
     * 1. 어떠한 수가 짝수일 경우
     *  1-1. '어떠한 수 - 4'는 짝수
     *  1-2. 어떠한 수는 (2, 2, (어떠한 수-4)를 나누는 소수1, (어떠한 수-4)를 나누는 소수2)로 나눌 수 있음
     *
     * 2. 어떠한 수가 홀수일 경우
     *  2-1. '어떠한 수 - 5'는 짝수
     *  2-2. 어떠한 수는 (2, 3, (어떠한 수-5)를 나누는 소수1, (어떠한 수-5)를 나누는 소수2)로 나눌 수 있음
     */
    static void solve() {

        isNotPrime = new boolean[N+1];
        calc_prime_number(N);

        result = new int[4];

        // 가장 작은 소수인 2가 4개 이루어져 있는 8보다 작은 경우 -> 분해 불가능 (-1)
        if(N<8) {
            System.out.println(-1);
            return;
        }
        // 짝수인 경우
        else if(N%2==0) {
            result[0] = 2; result[1] = 2;
            N-=4;
        }
        // 홀수인 경우
        else if(N%2!=0) {
            result[0] = 2; result[1] = 3;
            N-=5;
        }

        // 골드바흐의 추측에 의해 어떠한 짝수를 두 소수로 나눔
        for(int i=N/2; i>=2; i--) {
            if(!isNotPrime[i] && !isNotPrime[N-i]) {
                result[2] = i;
                result[3] = N-i;
            }
        }

        for(int prime: result) {
            System.out.print(prime+" ");
        }
    }

    // 에라토스테네스의 채를 이용해 소수 구하기
    static void calc_prime_number(int N) {

        isNotPrime[0] = true; isNotPrime[1] = true;

        if(N==1) return;

        for(int i=2; i<=Math.sqrt(N); i++) {

            if(isNotPrime[i]) continue;

            for(int j=i*2; j<=N; j+=i) {
                isNotPrime[j] = true;
            }
        }
    }

//    // 소수를 구한 후에 조합을 이용 -> 시간 초과
//    static void comb(int cnt, int start, int[] prime_nums, int sum_of_prime_num) {
//
//        if(cnt == 4) {
//
//            if(sum_of_prime_num==N) {
//                canDivide = true;
//                for(int prime_num: prime_nums) {
//                    System.out.print(prime_num+" ");
//                }
//                System.out.println();
//            }
//            return;
//        }
//
//        if(canDivide) return;
//
//        // N-6으로 둔 이유는 네 개의 수의 합을 구해야 하기 때문에
//        // (2,2,2,?)라고 했을 때 ?이 최대 N-6까지 올 수 있기 때문
//        for(int i=N-6; i>=0; i--) {
//
////            if(sum_of_prime_num+i > N) return;
//
//            if(!isNotPrime[i]) {
//                prime_nums[cnt] = i;
//                comb(cnt+1, i, prime_nums, sum_of_prime_num+i);
//            }
//        }
//    }

}
