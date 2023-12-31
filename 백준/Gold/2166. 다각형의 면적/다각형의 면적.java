import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;

    static Long[][] vertexs;

    static double area;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vertexs = new Long[N+1][2];

        for(int i=0; i<N; i++){
            stn = new StringTokenizer(br.readLine());

            vertexs[i][0] = Long.parseLong(stn.nextToken());
            vertexs[i][1] = Long.parseLong(stn.nextToken());
        }
    }

    /**
     * 신발끈 정리를 이용해 다각형의 면적 계산
     *
     * 다각형의 꼭짓점 (x1,y1), (x2,y2), ... (xn,yn)에 대해
     * 다각형의 면적 = 1/2 * (Math.abs((x1*y2+x2*y3+...+xn*y1)-(y1*x2+y2*x2+...+yn*x1)))
     */
    static void solve() {

        vertexs[N][0] = vertexs[0][0];
        vertexs[N][1] = vertexs[0][1];

        long sum = 0L;

        for(int i=0; i<N; i++) {
            sum += vertexs[i][0]*vertexs[i+1][1];
            sum -= vertexs[i][1]*vertexs[i+1][0];
        }

        area = (double)(Math.abs(sum))/2;
    }

    static void output() {
        System.out.printf("%.1f", area);
    }

}
