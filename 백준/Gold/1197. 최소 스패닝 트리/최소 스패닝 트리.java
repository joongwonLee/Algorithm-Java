
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    // 입력 데이터
    static int V, E;
    static ArrayList<MSTNode>[] graph;

    // prim algorithm을 위한 준비물
    static boolean[] isVisited;
    static PriorityQueue<MSTNode> pQueue;

    static int minCost;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        V = Integer.parseInt(stn.nextToken());
        E = Integer.parseInt(stn.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            stn = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            int C = Integer.parseInt(stn.nextToken());

            graph[A].add(new MSTNode(B, C));
            graph[B].add(new MSTNode(A, C));
        }
    }

    static void solve() {
        isVisited = new boolean[V+1];
        pQueue = new PriorityQueue<>();

        Prim();
    }

    static void Prim() {

        pQueue.add(new MSTNode(1, 0));
        minCost = 0;

        while(!pQueue.isEmpty()) {

            MSTNode curNode = pQueue.poll();
            int start = curNode.end;
            int cost = curNode.cost;

            if(isVisited[start]) continue;
            isVisited[start] = true;
            minCost += cost;

            for(MSTNode nextNode: graph[start]) {
                if(!isVisited[nextNode.end]) pQueue.add(nextNode);
            }
        }
    }

    static void Kruskal() {

    }

    static void output() {
        sb = new StringBuffer();
        sb.append(minCost);
        System.out.println(sb);
    }
}

class MSTNode implements Comparable {

    int end;
    int cost;

    public MSTNode() {

    }

    public MSTNode(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        MSTNode oNode = (MSTNode)o;

        return this.cost - oNode.cost;
    }
}

