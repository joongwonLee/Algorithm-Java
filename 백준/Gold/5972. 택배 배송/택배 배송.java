
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<int[]>[] sheds;

    static int numOfCows[];
    static PriorityQueue<int[]> pQueue;

    static final int INF = 99_999_999;

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

        sheds = new ArrayList[N+1];
        for(int i=1; i<=N; i++) sheds[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stn.nextToken());
            int end = Integer.parseInt(stn.nextToken());
            int nCows = Integer.parseInt(stn.nextToken());

            sheds[start].add(new int[]{end, nCows});
            sheds[end].add(new int[]{start, nCows});
        }

    }

    static void solve() {
        // 1번과의 경로 사이 소의 수 배열 초기화
        numOfCows = new int[N+1];
        Arrays.fill(numOfCows, INF);
        numOfCows[1] = 0;

        pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        Dijkstra();
    }

    static void Dijkstra() {

        // 시작점 1과 초기 소 0마리 저장
        pQueue.offer(new int[]{1,0});

        while(!pQueue.isEmpty()) {

            int[] now = pQueue.poll();

            for(int[] next: sheds[now[0]]) {
                if(numOfCows[next[0]] > numOfCows[now[0]]+next[1]) {
                    numOfCows[next[0]] = numOfCows[now[0]]+next[1];
                    pQueue.offer(new int[]{next[0], numOfCows[next[0]]});
                }
            }
        }
    }

    static void output() {
//        for(int n: numOfCows) System.out.print(n+" ");
        System.out.println(numOfCows[N]);
    }
}
