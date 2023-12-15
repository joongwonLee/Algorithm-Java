import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] cards;
    static int[] pointTable;
    static int maxInputValue;

    static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stn = new StringTokenizer(br.readLine());
        // 카드의 최댓값인 1,000,000 만큼의 pointTable을 생성
        pointTable = new int[1_000_001];
        cards = new int[N+1];

        maxInputValue = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++) {
            int input = Integer.parseInt(stn.nextToken());
            // 입력값을 cards 배열에 그대로 넣고,
            cards[i] = input;
            // pointTable[입력값]에 cards 배열의 인덱스를 넣어줌 -> 점수를 계산할 때 인덱스가 필요하기 때문
            pointTable[input] = i;

            maxInputValue = Math.max(maxInputValue, input);
        }
    }

    /**
     * 그냥 각 카드의 약수, 배수 개수를 구하면 될 듯..?
     * 배수의 개수만큼 해당 테이블 값 +1, 약수의 개수만큼 해당 테이블 값 -1
     */
    static void solve() {

        result = new int[N+1];

        for(int i=1; i<=N; i++) {

            int num = cards[i];

            // 각 카드의 값을 꺼내와 입력값 중 최댓값 만큼 돌면서 pointTable에 자신의 배수가 있는지 확인
            // 있으면 자신의 점수 +1, 배수의 점수-1
            for(int j=num*2; j<=maxInputValue; j+=num) {
                if(pointTable[j]!=0) {
                    result[i]++;
                    result[pointTable[j]]--;
                }
            }
        }
    }

    static void output() {
        for(int i=1; i<=N; i++) {
            System.out.print(result[i]+" ");
        }
    }

}

