
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static long B;
    static long[][] originMatrix;
    static long[][] result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        B = Long.parseLong(stn.nextToken());

        originMatrix = new long[N][N];
        result = new long[N][N];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                originMatrix[i][j] = Long.parseLong(stn.nextToken());
            }
        }
    }

    static void solve() {
        result = powMatrix(originMatrix, B);
    }

    // 행렬의 거듭제곱을 분할정복으로 계산
    static long[][] powMatrix(long[][] matrix, long expo) {

        // 지수가 1일 때, 1제곱 배열 리턴
        if(expo==1) {
            long[][] divMatrix = new long[N][N];
            /**
             * 반례:
             * 2 1
             * 1000 1000
             * 1000 1000
             *
             * 정답:
             * 0 0
             * 0 0
             *
             * 지수가 1일 때 나눗셈 처리를 안해주면
             * 1000 1000
             * 1000 1000으로 정답이랑 다른 결과값 나옴
             */
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    divMatrix[i][j] = originMatrix[i][j]%1000;
                }
            }
            return divMatrix;
        }
        // 자수가 짝수일 때, 배열의 반제곱 * 배열의 반제곱
        else if(expo%2==0) {
            long[][] halfExpoMatrix = powMatrix(originMatrix, expo/2);
            return multiplyMatrix(halfExpoMatrix, halfExpoMatrix);
        }
        // 지수가 홀수일 때, 배열의 (제곱-1) * 1제곱 배열
        else if(expo%2!=0) {
            long[][] preMatrix = powMatrix(originMatrix, expo-1);
            return multiplyMatrix(preMatrix, originMatrix);
        }

        return null;
    }

    // 두 행렬을 곱하는 연산 함수 (연산 후 1000으로 나눈 나머지를 저장)
    static long[][] multiplyMatrix(long[][] matrixA, long[][] matrixB) {

        long[][] calcMatrix = new long[N][N];

        // 행렬의 곱 계산
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                long mul = 0;
                // 계산된 행렬 matrix에 대해 matrix[i][j]는 곱하는 matrixA의 i행 x matrixB의 j열
                for(int k=0; k<N; k++) {
                    mul += matrixA[i][k]*matrixB[k][j];
                }
                calcMatrix[i][j] = mul%1000;
            }
        }
        return calcMatrix;
    }

    static void output() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
