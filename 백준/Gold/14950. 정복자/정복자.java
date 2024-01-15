
import java.io.*;
import java.util.*;

public class Main {

    static class Load implements Comparable<Load> {

        int to;
        int cost;

        public Load(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Load load) {
            return this.cost - load.cost;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M, t;
    static ArrayList<Load>[] loads;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;

    static int minConquerCost;

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
        t = Integer.parseInt(stn.nextToken());

        loads = new ArrayList[N+1];
        for(int i=1; i<=N; i++) loads[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int cityA = Integer.parseInt(stn.nextToken());
            int cityB = Integer.parseInt(stn.nextToken());
            int cost = Integer.parseInt(stn.nextToken());

            loads[cityA].add(new Load(cityB, cost));
            loads[cityB].add(new Load(cityA, cost));
        }
    }
    
    static void solve() {
        // 프림 알고리즘으로 MST 계산 
        prim();
    }

    // 프림 알고리즘으로 MST 계산하면서
    // 최소 비용 + 추가 비용 한 번에 계산 
    static void prim() {
        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];

        pq.add(new Load(1, 0));
        
        minConquerCost = 0; // 최소 정복 비용 (MST 비용)
        int conquerCount = -1; // 정복 횟수 (추가 비용에 대한 가중치를 줘야 하기 때문)

        while(!pq.isEmpty()) {

            Load now = pq.poll();

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;

            int originCost = now.cost; // 기존 비용 
            int additionCost = (conquerCount==-1) ? 0 : t*conquerCount; // 추가 비용: 초기일땐 고려 x, 이후부턴 t비용 곱 

            minConquerCost += (originCost + additionCost); // MST 비용 += 기존 비용 + 추가 비용 

            conquerCount++; // 정복 횟수 + 1

            for(Load next: loads[now.to]) {
                if(!isVisited[next.to]) pq.add(next);
            }
        }
    }

    static void output() {
        System.out.println(minConquerCost);
    }
}
