import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int R,C,Q;
    static int[][] partSumOfGalary;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());
        Q = Integer.parseInt(stn.nextToken());

        partSumOfGalary = new int[R+1][C+1];

        for(int i=1; i<=R; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=C; j++) {
                int input = Integer.parseInt(stn.nextToken());
                // 각 입력을 부분합으로 저장
                partSumOfGalary[i][j]=(partSumOfGalary[i-1][j]+partSumOfGalary[i][j-1]-partSumOfGalary[i-1][j-1])+input;
            }
        }

//        for(int i=1; i<=R; i++) {
//            for(int j=1; j<=C; j++) {
//                System.out.print(partSumOfGalary[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0; i<Q; i++) {
            stn = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(stn.nextToken());
            int c1 = Integer.parseInt(stn.nextToken());
            int r2 = Integer.parseInt(stn.nextToken());
            int c2 = Integer.parseInt(stn.nextToken());

            // 가장 큰 사각형의 부분합
            int bigSquare = partSumOfGalary[r2][c2];
            // 사각형에서 빼야할 부분의 부분합
            int smallPart = partSumOfGalary[r2][c1-1]+partSumOfGalary[r1-1][c2]-partSumOfGalary[r1-1][c1-1];
            // 사각형의 개수
            int numOfSquare = ((r2+1)-r1)*((c2+1)-c1);

            // 사각형 내 밝기의 평균
            int avgOfBright = (bigSquare-smallPart)/numOfSquare;

            System.out.println(avgOfBright);
        }
    }
}
