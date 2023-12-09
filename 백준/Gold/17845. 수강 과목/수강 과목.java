import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, K;
    static int[] importancePerSubject;
    static int[] timePerSubject;

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
        K = Integer.parseInt(stn.nextToken());

        importancePerSubject = new int[K];
        timePerSubject = new int[K];

        for(int i=0; i<K; i++) {
            stn = new StringTokenizer(br.readLine());

            int importance = Integer.parseInt(stn.nextToken());
            int time = Integer.parseInt(stn.nextToken());

            importancePerSubject[i] = importance;
            timePerSubject[i] = time;
        }
    }

    static void solve() {
        dpTable = new int[N+1];
        dpTable[0] = 0;

        for(int i=0; i<timePerSubject.length; i++) {

            int importance = importancePerSubject[i];
            int time = timePerSubject[i];

            for(int j=N; j>=time; j--) {
                dpTable[j] = Math.max(dpTable[j], dpTable[j-time] + importance);
            }
        }
    }

    static void output() {
        System.out.println(dpTable[N]);
    }
}