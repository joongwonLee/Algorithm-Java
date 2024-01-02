
import java.util.*;
import java.io.*;

public class Main {

    static class House implements Comparable<House> {
        int to;
        int cost;

        public House(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(House h) {
            return this.cost - h.cost;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static ArrayList<House>[] houses;

    static PriorityQueue<House> pq;
    static boolean[] isVisited;

    static int maxCostOfDiv;
    static int minCost;

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

        houses = new ArrayList[N+1];
        for(int i=1; i<=N; i++) houses[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int houseA = Integer.parseInt(stn.nextToken());
            int houseB = Integer.parseInt(stn.nextToken());
            int cost = Integer.parseInt(stn.nextToken());

            // 길은 양방향으로 다닐 수 있으므로 앙뱡항 그래프 생성
            houses[houseA].add(new House(houseB, cost));
            houses[houseB].add(new House(houseA, cost));
        }
    }

    /**
     * 1. 크루스칼 or 프림 알고리즘으로 MST 계산
     * 2. MST 경로에 포함된 경로 중 가장 큰 경로를 제거 (두 마을로 분할)
     *  2-1. MST 계산 시 비용이 더해질 때 최댓값을 저장
     */
    static void solve() {
        // MST 값
        minCost = 0;
        // MST 계산 시 가장 큰 비용 -> 마을 분할 지점
        maxCostOfDiv = Integer.MIN_VALUE;
        prim();
    }

    /**
     * 프림 알고리즘 (MST)
     * 1. 시작 지점을 기준으로 가장 작은 비용의 간선과 연결된 정점을 선택하여 모든 노드 연결
     *  1-1. PriorityQueue를 사용하여 가장 작은 비용의 정점을 우선적으로 꺼내 탐색
     */
    static void prim() {
        isVisited = new boolean[N+1];
        pq = new PriorityQueue<>();
        pq.add(new House(1,0));

        while(!pq.isEmpty()) {

            House now = pq.poll();

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;
            minCost += now.cost;
            // 마을을 분할할 지점 갱신 (비용이 최댓값인 지점)
            maxCostOfDiv = Math.max(maxCostOfDiv, now.cost);

            for(House next: houses[now.to]) {
                if(!isVisited[next.to]) pq.add(next);
            }
        }
    }

    static void output() {
        System.out.println(minCost - maxCostOfDiv);
    }
}
