
import java.sql.Array;
import java.util.*;
import java.io.*;

/**
 * 2차원 좌표에서 각 edge들이 2개 이상이기 때문에,
 * 해당 좌표에서 여러 edge를 들고 있을 수 있도록 ArrayList<GreedNetworkEdge>[][] 형식으로 데이터 저장 
 * ex. (1,1)에서 (1,2), (2,1)로 뻗어나가는 edge에 접근 => edges[1][1]
 * 
 * 데이터 구조 외에는 기존 MST 알고리즘과 동일 
 */
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T;
    static int R, C;

    // 각 좌표마다 edge를 2개 이상 씩 들고 있음
    static ArrayList<GreedNetworkEdge>[][] edges;

    static boolean[][] isVisited;
    static PriorityQueue<GreedNetworkEdge> pQueue;

    static int minCost;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        stn = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());

        edges = new ArrayList[R+1][C+1];
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                edges[i][j] = new ArrayList<>();
            }
        }

        for(int i=1; i<=R; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=C-1; j++) {
                int cost = Integer.parseInt(stn.nextToken());
                // 양방향 그래프 처리
                edges[i][j].add(new GreedNetworkEdge(new int[]{i, j+1},cost));
                edges[i][j+1].add(new GreedNetworkEdge(new int[]{i, j},cost));
            }
        }

        for(int i=1; i<=R-1; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=C; j++) {
                int cost = Integer.parseInt(stn.nextToken());
                edges[i][j].add(new GreedNetworkEdge(new int[]{i+1, j}, cost));
                edges[i+1][j].add(new GreedNetworkEdge(new int[]{i, j}, cost));
            }
        }
    }

    static void solve() {
        isVisited = new boolean[R+1][C+1];
        pQueue = new PriorityQueue<>();
        minCost = 0;

        Prim();
    }

    static void Prim() {

        // (1,1)에서 뻗어나가는 모든 edge들을 queue에 넣기 
        // 그 edge들 중 가장 cost가 작은 edge로 탐색 시작
        for(GreedNetworkEdge edge: edges[1][1]) {
            pQueue.offer(edge);
        }
        isVisited[1][1] = true;

        while(!pQueue.isEmpty()) {

            GreedNetworkEdge curEdge = pQueue.poll();
            int[] from = curEdge.to;
            int cost = curEdge.cost;

            if(isVisited[from[0]][from[1]]) continue;
            isVisited[from[0]][from[1]] = true;
            minCost += cost;

//            System.out.println("["+from[0]+", "+from[1]+"]"+"cost: "+cost);
//            System.out.println(minCost);

            for(GreedNetworkEdge edge: edges[from[0]][from[1]]) {
                int[] to = edge.to;
                if(!isVisited[to[0]][to[1]]) pQueue.offer(edge);
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(minCost);
        System.out.println(sb);
    }
}

class GreedNetworkEdge implements Comparable {
    int[] to;
    int cost;

    public GreedNetworkEdge() {

    }

    public GreedNetworkEdge(int[] to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        GreedNetworkEdge gnEdge = (GreedNetworkEdge) o;

        return this.cost - gnEdge.cost;
    }
}