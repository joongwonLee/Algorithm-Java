import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static String[] tunnelEntrance; // 첫번째 N줄까지의 입력 데이터
    static Map<String, Integer> tunnelExit; // 두번째 N+2~2N까지의 입력 데이터

    static Set<String> set; // 추월하는 차를 저장하는 set

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tunnelEntrance = new String[N];
        tunnelExit = new HashMap<>();

        for(int i=0; i<N; i++) {
            tunnelEntrance[i] = br.readLine(); // 첫번째 입력데이터는 string 배열에 그대로 입력
        }

        for(int i=0; i<N; i++) {
            tunnelExit.put(br.readLine(), i); // 두번째 입력데이터는 map에 key: String, value: int로 입력
        }
    }

    /**
     * 터널 입구 기준으로 들어온 입력과 터널 출구 기준으로 나가는 입력 두 배열 비교 O(N^2)
     * 1. 입구로 들어오는 데이터 기준, 각 자동차 순회
     * 2. 각 자동차에 대해 뒤를 따르는 자동차 순회하며 뒤를 따르는 자동차의 터널을 빠져나오는 순서 조회
     */
    static void solve() {

        set = new HashSet<>();

        if(N==1) return; // N이 1일땐 계산할 필요 x, 그대로 리턴

        for(int i=0; i<N-1; i++) { // 모든 자동차 순회

            int nowExitOrder = tunnelExit.get(tunnelEntrance[i]);
            
            for(int j=i+1; j<N; j++) { // 입구 기준 뒤따르는 자동차들 순회
                int nextExitOrder = tunnelExit.get(tunnelEntrance[j]); // 뒤따르는 자동차들이 터널을 빠져나오는 순서 조회
                if(nextExitOrder<=nowExitOrder) set.add(tunnelEntrance[j]); // 만약 빠져나오는 순서가 현재 자동차의 순서보다 작거나 같으면 추월했다는 뜻
            }
        }
    }

    static void output() {
        System.out.println(set.size()); // 추월한 차의 개수 출력
    }

}
