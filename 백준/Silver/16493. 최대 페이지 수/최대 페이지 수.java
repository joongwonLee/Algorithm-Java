import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int[] dayPerChap;
    static int[] pagePerChap;

    static int[] dpTable;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        dayPerChap = new int[M+1];
        pagePerChap = new int[M+1];

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(stn.nextToken());
            int page = Integer.parseInt(stn.nextToken());

            dayPerChap[i] = day;
            pagePerChap[i] = page;
        }

    }

    static void solve() {
        dpTable = new int[N+1];
        dpTable[0] = 0;

        for(int i=0; i<M; i++) {

            int day = dayPerChap[i];
            int page = pagePerChap[i];

            for(int j=N; j>=day; j--) {
                // dpTable을 역순으로 갱신
                dpTable[j] = Math.max(dpTable[j], dpTable[j-day]+page);
            }
        }
    }

    static void output() {
        System.out.println(dpTable[N]);
    }
}
