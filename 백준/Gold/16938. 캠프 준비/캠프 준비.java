
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, L, R, X;
    static int[] difficulties;

    static int result;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        L = Integer.parseInt(stn.nextToken());
        R = Integer.parseInt(stn.nextToken());
        X = Integer.parseInt(stn.nextToken());

        difficulties = new int[N+1];
        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) difficulties[i] = Integer.parseInt(stn.nextToken());
    }

    static void solve() {

        result = 0;

        for(int i=2; i<=N; i++) {
            combination(0,1,0, 0, 1000001, i);
        }
    }

    static void combination(int cnt, int start, int sum, int max, int min,int r) {

        if(cnt==r) {
            if(sum>=L&&sum<=R&&(max-min)>=X) result++;

            return;
        }

        for(int i=start; i<=N; i++) {
            combination(cnt+1, i+1, sum+difficulties[i], Math.max(max, difficulties[i]), Math.min(min, difficulties[i]), r);
        }

    }

    static void output() {
        sb = new StringBuffer();
        sb.append(result);
        System.out.println(sb);
    }
}
