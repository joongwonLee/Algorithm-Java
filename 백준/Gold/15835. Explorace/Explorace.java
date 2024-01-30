import java.util.*;
import java.io.*;

public class Main {

    static class Load implements Comparable<Load> {
        int to;
        int dist;

        public Load(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Load o) {
            return this.dist - o.dist;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T, N, M;
    static ArrayList<Load>[] loads;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;
    static int minDist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            sb = new StringBuffer();
            sb.append("Case #"+i+": ");

            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        loads = new ArrayList[N+1];
        for(int i=1; i<=N; i++) loads[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int loadA = Integer.parseInt(stn.nextToken());
            int loadB = Integer.parseInt(stn.nextToken());
            int dist = Integer.parseInt(stn.nextToken());

            loads[loadA].add(new Load(loadB, dist));
            loads[loadB].add(new Load(loadA, dist));
        }
    }

    // 그냥 일반 MST 구하는 문제 
    // Prim 알고리즘 써서 해결 
    static void solve() {
        minDist = 0;
        prim();
    }
    
    static void prim() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];

        pq.add(new Load(1,0));

        while(!pq.isEmpty()) {

            Load now = pq.poll();

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;
            minDist+=now.dist;

            for(Load next: loads[now.to]) {
                if(!isVisited[next.to]) pq.add(next);
            }
        }
    }

    static void output() {
        sb.append(minDist+" meters");
        System.out.println(sb);
    }

}
