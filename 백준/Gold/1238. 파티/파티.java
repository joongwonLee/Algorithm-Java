import java.util.*;
import java.io.*;

public class Main {

    static class Load implements Comparable<Load> {
        int to;
        int cost;

        public Load(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Load l) {
            return this.cost - l.cost;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M, X;
    static ArrayList<Load>[] loads;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;
    static int[][] minCosts;
    static int INF = Integer.MAX_VALUE;

    static int maxCost;

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
        X = Integer.parseInt(stn.nextToken());

        loads = new ArrayList[N+1];
        for(int i=1; i<=N; i++) loads[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stn.nextToken());
            int to = Integer.parseInt(stn.nextToken());
            int cost = Integer.parseInt(stn.nextToken());

            loads[from].add(new Load(to, cost));
        }
    }

    static void solve() {
        // 모든 마을에 대해 최단경로를 저장
        minCosts = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(minCosts[i], INF);
        }

        for(int i=1; i<=N; i++) {
            // 다익스트라를 이용해 모든 마을에 대해 최단 경로 계산
            dijkstra(i);
        }

        // 각 마을 -> 모임 마을 + 모임 마을 -> 각 마을의 최단 경로 중 가장 큰 값 계산 
        maxCost = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
//            System.out.println(minCosts[i][X]+", "+minCosts[X][i]);
            // (i -> X) 최단 경로 + (X->i) 최단 경로의 최댓값 갱신 
            maxCost = Math.max(maxCost, (minCosts[i][X] + minCosts[X][i]));
        }
    }

    // 다익스트라로 시작 마을 -> 각 마을까지의 최단경로 계산
    static void dijkstra(int start) {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];
        minCosts[start][start] = 0;

        pq.add(new Load(start, 0));

        while(!pq.isEmpty()) {

            int now = pq.poll().to;

            if(isVisited[now]) continue;
            isVisited[now] = true;

            for(Load next: loads[now]) {

                if(!isVisited[next.to]&&(minCosts[start][next.to] > minCosts[start][now] + next.cost)) {
                    minCosts[start][next.to] = minCosts[start][now] + next.cost;
                    pq.add(new Load(next.to, minCosts[start][next.to]));
                }
            }
        }
    }

    static void output() {
        System.out.println(maxCost);
    }
}
