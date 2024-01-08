
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static double x, y, c;

    static double width;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        x = Double.parseDouble(stn.nextToken());
        y = Double.parseDouble(stn.nextToken());
        c = Double.parseDouble(stn.nextToken());
    }

    /**
     * 집과 사다리에 대해 평면 좌표로 이동해 도식화
     * 삼각형의 닮은 꼴로 w를 x, y, c에 대한 식으로 정의
     */
    static void solve() {
        width = binarySearch();
    }

    // 이분탐색으로 구하고자 하는 너비의 오차를 0.001 이내로 줄이고 리턴
    static double binarySearch() {

        // 구하고자 하는 너비는 x,y보다 작은 것이 보장되므로 0과 (x,y)의 최솟값 사이에서 탐색
        double left = 0; double right = Math.min(x, y);

        while(right-left>=0.001) {
            //
            double w = (left+right)/2;
            // 삼각형의 닮은꼴을 이용한 식 계산
            // x 길이의 선분을 담고 있는 집의 높이 h1 = (x^2-width^2)의 제곱근
            // y 길이의 선분을 담고 있는 집의 높이 h2 = (y^2-width^2)의 제곱근
            double h1 = Math.sqrt(Math.pow(x, 2)-Math.pow(w, 2));
            double h2 = Math.sqrt(Math.pow(y, 2)-Math.pow(w, 2));

            // 두 선분이 교차하는 y 좌표 c에 대해 c = (h1*h2)/(h1+h2)라는 공식 성립
            double val = (h1*h2)/(h1+h2);

//            System.out.println(val);

            // c 계산값이 실제 c값 보다 크다면 좌측 값을 올려줌으로서 너비를 크게
            if(val>=c) left = w;
            // 작다면 우측 값을 내려줌으로서 너비를 작게
            else right = w;
        }

        return right;
    }

    static void output() {
        System.out.println(width);
    }
}
