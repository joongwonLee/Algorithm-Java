import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] abilities;

    static int maxAbility;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        abilities = new int[N];

        stn = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            abilities[i] = Integer.parseInt(stn.nextToken());
        }

    }

    static void solve() {
        twoPointer();
    }

    /**
     * 기본적으로 투포인터는 정렬되어 있는 배열에 적용하지만,
     * 해당 문제는 정렬이 되지 않아도 문제의 조건때문에 적용 가능
     * 능력치: A와 B 사이의 개발자 수 * (A 능력치와 B 능력치 중 작은 값)
     * A와 B 사이의 개발자 수라는 조건 때문에, 배열의 처음과 끝 점을 투포인터의 시작으로 잡고,
     * 사이를 줄여가면서 값을 갱신해나갈 수 있음
     *
     * 1. start=0, end=N-1로 설정
     * 2. 능력치의 최댓값을 갱신하고, start+1과 end-1의 능력치를 비교해서 더 큰 값에 대해 투표인터 이동
     * 3. 1,2번 반복하면서 start와 end가 만나는 지점에서 종료
     */
    static void twoPointer() {
        int start = 0;
        int end = N-1;

        maxAbility = Integer.MIN_VALUE;

        if(N==2) {
            maxAbility = 0;
            return; // N==2면 결과값이 무조건 0이므로 리턴
        }

        while(end>start) {

//            System.out.println(maxAbility);
            int min = Math.min(abilities[start], abilities[end]);
            int calcAbility = (end-start-1)*min; // 능력치 계산

//            // start 이후 값과 end 이전 값을 비교해서 투포인터 이동
//            int postCompareAbility = Math.min(abilities[start+1], abilities[end]);
//            int preCompareAbility = Math.min(abilities[start], abilities[end-1]);

            maxAbility = Math.max(maxAbility, calcAbility);

            if(abilities[start] < abilities[end]) start++;
            else end--;
        }
    }

    static void output() {
        System.out.println(maxAbility);
    }
}
