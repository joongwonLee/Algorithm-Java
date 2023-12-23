import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static char[] firstStr, secondStr;

    static int[][] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        firstStr = br.readLine().toCharArray();
        secondStr = br.readLine().toCharArray();
    }

    /**
     * 일반 LCS 알고리즘과 동일
     * 2차원 dpTable 만들어서 두 문자열 길이만큼 2중 for문
     * 값이 같으면 i-1, j-1 인덱스의 값 +1
     * 값이 다르면 (i,j-1)과 (i-1, j) 인덱스의 테이블 값 중 큰 것으로 갱신 
     */
    static void solve() {
        dpTable = new int[firstStr.length+1][secondStr.length+1];

        for(int i=1; i<=firstStr.length; i++) {

            for(int j=1; j<=secondStr.length; j++) {

                if(firstStr[i-1]==secondStr[j-1]) dpTable[i][j] = dpTable[i-1][j-1]+1;
                else dpTable[i][j] = Math.max(dpTable[i][j-1], dpTable[i-1][j]);
            }
        }
    }

    static void output() {
        System.out.println(dpTable[firstStr.length][secondStr.length]);
    }
}
