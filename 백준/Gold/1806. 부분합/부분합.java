import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, S;
    static int[] partitionSum;

    // 부분합을 탐색할 때 시작하는 인덱스
    static int startIdx;

    static int minLength;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        S = Integer.parseInt(stn.nextToken());

        partitionSum = new int[N];
        minLength = Integer.MAX_VALUE;
        startIdx = 0;

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(stn.nextToken());

            // 만약 입력값 자체가 S보다 크다면, 결과값은 1
            if(input>=S) {
                minLength = 1;
            }

            if(i==0) partitionSum[i] = input;
            else partitionSum[i] = partitionSum[i-1] + input;

            if(partitionSum[i]>=S) {
                minLength = Math.min(minLength, i+1);
            }

//            // 부분합이 S보다 큰 첫 시점을 startIdx로 잡음 -> 문제를 풀 때 이 시점부터 탐색 시작
//            if(startIdx==0 && partitionSum[i] >= S) startIdx = i;
        }
    }

    /**
     * 구하고자 하는 값(동일 혹은 그 이상)을 연속된 부분합 중 최소 개수로 구성
     *
     * 방법 1. i번째 부분합과 i-N번째 부분합의 차이를 구하면서 그 차이가 S 이상일 때 N을 구함 => 시간초과
     * 방법 2. 투포인터로 탐색하며 S보다 클 시점에 start와 end 포인트의 차이를 구함
     */
    static void solve() {
        if(minLength == 1) return;
        // 만약 부분합의 최댓값이 S보다 작다면 -> S를 만들 수 없으므로 결과값은 0
        if(partitionSum[N-1] < S) {
            minLength = 0;
            return;
        }

//        for(int i=1; i<N; i++) {
//
//            // startIdx 값이 정해지지 않는 경우는 partitionSum[N-1]이 S보다 작은 경우 -> return 되므로 값은 무조건 있는 상태
//            for(int j=startIdx; j<N; j++) {
//
//                if(j-i<0) continue;
//
//                if(partitionSum[j]-partitionSum[j-i] >= S) {
//                    minLength = i;
//                    return;
//                }
//            }
//        }

        int start = 0, end = 1;

        while(end<N) {

//            System.out.println("start:" + start+", end: "+end);
            int sum = partitionSum[end] - partitionSum[start];

            // end 인덱스의 부분합과 start 인덱스의 부분합의 차이가 S보다 크거나 같을 때
            if(sum >= S) {
                minLength = Math.min(minLength, end-start); // 결과값에 end-start(부분합 인덱스의 차이: 수열의 개수) 갱신
                start ++; // start + 1
            } else { // S보다 작을 때
                end ++; // end + 1
            }
        }

    }

    static void output() {
        System.out.println(minLength);
    }
}
