import java.io.*;

public class Main {

    static BufferedReader br;

    static char[] firstStringToCharArr;
    static char[] secondStringToCharArr;

    static int[][] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        firstStringToCharArr = br.readLine().toCharArray();
        secondStringToCharArr = br.readLine().toCharArray();
    }

    /**
     * LCS 알고리즘 
     * DP 테이블 갱신 점화식
     * 
     * 1. (i==0, j==0) 0
     * 2. (i>0 && j>0)
     *  2-1. firstStringToCharArr[i] == secondStringToCharArr[j]이면, dpTable[i-1][j-1] + 1
     *  2-2. 다르다면, Math.max(dpTable[i][j-1], dpTable[i-1][j]);
     */
    static void solve() {

        dpTable = new int[firstStringToCharArr.length + 1][secondStringToCharArr.length + 1];
        dpTable[0][0] = 0;

        for(int i=1; i<= firstStringToCharArr.length; i++) {

            for(int j=1; j<= secondStringToCharArr.length; j++) {

                if(firstStringToCharArr[i-1] == secondStringToCharArr[j-1]) {
                    dpTable[i][j] =  dpTable[i-1][j-1] + 1;
                } else {
                    dpTable[i][j] = Math.max(dpTable[i][j-1], dpTable[i-1][j]);
                }
            }
        }
    }

    static void output() {
        System.out.println(dpTable[firstStringToCharArr.length][secondStringToCharArr.length]);
    }
}


