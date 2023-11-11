
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<NetworkNode>[] graph;

    static boolean[] isVisited;
    static PriorityQueue<NetworkNode> pQueue;

    static int minCost;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stn.nextToken());
            int to = Integer.parseInt(stn.nextToken());
            int cost = Integer.parseInt(stn.nextToken());

            graph[from].add(new NetworkNode(to, cost));
            graph[to].add(new NetworkNode(from, cost));
        }
    }

    static void solve() {
        isVisited = new boolean[N+1];
        pQueue = new PriorityQueue<>();

        Prim();
    }

    static void Prim() {
        pQueue.offer(new NetworkNode(1, 0));

        while(!pQueue.isEmpty()) {

            NetworkNode curNode = pQueue.poll();
            int from = curNode.to;
            int cost = curNode.cost;

            if(isVisited[from]) continue;
            isVisited[from] = true;
            minCost += cost;

            for(NetworkNode nextNode: graph[from]) {
                if(!isVisited[nextNode.to]) pQueue.offer(nextNode);
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(minCost);
        System.out.println(sb);
    }
}

class NetworkNode implements Comparable {

    int to;
    int cost;

    public NetworkNode() {

    }

    public NetworkNode(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        NetworkNode oNode = (NetworkNode) o;

        return this.cost - oNode.cost;
    }
}