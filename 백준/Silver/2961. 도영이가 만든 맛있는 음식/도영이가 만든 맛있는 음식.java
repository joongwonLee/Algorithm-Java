
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static ArrayList<int[]> materials;

    // powerSet 구할 때 사용할 배열
    static boolean[] isSelected;

    static int minDiffTaste;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        materials = new ArrayList<>();

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int sour  = Integer.parseInt(stn.nextToken());
            int beat = Integer.parseInt(stn.nextToken());

            materials.add(new int[]{sour, beat});
        }
    }

    static void solve() {
        minDiffTaste = Integer.MAX_VALUE;

        isSelected = new boolean[N];
        powerSet(0);
    }

    /**
     * N의 크기가 최대 10이고 제한시간은 1초이므로, 충분히 powerSet 구할 수 o
     * 모든 경우의 수를 구하고 맛의 차의 최솟값을 결과값에 갱신 
     */
    static void powerSet(int cnt) {


        if(cnt == N) {

            int mulOfSour = 0;
            int sumOfBeat = 0;

            // poserSet이 모두 false로 되어있으면 재료를 쓰지 않은 것 
            // 이를 처리해주지 않으면 최솟값 0이 나오므로 flag로 처리 
            boolean isAllFalse = true;

            for(int i=0; i<materials.size(); i++) {
                if(isSelected[i]) {
                    if(mulOfSour==0) mulOfSour = materials.get(i)[0];
                    else mulOfSour *= materials.get(i)[0];

                    sumOfBeat += materials.get(i)[1];
                    isAllFalse = false;
                }
            }

            if(!isAllFalse) minDiffTaste = Math.min(minDiffTaste, Math.abs(mulOfSour-sumOfBeat));

            return;
        }

        // poserSet의 cnt 인덱스를 true와 false로 번갈아가면서 세팅 후 함수 재귀 호출 
        isSelected[cnt] = true;
        powerSet(cnt+1);
        isSelected[cnt] = false;
        powerSet(cnt+1);
    }

    static void output() {
        System.out.println(minDiffTaste);
    }
}
