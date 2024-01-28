import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] solutions;

    static int minCharacterValue;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solutions = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) solutions[i] = Integer.parseInt(stn.nextToken());
    }

    /**
     * N이 최대 100,000이기 때문에, 모든 용액에 대해 덧셈을 해서 확인한다면 O(N^2) -> 시간초과
     * 투포인터를 통해 오름차순 정렬되어 있는 용액의 덧셈 진행
     *  1. start: 0, end: N-1
     *  2. end가 start보다 클 때까지 반복
     *      2-1. start와 end 인덱스의 용액의 합과 기존 용액 값과 비교 (절댓값으로 비교 -> 0과 가까움을 찾기 때문) 후 갱신
     *      2-2. start+1과 end-1 인덱스에 접근해 다시 용액 합을 비교 -> 0과 더 가까운 인덱스로 이동 
     */
    static void solve() {
        minCharacterValue = Integer.MAX_VALUE;
        twoPointer();
    }

    static void twoPointer() {
        int start = 0;
        int end = N-1;

        while(end>start) {

            int sum = solutions[start]+solutions[end];

            // 현재 시점 0에 가장 가까운 특성값 보다 다음 특성 값의 합이 더 가깝다면 갱신
            if(Math.abs(sum) < Math.abs(minCharacterValue)) {
                minCharacterValue = sum;
            }

//            if(start<N-1 && end>0) {
//                int leftMoveSum = Math.abs(solutions[start+1]+solutions[end]);
//                int rightMoveSum = Math.abs(solutions[start]+solutions[end-1]);
//
//                if(leftMoveSum < rightMoveSum) start++;
//                else end--;
//            } else {
//                return;
//            }

            int leftMoveSum = Math.abs(solutions[start+1]+solutions[end]);
            int rightMoveSum = Math.abs(solutions[start]+solutions[end-1]);

            if(leftMoveSum < rightMoveSum) start++;
            else end--;
        }
    }

    static void output() {
        System.out.println(minCharacterValue);
    }
}
