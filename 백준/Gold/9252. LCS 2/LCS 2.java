import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static String str1, str2;

    static int[][] dpTable;
//    static String[][] dpStrTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
    }

    /**
     * 1. 기존의 DP를 이용한 LCS로 최장수열의 길이와 DpTable을 구함
     *  1-1. 입력으로 들어온 str1, str2의 길이만큼 2중 for문 순회
     *   1-1-1. i번째 str1과 j번째 str2의 값이 같다면 dpTable[i][j] = dpTable[i-1][j-1]+1
     *   1-1-2. 다르다면 dpTable[i][j] = dpTable[i-1][j]와 dpTable[i][j-1]의 최댓값
     * 2. 완성된 DpTable을 거꾸로 순회하면서 dpTable[i][j] = dpTable[i-1][j-1]+1인 값들을 저장해가며 최장수열을 계산
     *
     *
     * 3. 그냥 기존 int형으로 길이를 계산한 DP를 String형으로..? => 문자열 길이가 길어질 수록 연산 수가 급격하게 커질 수 있어 시간초과 (그냥 1,2번 풀이)
     */
    static void solve() {
        dpTable = new int[str1.length()+1][str2.length()+1];
////        dpStrTable = new String[str1.length()+1][str2.length()+1];
//        // Java String은 객체이므로, 배열 선언 시 기본값이 null이다.
//        // 따라서 ""를 Arrays.fill로 채워줌
//        for(String[] dpStrs: dpStrTable) {
//            Arrays.fill(dpStrs, "");
//        }

        // 1. 최장수열의 길이 구하고 DpTable 갱신
        for(int i=1; i<=str1.length(); i++) {

            for(int j=1; j<=str2.length(); j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dpTable[i][j] = dpTable[i-1][j-1]+1;
//                    dpStrTable[i][j] = dpStrTable[i-1][j-1] + str1.charAt(i-1);
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i][j-1]);
//                    dpStrTable[i][j] = (dpStrTable[i-1][j].length() >= dpStrTable[i][j-1].length()) ? dpStrTable[i-1][j] : dpStrTable[i][j-1];
                }
            }
        }

        sb = new StringBuffer();

        // 2. DpTable 거꾸로 순회하면서 최장수열 계산
        int i = str1.length();
        int j = str2.length();

        while(i>0 && j>0) {

            if(i==0 || j==0) break;

            // 갱신했던 값 방향으로 탐색
            if(dpTable[i][j] == dpTable[i-1][j]) i--;
            else if(dpTable[i][j] == dpTable[i][j-1]) j--;
            // 수열이 추가된 지점 
            else {
                sb.append(str1.charAt(i-1));
                i--; j--;
            }
        }
    }

    static void output() {
        int maxLen = dpTable[str1.length()][str2.length()];
        System.out.println(maxLen);
        // 수열의 뒷부분부터 결과값을 계산했기 때문에, sb.reverse로 출력 
        if(maxLen!=0) System.out.print(sb.reverse());
    }
}
