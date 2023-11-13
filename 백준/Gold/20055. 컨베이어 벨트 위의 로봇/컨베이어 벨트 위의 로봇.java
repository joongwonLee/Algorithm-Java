
import java.util.*;
import java.io.*;

/**
 * 로봇 옮기는 과정을 차례대로, 단계적으로 수행하는 것이 중요
 * 1. 컨베이어 벨트 1회 회전
 * 2. 이동이 가능하다면 로봇들 한 칸씩 이동 (이동한 곳의 내구도 -1)
 * 3. 로봇을 1번에 올리고 (1번의 내구도 -1)
 * 4. 2번과 3번 과정에서 내구도가 0인 벨트가 K개 이상 생기면 종료 -> 해당 단계가 정답
 */

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, K;
    static int[] durability;
    static boolean[] isInRobot;

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

        durability = new int[2*N+1];

        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=2*N; i++) {
            durability[i] = Integer.parseInt(stn.nextToken());
        }
    }

    static void solve() {
        isInRobot = new boolean[2*N+1];
        result = 1; // 1단계부터 시작

        while(true) {
            spinBelt();
            moveRobots();
            if(K<=0) return; // 내구도가 변할 수 있는 함수 호출 후, 내구도가 0인 벨트가 K개 이상이면 종료
            raiseRobot();
            if(K<=0) return;

            result ++;
        }
    }

    // step1. 벨트 회전 (로봇까지 같이 회전해야 함)
    static void spinBelt() {
        int tmp = durability[2*N];
        boolean bTmp = isInRobot[2*N];

        for(int i=2*N-1; i>=1; i--) {
            durability[i+1] = durability[i];
            isInRobot[i+1] = isInRobot[i];
        }

        durability[1] = tmp;
        isInRobot[1] = bTmp;

        // N, N+1번째 칸에 로봇이 있든 없든 N번째에서 로봇은 내려가기 때문에 두 칸 모두 false
        // N+1칸은 회전 전에 N에서 내려갔기 때문에,
        // N칸은 회전 후 N에서 내려갔기 때문에,
        isInRobot[N] = false;
        isInRobot[N+1] = false;

    }

    // step2. 로봇들 이동
    static void moveRobots() {

        for(int i=2*N-1; i>=1; i--) {
            // 다움 위치에 로봇이 없고, 내구도가 0이 아닐 때,
            if(isInRobot[i]&&!isInRobot[i+1]&&durability[i+1]>=1) {
                isInRobot[i] = false;
                isInRobot[i+1] = true;
                durability[i+1] -= 1;
                if(durability[i+1]==0) K--;
            }
        }

        isInRobot[N] = false;
    }

    // step3. 로봇 올리기
    static void raiseRobot() {
        if(durability[1]>=1) {
            isInRobot[1] = true;
            durability[1] -= 1;
            if(durability[1]==0) K--;
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(result);
        System.out.println(sb);
    }
}
