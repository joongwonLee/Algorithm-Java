
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static long start, end;
    static boolean[] isNotPrimeNum;

    static int numOfAlmostPrime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        start = Long.parseLong(stn.nextToken());
        end = Long.parseLong(stn.nextToken());
    }

    /**
     * 1. 가장 작은 소수 2를 기준으로 범위의 끝까지 최대 몇 제곱 수를 적용할 수 있는지 확인
     * 2. 최대 제곱 수까지 반복하면서 (2~마지막 범위 수의 제곱근 수)까지 순회하며 '거의 소수'를 판별
     *  2-1. 반복수가 소수인지 체크
     *  2-2. 반복수의 제곱근이 start와 end 사이의 범위인지 체크
     */
    static void solve() {

        calcPrimeNum();

//        // 1. 최대 몇 제곱의 수까지 구해야 하는지
//        // 소수 중 가장 작은 2를 기준으로 end 보다 작은 2의 제곱 수 중 가장 큰 값이 몇 제곱인지 계산
//        int numOfIter = 2;
//        for(int i=2; i<end; i++) {
//            if(Math.pow(2, i)>end) {
//                numOfIter = i-1;
//                break;
//            }
//        }

        // 2. 2제곱부터 최대 제곱까지 반복
        for(int i=2; i<=Math.sqrt(end); i++) {

//            // 2-1. 최대 범위 수의 i 제곱근 계산
//            int powNum = (int)(Math.pow(end, (1.0/(double)i)));

            // 2-2. 2부터 최대 제곱근 수까지 반복
//            for(int j=2; j<=powNum; j++) {
            for(int j=2; j<=Math.log(end)/Math.log(i); j++) {
                // 이 문제의 핵심은 almostPrimeHubo의 오버플로우를 막는 것

                // 거의 소수 후보 체크
                long almostPrimeHubo = (long)Math.pow(i, j);

                if(!isNotPrimeNum[i]&&almostPrimeHubo>=start&&almostPrimeHubo<=end) {
//                    System.out.println(almostPrimeHubo);
                    numOfAlmostPrime++;
                }
            }
        }
    }

    static void calcPrimeNum() {

        // 마지막 수의 제곱근까지만 소수 판별
        int maxSize = (int)(Math.sqrt(end))+1;
        isNotPrimeNum = new boolean[maxSize];

        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;

        for(int i=2; i<maxSize; i++) {

            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<maxSize; j+=i) {
                isNotPrimeNum[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(numOfAlmostPrime);
    }
}
