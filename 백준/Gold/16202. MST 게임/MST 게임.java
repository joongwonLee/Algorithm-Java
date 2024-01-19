import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M, K;

    static ArrayList<Edge>[] graphs;

    static PriorityQueue<Edge> pq;
    static boolean[] isVisited;
    static int minSumWeight; // mst 계산으로 나온 최소 비용

    static int minWeight; // prim 알고리즘 한 번 돌 때 나오는 간선 하나의 최소 비용
    static int minWeightNodeA, minWeightNodeB; // prim 알고리즘을 한 번 돌때 갱신되는 최소 비용 간선을 가진 nodeA, nodeB

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());

        graphs = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graphs[i] = new ArrayList<>();

        for(int i=1; i<=M; i++) {
            stn = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(stn.nextToken());
            int nodeB = Integer.parseInt(stn.nextToken());
            int weight = i;

            graphs[nodeA].add(new Edge(nodeB, weight));
            graphs[nodeB].add(new Edge(nodeA, weight));
        }
    }

    static void solve() {

        // mst를 만들 수 있는지 여부
        boolean mstFlag = true;

        // K번 반복해서 prim 알고리즘으로 MST 계산
        for(int i=0; i<K; i++) {
//            System.out.println(K);

            // 이전 턴에 mst를 만들 수 있었는지 체크
            if(mstFlag) { // 1. 이전 턴에 mst가 만들어 졌다면
                mstFlag = prim(); // 이번 턴에도 mst 계산
                if(mstFlag) sb.append(minSumWeight+" "); // mst이 만들어졌으면 최소 비용 출력
                else sb.append(0+" "); // mst 안만들어졌으면 0 출력
                removeEdge(minWeightNodeA, minWeightNodeB); // mst 계산할 때 갱신된 가장 작은 비용을 가진 간선 제거
            } else { // 2. 이전 턴에 mst가 만들어지지 않았다면
                sb.append(0+" "); // 0 출력
            }
        }
    }

    static boolean prim() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];
        minSumWeight = 0;

        minWeightNodeA = 1;
        minWeightNodeB = 1;
        minWeight = M;

        int connectCnt = 0;

        pq.add(new Edge(1, 0)); // 시작은 항상 1부터, 간산을 제거하는 문제이므로 시작번호는 크게 상관 x

        while(!pq.isEmpty()) {

            Edge now = pq.poll();

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;
            minSumWeight += now.weight;
            connectCnt++;

            for(Edge next: graphs[now.to]) {
                if(!isVisited[next.to]) pq.add(next);
                // 가장 비용이 작은 간선 갱신
                if(next.weight<minWeight) {
                    minWeight = next.weight;
                    minWeightNodeA = now.to;
                    minWeightNodeB = next.to;
                }
            }
        }
        if(connectCnt==N) return true; // mst가 만들어졌으면 true 리턴
        else return false; // 안만들어졌으면 false 리턴
    }

    // 두 정점 사이의 간선을 제거하는 함수
    static void removeEdge(int nodeA, int nodeB) {

        // nodeA -> nodeB 간선 끊어내기
        for(int i=0; i<graphs[nodeA].size(); i++) {
            Edge e = graphs[nodeA].get(i);

            if(e.to == nodeB) {
                graphs[nodeA].remove(i);
                break;
            }
        }

        // nodeB -> nodeA 간선 끊어내기
        for(int i=0; i<graphs[nodeB].size(); i++) {
            Edge e = graphs[nodeB].get(i);

            if(e.to == nodeA) {
                graphs[nodeB].remove(i);
                break;
            }
        }
    }

    static void output() {
        System.out.println(sb);
    }
}
