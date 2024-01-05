import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] numOfArr;

    static int minOfCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numOfArr = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numOfArr[i] = Integer.parseInt(stn.nextToken());
        }
    }

    /**
     * 주어진 배열에서 [0,0,...]인 배열까지 거꾸로 연산
     * 1. 주어진 배열의 모든 원소가 짝수이면 모든 원소 나누기 2
     * 2. 모든 원소가 짝수가 아니면 홀수인 원소 중 하나를 -1 
     * 3. while문 돌면서 모든 원소가 0일때까지 (1~2번 반복)
     */
    static void solve() {

        minOfCnt = 0;

        // 모든 원소가 0인 배열이 될 때까지 순회
        while(!isAllZero(numOfArr)) {

            minOfCnt ++;

            // 1. 모든 원소가 짝수일 떄
            if (isAllEven(numOfArr)) {
                // 모든 원소 나누기 2
                for(int i=0; i<numOfArr.length; i++) {
                    numOfArr[i] /= 2;
                }
            } else { // 2. 원소 중 홀수가 있을 때
                // 홀수인 원소 중 한개를 -1 
                for(int i=0; i<numOfArr.length; i++) {
                    if(numOfArr[i]%2!=0) {
                        numOfArr[i]-=1;
                        break;
                    }
                }
            }
        }
    }

    // 모든 원소가 0인지 판별하는 함수
    static boolean isAllZero(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) return false;
        }

        return true;
    }

    // 모든 원소가 짝수인지 판별하는 함수
    static boolean isAllEven(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%2!=0) return false;
        }

        return true;
    }

    static void output() {
        System.out.println(minOfCnt);
    }
}
