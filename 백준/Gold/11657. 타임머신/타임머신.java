
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<Edge> edges;

    // 1번 도시 -> n번 도시까지의 비용
    static Long[] costs;

    static final Long INF = 999999999999L;

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
        edges = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int outN = Integer.parseInt(stn.nextToken());
            int inN = Integer.parseInt(stn.nextToken());
            Long cost = Long.parseLong(stn.nextToken());

            edges.add(new Edge(outN, inN, cost));
        }
    }

    static void solve() {
        costs = new Long[N+1];
        Arrays.fill(costs, INF);
        costs[1] = 0L;

        BellmanFord();
    }

    // 벨만-포드 알고리즘을 이용하여 최소 비용 계산
    // 사실 여기까지는 다익스트라랑 같은 느낌?
    static void BellmanFord() {
        for(int i=1; i<=N; i++) {
            // 모든 노드들을 돌면서,
            for(int j=0; j<M; j++) {
                // 하나의 노드에 대해 모든 간선을 돌면서,
                Edge edge = edges.get(j);

                // (start->outNode)+(outNode+inNode)와 (start->inNode)를 비교하여 더 작은 값을 저장
                if(costs[edge.outNode]!=INF) {
                    costs[edge.inNode] = Math.min(costs[edge.inNode], costs[edge.outNode]+edge.cost);
                }
            }
        }
    }

    // 음의 가중치를 통해 음의 사이클이 생긴다면,
    // 무한히 과거로 갈 수 있다고 판단
    static boolean canGoInfinitePast() {
        for(int i=0; i<M; i++) {

            Edge edge = edges.get(i);
            // BellamFord()에서 수행하여 최소값으로 갱신된 값을 다시 한 번 확인했을 때,
            // 계속 작아짐을 보인다면, => 음의 사이클 존재
            if(costs[edge.outNode]!=INF && costs[edge.inNode] > (costs[edge.outNode]+edge.cost)) {
                return true;
            }
        }
        return false;
    }

    static void output() {
        sb = new StringBuffer();

        if(canGoInfinitePast()) sb.append(-1);
        else if(N==1) {}
        else {
            for(int i=2; i<costs.length; i++) {
                if(costs[i]==INF) sb.append(-1+"\n");
                else sb.append(costs[i]+"\n");
            }
        }
        System.out.println(sb);
    }

}

class Edge {
    int outNode; // 나가는 정점
    int inNode; // 들어오는 정점
    Long cost; // 비용

    public Edge() {

    }

    public Edge(int outNode, int inNode, Long cost) {
        this.outNode = outNode;
        this.inNode = inNode;
        this.cost = cost;
    }
}