import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] sequences;

    static int[] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sequences = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) sequences[i] = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        dpTable = new int[N];

        for(int i=0; i<N; i++) {

            // 가장 최악의 경우(증가하지 않는 경우에도)에도 자기 자신을 포함하기 때문에 1로 시작
            dpTable[i] = 1;

            // 현재 데이터에 대해 이전 데이터를 모두 확인
            for(int j=0; j<i; j++) {

                // 이전 데이터보다 클 경우
                if(sequences[i] > sequences[j]) {
                    // dpTable을 이전 데이터 시점의 dpTable과의 최댓값으로 갱신
                    dpTable[i] = Math.max(dpTable[i], dpTable[j]+1);
                }
            }
        }
    }

    static void output() {
        int result = 0;
        
        for(int dpValue: dpTable) result = Math.max(result, dpValue);
        
        System.out.println(result);
    }
}
