import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int[][] partSum;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        partSum = new int[N+1][N+1];

        /**
         * 1. 입력으로 들어온 데이터들을 부분합으로 저장
         * 2. 입력으로 들어온 좌표에 대해 부분합으로 저장한 데이터 계산 
         */
        
        // 1. 부분합 저장
        for(int i=1; i<=N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {

                int input = Integer.parseInt(stn.nextToken());

                // 부분합 테이블에서 [i-1][j]+[i][j-1]-[i-1][j-1]을 하면 [i][j] 값이 나옴 
                partSum[i][j] = (partSum[i-1][j] + partSum[i][j-1] - partSum[i-1][j-1]) + input;
            }
        }

        // 2. 입력으로 들어온 x1,y1,x2,y2에 대해 부분합으로 계산 
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(stn.nextToken());
            int y1 = Integer.parseInt(stn.nextToken());
            int x2 = Integer.parseInt(stn.nextToken());
            int y2 = Integer.parseInt(stn.nextToken());

            // 가장 큰 사각형 (x2>=x1, y2>=y1을 보장하기 때문)
            int bigSquare = partSum[x2][y2];
            // 빼야할 부분 
            int minusPart = (partSum[x2][y1-1] + partSum[x1-1][y2]) - partSum[x1-1][y1-1];

            int result = bigSquare - minusPart;

            System.out.println(result);
        }
    }
}
