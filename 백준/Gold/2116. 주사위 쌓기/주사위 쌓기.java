import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int numOfDice;
    static int[][] diceInfo;

    // 주사위의 마주보는 면 인덱스 정보
    // 0(A) <-> 5(F), 1(B) <-> 3(D), 2(C) <-> 4(E)
    static int[] faceTofaceInfo = {5, 3, 4, 1, 2, 0};

    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        numOfDice = Integer.parseInt(br.readLine());

        diceInfo = new int[numOfDice][6];
        for(int i=0; i<numOfDice; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) {
                diceInfo[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
    }


    /**
     * 1. 1번 주사위의 윗면의 경우에 수(6가지)에 따라 모든 주사위의 상태를 정의
     *  1-1. 1번 주사위의 윗면만 정해지면 모든 주사위의 상태가 정해짐
     * 2. 각 주사위의 옆면의 최댓값을 계산하여 갱신
     */
    static void solve() {

        result = 0;

        // 1번 주사위의 윗면 정의
        for(int i=0; i<6; i++) {
            // 윗면에 따른 모든 주사위의 상태 정의
            // 각 상태와 옆면의 최댓값을 인자로
            // 0:A, 1:B, 2:C, 3:D, 4:E, 5:F
            int maxNextValue = 0;
            for(int j=0; j<6; j++) {
                // 옆면은 자기 자신과 마주보는 면을 제외한 것
                if(j==i) continue;
                if(j==faceTofaceInfo[i]) continue;
                maxNextValue = Math.max(maxNextValue, diceInfo[0][j]);
            }
            setDiceState(diceInfo[0][i], maxNextValue);
        }
    }

    static void setDiceState(int topOfFirstDice, int maxNextValueOfFirstDice) {

        // 모든 주사위의 옆면의 최댓값의 합 (1번 주사위의 옆면 최댓값으로 초기값 설정)
        int maxSumOfNextValue = maxNextValueOfFirstDice;

        // 현재 셋팅중인 주사위의 윗면과 아랫면
        int topOfDice = topOfFirstDice;

        // 2번 주사위부터 각 상태를 정의
        for(int i=1; i<numOfDice; i++) {

            int topIdx = 0;
            // 다음 주사위의 윗면을 계산
            for(int j=0; j<diceInfo[i].length; j++) {
                if(topOfDice==diceInfo[i][j]) {
                    topOfDice = diceInfo[i][faceTofaceInfo[j]];
                    topIdx = j;
                    break;
                }
            }

            int maxNextValue = 0;

            // topOfDice를 제외한 옆면의 최댓값 계산
            for(int j=0; j<6; j++) {
                if(j==topIdx) continue;
                if(j==faceTofaceInfo[topIdx]) continue;
                maxNextValue = Math.max(maxNextValue, diceInfo[i][j]);
            }

            maxSumOfNextValue += maxNextValue;
        }

        // 총 옆면의 최댓값의 합을 결과값에 갱신
        result = Math.max(result, maxSumOfNextValue);
    }

    static void output() {
        System.out.println(result);
    }
}
