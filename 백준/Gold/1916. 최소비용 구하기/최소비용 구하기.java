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

    static int N, M;
    static ArrayList<Load>[] loads;

    static int start, end;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;
    static int[] minCosts;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        loads = new ArrayList[N+1];
        for(int i=1; i<=N; i++) loads[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stn.nextToken());
            int to = Integer.parseInt(stn.nextToken());
            int cost = Integer.parseInt(stn.nextToken());

            loads[from].add(new Load(to, cost));
        }

        stn = new StringTokenizer(br.readLine());
        start = Integer.parseInt(stn.nextToken());
        end = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        dijkstra();
    }

    /**
     * 다익스트라 알고리즘
     * - 그리디 + DP 
     * - 우선순위 큐 이용해 시작 정점부터 해당 노드까지의 거리를 최솟값으로 갱신
     */
    static void dijkstra() {
        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];
        minCosts = new int[N+1];

        Arrays.fill(minCosts, INF); // DP 테이블 초기값을 int형 최댓값으로 -> 작은 값으로 갱신해 가야하기 때문 

        pq.add(new Load(start, 0));
        minCosts[start] = 0;

        while(!pq.isEmpty()) {

            int now = pq.poll().to;

            if(isVisited[now]) continue;
            isVisited[now] = true;

            // 현재 우선순위 큐에서 빼낸 노드에 대해 연결된 노드 탐색 
            for(Load next: loads[now]) {

                // minCosts[next]: 시작지점 -> next까지 최단 경로
                // 기존 (시작지점 -> next) 까지의 최단 경로와 ((시작지점 -> now) + (now -> next)) 비교하고 작은 값 갱신  
                if(!isVisited[next.to]&&minCosts[next.to] > minCosts[now] + next.cost) {
                    minCosts[next.to] = minCosts[now] + next.cost;
                    pq.add(new Load(next.to, minCosts[next.to]));
                }
            }
        }
    }

    static void output() {
        System.out.println(minCosts[end]);
    }

}
