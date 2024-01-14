
import java.util.*;
import java.io.*;

public class Main {

    static class Load implements Comparable<Load> {

        int to;
        int len;

        public Load(int to, int len) {
            this.to = to;
            this.len = len;
        }

        @Override
        public int compareTo(Load load) {
            return this.len-load.len;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, V, E;
    static int KIST, CRFood;
    static int[] membersHouse;
    static ArrayList<Load>[] loads;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;
    static int[] minLen;
    static final int INF = Integer.MAX_VALUE;

    static int sumOfMinLen;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        V = Integer.parseInt(stn.nextToken());
        E = Integer.parseInt(stn.nextToken());

        stn = new StringTokenizer(br.readLine());

        KIST = Integer.parseInt(stn.nextToken());
        CRFood = Integer.parseInt(stn.nextToken());

        stn = new StringTokenizer(br.readLine());

        membersHouse = new int[N];
        for(int i=0; i<N; i++) membersHouse[i] = Integer.parseInt(stn.nextToken());

        loads = new ArrayList[V+1];
        for(int i=1; i<=V; i++) loads[i] = new ArrayList<>();

        for(int i=1; i<=E; i++) {
            stn = new StringTokenizer(br.readLine());

            int posA = Integer.parseInt(stn.nextToken());
            int posB = Integer.parseInt(stn.nextToken());
            int len = Integer.parseInt(stn.nextToken());

            loads[posA].add(new Load(posB, len));
            loads[posB].add(new Load(posA, len));
        }

    }

    /**
     * 구해야 할 것: (멤버의 집 -> KIST까지 최단 경로) + (멤버의 집 -> 씨알푸드까지 최단 경로)의 값의 합 
     * 1. 다익스트라로 각 멤버의 집을 start로 하여 모든 위치에 대해 최단 경로 계산
     * 2. 각 다익스트라가 끝나면 minLen[KIST] + minLen[CRFood]를 리턴
     *  2-1. 단, minLen 값이 INF라면 최단 경로가 없다는 뜻이므로, -1로 
     * 3. 해당 값들을 모두 구해 출력 
     */
    static void solve() {
        sumOfMinLen = 0;

        // 각 멤버별 집의 위치를 출발점으로 다익스트라 알고리즘 적용 
        for(int i=0; i<N; i++) {
            sumOfMinLen += dijkstra(membersHouse[i]);
        }
    }

    static int dijkstra(int start) {

        pq = new PriorityQueue<>();
        isVisited = new boolean[V+1];

        minLen = new int[V+1];
        Arrays.fill(minLen,INF);

        pq.add(new Load(start, 0));
        minLen[start] = 0;

        while(!pq.isEmpty()) {

            int now = pq.poll().to;

            if(isVisited[now]) continue;
            isVisited[now] = true;

            for(Load next: loads[now]) {

                if(!isVisited[next.to]&&minLen[next.to] > minLen[now]+next.len) {
                    minLen[next.to] = minLen[now]+next.len;
                    pq.add(new Load(next.to, minLen[next.to]));
                }
            }
        }

        // 최단 경로 값이 INF라면 -1, 아니면 값 그대로 
        int houseToKIST = (minLen[KIST]==INF) ? -1 : minLen[KIST];
        int houseToCRFood = (minLen[KIST]==INF) ? -1 : minLen[CRFood];

        // KIST, CRFood까지 최단 경로의 합을 리턴 
        return houseToKIST + houseToCRFood;
    }

    static void output() {
        System.out.println(sumOfMinLen);
    }

}
