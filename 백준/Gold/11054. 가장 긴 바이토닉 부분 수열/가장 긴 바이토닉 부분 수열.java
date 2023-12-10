import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] sequences;
    static int[] revSequences;

    static int[] increaseDpTable;
    static int[] revIncreaseDpTable;

    static int maxBitonicLen;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sequences = new int[N+1];
        revSequences = new int[N+1];
        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int input = Integer.parseInt(stn.nextToken());
            sequences[i] = input;
            revSequences[N-i+1] = input;
        }
    }

    /**
     * 증가하는 가장 긴 부분 수열의 길이 (LTS) 로직을 이용
     *
     * 1. 순차적으로 증가하는 부분 수열의 길이를 dp로 계산
     * 2. 역순으로 증가하는 부분 수열의 길이를 dp로 계산
     * 3. 각 인덱스 별 dp 테이블의 합의 최댓값이 곧 결과값
     *  3-1. 역순으로 증가하는 부분 수열이 곧 순차적으로 감소하는 부분 수열의 길이이기 때문
     */
    static void solve() {

        increaseDpTable = new int[N+1];
        revIncreaseDpTable = new int[N+1];

        for(int i=1; i<=N; i++) {

            increaseDpTable[i] = 1;
            revIncreaseDpTable[i] = 1;

            for(int j=1; j<i; j++) {

                // dp 방식의 최장 증가 부분 수열 계산
                // 순차적으로 증가하는 dpTable 갱신
                if(sequences[i] > sequences[j] && increaseDpTable[i] < increaseDpTable[j]+1) {
                    increaseDpTable[i] = increaseDpTable[j]+1;
                }

                // 역순으로 증가하는 dpTable 갱신
                if(revSequences[i] > revSequences[j] && revIncreaseDpTable[i] < revIncreaseDpTable[j]+1) {
                    revIncreaseDpTable[i] = revIncreaseDpTable[j]+1;
                }
            }
        }

        maxBitonicLen = 0;

        for(int i=1; i<=N; i++) {
            // 순차적으로 증가하는 수열의 dpTable과 역순으로 증가하는 수열(= 순차적으로 감소하는 수열)의 dpTable의 합의 최댓값 계산
            maxBitonicLen = Math.max(maxBitonicLen, increaseDpTable[i]+revIncreaseDpTable[N-i+1]);
        }
    }

    static void output() {
        System.out.println(maxBitonicLen-1);
    }
}
