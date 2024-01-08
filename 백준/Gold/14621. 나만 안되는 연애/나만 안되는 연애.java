
import java.util.*;
import java.io.*;

public class Main {

    // 대학교에서 대학교로 가는 길
    // 목적 대학교 to, 거리 dist
    // from이 없는 이유는 arrayList[]의 인덱스로 관리하려고
    static class Load implements Comparable<Load> {
        int to;
        int dist;

        public Load(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Load l) {
            return this.dist - l.dist;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static char[] univs;
    static ArrayList<Load>[] loads;

    static PriorityQueue<Load> pq;
    static boolean[] isVisited;

    static int cnt; // 모든 학교를 연결하는 경로가 있는지 확인하기 위한 변수
    static int minDist;

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

        univs = new char[N+1];
        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            univs[i] = stn.nextToken().charAt(0);
        }

        //
        loads = new ArrayList[N+1];
        for(int i=1; i<=N; i++) loads[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stn.nextToken());
            int v = Integer.parseInt(stn.nextToken());
            int d = Integer.parseInt(stn.nextToken());

            // 남초 대학에서 남초 대학으로, 여초 대학에서 여초 대학으로 가는 길은 아예 길 취급 x
            if(univs[u]=='M'&&univs[v]=='M') continue;
            if(univs[u]=='W'&&univs[v]=='W') continue;

            // load를 to, from 양방향으로 저장
            loads[u].add(new Load(v, d));
            loads[v].add(new Load(u, d));
        }
    }

    static void solve() {
        cnt = 0; minDist = 0;
        prim();
    }

    // 프림 알고리즘 이용해서 MST 구성
    static void prim() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];

        // (의미 없는) 초기 데이터 추가
        pq.add(new Load(1, 0));

        while(!pq.isEmpty()) {

            Load now  = pq.poll();

            // 초기 데이터를 의미 없는 데이터를 넣었으므로, visit 체크 로직이 기존과 조금 다른 느낌
            // for문 바깥에서 visit 체크 후 갱신
            if(isVisited[now.to]) continue;

            isVisited[now.to] = true;
            minDist += now.dist;
            cnt++; // 경로 갯수 체크

            for(Load next: loads[now.to]) {
                if(!isVisited[next.to]) {
                    pq.add(next);
                }
            }
        }
    }

    static void output() {
        // cnt 즉, 경로를 계산한 횟수가 N이 안되면 모든 학교를 연결하는 경로가 없다는 뜻 -> -1 출력
        if(cnt!=N) System.out.println(-1);
        // 모든 학교를 연결하는 경로가 있다면 쵝소 경로 출력
        else System.out.println(minDist);
    }
}
