import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, K;
    static int[] heights;

    // 키 차이 배열
    static int[] diffs;

    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());

        heights = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) heights[i] = Integer.parseInt(stn.nextToken());
    }

    static void solve() {

        /**
         * 1. 아이들의 키 차이를 저장하는 배열 갱신 
         * 2. 키 차이 배열 오름차순 정렬
         * 3. N-K번 그 차이를 결과값에 더해줌
         *  3-1. ex. 5명의 아이를 3개의 그룹으로 나눈다고 가정
         *  3-2. 1,1,3 혹은 1,2,2 로 나뉨 
         *  3-3. (5-3) 총 2번 나눠어짐 -> 그것만큼 결과 갱신??
         */

        diffs = new int[N-1];
        for(int i=0; i<N-1; i++) {
            diffs[i] = heights[i+1] - heights[i];
        }

        Arrays.sort(diffs);

        result = 0;
        for(int i=0; i<N-K; i++) {
            result += diffs[i];
        }
    }

    static void output() {
        System.out.println(result);
    }
}
