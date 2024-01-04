
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
//    static int[][] matrices;
    static int[] matrixEle; // 행렬의 크기를 2차원으로 받는 것이 아닌, 겹치는 수는 하나의 요소로 판단해서 일차원 배열로 저장

    static int[][] dpTable;

    static final int INF = Integer.MAX_VALUE;

    static int minOfOper;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrixEle = new int[N+1];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(stn.nextToken());
            int c = Integer.parseInt(stn.nextToken());

            matrixEle[i] = r; matrixEle[i+1] = c;
        }
    }

    /**
     * (정답 참고)
     * 1. Bottom-Up 풀이 (반복문으로도 꼭 풀어보기)
     * 2. Top-Down 풀이
     *
     * [Top-Down] 반복문의 설계가 쉽지 않을 때 가독성 좋은 재귀 형식으로 풀이
     * 재귀 호출을 하면서 행렬 크기 값들을 하위 문제로 쪼개는 방식
     * dpTable[i][j]: i부터 j번째 행렬들의 연산의 최소 횟수
     */
    static void solve() {
        dpTable = new int[N][N];

        // dpTable 전체를 정수형 최댓값으로 초기화
        for(int i=0; i<N; i++) {
            Arrays.fill(dpTable[i], INF);
        }

        minOfOper = recursive(0, N-1);
    }

    // 여러 개의 행렬을 두 개의 행렬로 쪼개서 dpTable을 갱신해가는 형태
    // 인덱스 pos부터 cur 번째 까지의 행렬 사이의 곱 연산의 최소 횟수 구하는 함수
    static int recursive(int pos, int cur) {
        if(pos==cur) return 0;
        if(dpTable[pos][cur]!=INF) return dpTable[pos][cur];


        // pos부터 cur까지 i를 돌면서 (pos~i)최솟값 + (i~cur)최솟값을 기존의 dpTable과 비교하며 갱신
        for(int i=pos; i<cur; i++) {
            int value = recursive(pos, i) + recursive(i+1, cur) + (matrixEle[pos]*matrixEle[i+1]*matrixEle[cur+1]);
            dpTable[pos][cur] = Math.min(dpTable[pos][cur], value);
        }

        return dpTable[pos][cur];
    }

    static void output() {
        System.out.println(minOfOper);
    }
}
