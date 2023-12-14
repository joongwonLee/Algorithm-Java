import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] solutions;

    static int closeZero;
    static int minDiff;
    static int result1, result2;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        solutions = new int[N];

        // 0이랑 가장 가까운 수의 인덱스
        closeZero = 0;

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(stn.nextToken());
            solutions[i] = input;
            if(Math.abs(solutions[closeZero]) >= Math.abs(solutions[i])) closeZero = i;
        }
    }

    /**
     * 투포인터 비스무리하게 푼 것 같긴한데
     * 많이 이상한 코드 ,,,
     * 
     * 0과 가장 가까운 데이터부터 시작해서 start -> 0, end -> n-1로 수렴하는 방식 (투포인터??)
     */
    static void solve() {

        if(N==2) {
            result1 = solutions[0];
            result2 = solutions[1];
            return;
        }

        int start = 0; int end = 0;

        if(closeZero==0) {
            start = closeZero; end = closeZero+1;
        } else {
            start = closeZero-1; end = closeZero;
        }

        minDiff = Integer.MAX_VALUE;

        while(!(start<0 && end>N-1)) {

//            System.out.println("start: "+start+", end: "+end+", value: "+Math.abs(solutions[start]-solutions[end]));
            if(Math.abs(solutions[start]+solutions[end]) < minDiff) {
                result1 = solutions[start];
                result2 = solutions[end];

                minDiff = Math.abs(solutions[start]+solutions[end]);
            }

            if(start==0 && end<N-1) end++;
            else if(start>0 && end==N-1) start--;
            else if(start==0 && end==N-1) break;
//            if(Math.abs(solutions[start-1]) < Math.abs(solutions[end+1])) start--;
//            else end++;
            else if(Math.abs(solutions[start-1]) < Math.abs(solutions[end+1])) start--;
            else end++;
        }
    }

    static void output() {
        System.out.println(result1+" "+result2);
    }
}
