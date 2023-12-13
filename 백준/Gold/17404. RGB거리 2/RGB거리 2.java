import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[][] rgbs;

    static final int red = 0;
    static final int green = 1;
    static final int blue = 2;

    static int minRGBValue;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rgbs = new int[N][3];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(stn.nextToken());
            int g = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());

            rgbs[i][red] = r;
            rgbs[i][green] = g;
            rgbs[i][blue] = b;
        }
    }

    /**
     * 1번 집의 색을 지정한 후, 다른 집에 대한 누적합을 반복문 dp로 해결
     */
    static void solve() {

        minRGBValue = Integer.MAX_VALUE;

        paintHouse1(red, green, blue);
        paintHouse1(green, red, blue);
        paintHouse1(blue, red, green);
    }
    
    static void paintHouse1(int paintedColor, int otherColor1, int otherColor2) {

        /**
         * 1번 집의 색을 r,g,b로 칠할 경우 모두 계산해야 하기 때문에 
         * 복사된 rgbs를 이용
         */
        int[][] copiedRGBS = new int[N][3];

        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                copiedRGBS[i][j] = rgbs[i][j];
            }
        }

        for(int i=1; i<N; i++) {

            // 1번 집의 색이 정해졌으므로, 2번 집의 번호를 위한 누적합 갱신
            if(i==1) {
                copiedRGBS[i][otherColor1] += copiedRGBS[i-1][paintedColor];
                copiedRGBS[i][otherColor2] += copiedRGBS[i-1][paintedColor];
            }

            /**
             * 3번 집의 색칠하는 경우
             * 1번 집의 색에 따라 2번 집 색칠 (2번 집에 1번 집 색을 칠하지 x)
             * 따라서 1번 집에 칠한 색에 대한 2번 집의 정보는 누적합이 되지 x
             * 3번 집에 대한 '1번 집에 칠한 색'은 2번 집의 나머지 색 정보의 min으로 갱신 
             */
            else if(i==2) {
                copiedRGBS[i][paintedColor] += Math.min(copiedRGBS[i-1][otherColor1], copiedRGBS[i-1][otherColor2]);
                copiedRGBS[i][otherColor1] += copiedRGBS[i-1][otherColor2];
                copiedRGBS[i][otherColor2] += copiedRGBS[i-1][otherColor1];
            }

            // 4번 집 이상일 때
            else {
                copiedRGBS[i][paintedColor] += Math.min(copiedRGBS[i-1][otherColor1], copiedRGBS[i-1][otherColor2]);
                copiedRGBS[i][otherColor1] += Math.min(copiedRGBS[i-1][paintedColor], copiedRGBS[i-1][otherColor2]);
                copiedRGBS[i][otherColor2] += Math.min(copiedRGBS[i-1][paintedColor], copiedRGBS[i-1][otherColor1]);
            }
        }

        int minRGBForHouse1Color = Math.min(copiedRGBS[N-1][otherColor1], copiedRGBS[N-1][otherColor2]);
//        System.out.println("paintedColor: "+paintedColor+", otherColor1: "+otherColor1+", otherColor2: "+otherColor2+", minRGBForHouse1Color: "+minRGBForHouse1Color);
        minRGBValue = Math.min(minRGBValue, minRGBForHouse1Color);
    }


    static void output() {
        System.out.println(minRGBValue);
    }
}
