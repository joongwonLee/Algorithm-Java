import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;

    static Long[][] dpTable;

    static final Long DIV = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }


    /**
     * 15라는 숫자는 3과 5의 공배수이므로, 3의 배수의 특징과 5의 배수의 특징을 모두 만족
     * 3의 배수의 특징: 각 자릿수의 합이 3의 배수여야 함
     * 5의 배수의 특징: 일의 자리의 숫자가 0 혹은 5 (1, 5로 이루어져야 하므로 일의 자리의 숫자는 5)
     *
     * 위 둘의 특징을 조합해보면, N-1 자릿수의 합이 3으로 나누었을 때 나머지가 1일 때 만족
     * -> 일의 자리 숫자가 5이므로 나머지인 1 + 5 = 6으로 3으로 나누어 떨어지기 때문
     *
     * 2차원 dpTable로 시작. dpTable[i][j]는 j자릿수의 수에 대해 3으로 나눈 나머지가 i인 경우의 수 (대신 1,5로 이루어진 경우만)
     * *** dpTable 초기화 핵심:
     *      조건(1) 일의 자리가 5인 경우의 수만 고려하여 dpTable을 갱신
     *      조건(2) 모든 자릿수의 합을 3으로 나눈 나머지를 기준으로 dpTable을 갱신
     * 1. 초기화: 두 자릿수이고 일의 자리 수가 5인 경우는 15와 55 => dpTable[0][2] = 1, dpTable[1][2] = 1, dpTable[2][2] = 0;
     * 2. 점화식: dpTable[0][j] = dpTable[(0+1)%3][j-1] + dpTable[(0+5)%3][j-1]
     *      2-1. 자릿수를 증가할 때 맨 앞자리에 1 또는 5를 추가하는 형식
     *      2-2. ex. 두자릿수 (15, 55)에 대해 세자릿수인 (115, 515, 155, 555)를 생각해보자 => 1과 5가 추가되는 것을 보면
     */
    static void solve() {

        dpTable = new Long[3][N+1];

        // 한자릿수에서 문제의 조건을 만족하는 수의 개수는 0
        if(N==1) {
            dpTable[0][N] = 0L;
            return;
        }

        // 두자릿수(15, 55)에 대한 초기값 세팅
        dpTable[0][2] = 1L; dpTable[1][2] = 1L; dpTable[2][2] = 0L;


        for(int i=3; i<=N; i++) {
            dpTable[0][i] = (dpTable[1][i-1] + dpTable[2][i-1]) % DIV;
            dpTable[1][i] = (dpTable[0][i-1] + dpTable[2][i-1]) % DIV;
            dpTable[2][i] = (dpTable[0][i-1] + dpTable[1][i-1]) % DIV;
        }
    }

    static void output() {
        // N의 자릿수에 대해 모든 자릿수의 합을 3으로 나눈 나머지가 0인 갯수 (일의 자리 수는 5를 만족하는)
        System.out.println(dpTable[0][N]);
    }
}
