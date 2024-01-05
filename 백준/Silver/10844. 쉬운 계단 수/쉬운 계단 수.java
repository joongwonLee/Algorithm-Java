import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    static long[][] numOfLastDigit;
//    static Long[] numOfStairNumber;

    static long numOfStairNumber;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        /**
         * 끝자리 수에 어떤 수가 오는지 통계를 내는 것이 중요
         * numOfLastDigit[i][j]: i자리 수의 계단 수에 대해 끝에 j라는 수가 오는 수의 개수
         *      - i자리 계단수 중 끝자리가 j인 수의 개수 = i-1자리 계단수 중 끝자리가 j-1 혹은 j+1인 수의 개수의 합
         * numOfStairNumber[N]: N번째 자리의 계단수의 개수
         *      - N 자릿수의 계단수 개수 = (끝자리가 0 혹은 9인) N-1 자릿수의 계단수 개수 + (끝자리가 0 혹은 9가 아닌) N-1 자릿수의 계단수 개수*2
         */

        numOfLastDigit = new long[N+1][10];
//        numOfStairNumber = new Long[N+1];

        // 한 자릿수에 대해 미리 초기화
        // 0은 포함 x
        for(int i=1; i<10; i++) {
            numOfLastDigit[1][i] = 1L;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                // 끝자리 수가 0일 때 -> 이전 수의 끝자리 수가 1인 것만 반영
                if(j==0) numOfLastDigit[i][j] = numOfLastDigit[i-1][j+1]%1_000_000_000;
                // 끝자리 수가 9일 때 -> 이전 수의 끝자리 수가 8인 것만 반영
                else if(j==9) numOfLastDigit[i][j] = numOfLastDigit[i-1][j-1]%1_000_000_000;
                // 0과 9 이외의 수일 때 -> 이전 수의 끝자리 수 (j-1, j+1) 반영
                else numOfLastDigit[i][j] = (numOfLastDigit[i-1][j-1]+numOfLastDigit[i-1][j+1])%1_000_000_000;
            }
        }

        numOfStairNumber = 0L;

        for(int i=0; i<10; i++) {
            numOfStairNumber += numOfLastDigit[N][i];
        }

        numOfStairNumber%=1_000_000_000;

        System.out.println(numOfStairNumber);
    }

}
