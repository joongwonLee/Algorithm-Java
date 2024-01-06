
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static long p, mod, a;

//    static boolean[] isNotPrineNum;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

//        calcPrimeNum();

        while(true) {

            stn = new StringTokenizer(br.readLine());
            p = Integer.parseInt(stn.nextToken());
            a = Long.parseLong(stn.nextToken());

            // 나눌 나머지를 mod에 저장
            // 함수 재귀 호출 시, p는 값이 변하기 때문에 초기 p 값을 가지고 있는 mod 변수 선언
            mod = p;

            if(p==0&&a==0) break;

            if(isPrimeNum(p)) {
                sb.append("no"+"\n");
                continue;
            }

            if(powAndDivide(a, p)==a) {
                sb.append("yes"+"\n");
            } else {
                sb.append("no"+"\n");
            }

        }

        System.out.println(sb);
    }

    /**
     * 분할 정복을 통해 a의 p 거듭제곱과 a로 나눈 나머지 계산
     * 점화식
     * p==0일 때, 1
     * p==짝수일 때, p/2 거듭제곱 * p/2 거듭제곱
     * p==홀수일 때, p/2 거듭제곱 * p/2 거듭제곱 * a
     */
    static long powAndDivide(long a, long p) {

        // 지수가 0일 때 1 리턴
        if(p==0) {
            return 1L;
        }
        // 지수가 1일 때 a 리턴
        else if(p==1) {
            return a;
        }
        // 지수가 짝수일 때 p/2 거듭제곱 * p/2 거듭제곱
        else if(p%2==0) {
            long ll = (powAndDivide(a, p/2)%mod);
            return ll*ll%mod;
        }
        // 지수가 홀수일 때 p-1 거듭제곱 * a
        else if(p%2!=0) {
            return (a*powAndDivide(a, p-1)%mod)%mod;
        }

        return -1L;
    }

    static boolean isPrimeNum(long num) {

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }

//    static void calcPrimeNum() {
//
//        isNotPrineNum = new boolean[1_000_000_001];
//
//        isNotPrineNum[0] = true; isNotPrineNum[1] = true;
//
//        for(int i=2; i<=Math.sqrt(1_000_000_000); i++) {
//
//            if(isNotPrineNum[i]) continue;
//            for(int j=2*i; j<=1_000_000_000; j+=i) {
//                isNotPrineNum[j] = true;
//            }
//        }
//    }
}
