import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuilder sb;

    static int N, M;
    static int[] numbers;

    static boolean[][] isPalindrom;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stn = new StringTokenizer(br.readLine());
        numbers = new int[N+1];

        for(int i=1; i<=N; i++) numbers[i] = Integer.parseInt(stn.nextToken());

        // i번째 수와 j번째 수 사이의 수가 palindrome인지 계산
        calcPalindrom();

        sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stn.nextToken());
            int E = Integer.parseInt(stn.nextToken());

            if(isPalindrom[S][E]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        
        System.out.println(sb);
    }

    static void calcPalindrom() {

        // isPalindrom[i][j] -> i에서 j까지의 수가 팰린드롬인지 여부
        isPalindrom = new boolean[N+1][N+1];

        /**
         * 1. i와 j 사이의 수가 palindrome인지 확인
         *      1-1. 만약 palindrome이라면, i와 j번째 수가 같은지 확인
         *          1-1-1. 같디면 palindrome, 아니면 palindrome이 아님
         *
         * 2. 만약 i와 j 차이가 1 혹은 2라면 (1일땐 바로 옆이고 2일땐 사이에 한 수를 두고 띄어진 상태)
         *      2-1. 바로 i와 j가 같은지 확인
         *          2-1-1. (1-1-1과 동일)
         */
        // palindrome[i][j]와 같은 형식으로 들어가기 때문에, 알파벳 순서 상 j 먼저!
        for(int j=1; j<=N; j++) {

            for(int i=1; i<=j; i++) {

                if(i==j) {
                    isPalindrom[i][j] = true;
                    continue;
                }

                // i와 j 사이의 수가 0개 혹은 1개일 경우
                // i번째 수와 j번째 수를 바로 비교
                if((j-i==1)||(j-i==2)) {
                    if(numbers[i]==numbers[j]) isPalindrom[i][j] = true;
                }

                // i와 j 사이의 수가 2개 이상일 경우
                // i와 j 사이의 수들이 palindrome인지 확인
                else {
                    if(isPalindrom[i+1][j-1]&&numbers[i]==numbers[j]) isPalindrom[i][j] = true;
                }
            }
        }
    }

}
