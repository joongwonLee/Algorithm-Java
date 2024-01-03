
import java.util.*;
import java.io.*;

/**
 * 입력으로 주어진 별의 좌표를 통해 MST(최소 스패닝 트리)를 구하는 것
 * 기존의 프림 알고리즘을 사용해서 구하려면 int 형으로 객체에 접근이 가능해야 함
 * 때문에 double 형으로 주어지는 입력 데이터를 int형 인덱스를 포함한 객체로 변환 (Star)
 */
public class Main {

    // 프림 알고리즘을 사용하기 위해 int형 인덱스를 가진 Star 클래스 선언
    static class Star {
        int idx;
        double x;
        double y;

        public Star(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class StarLoad implements Comparable<StarLoad> {
        // 길이 이어지는(to) 별의 idx
        int toIdx;
        double dist;

        public StarLoad(int toIdx, double dist) {
            this.toIdx = toIdx;
            this.dist = dist;
        }

        // 우선순위 큐를 사용하기 위해 compareTo 기준을 잡아줌
        // 무조건 int형을 반환해야 하므로 double 형 값을 비교하고 그에 따른 int형 값을 반환
        @Override
        public int compareTo(StarLoad o) {
            if(this.dist-o.dist>0.0) {
                return 1;
            } else if(this.dist-o.dist==0.0) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int n;
    static Star[] starsPos;

    static ArrayList<StarLoad>[] starLoads;

    static PriorityQueue<StarLoad> pq;
    static boolean[] isVisited;

    static double minDist;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        starsPos = new Star[n];

        for(int i=0; i<n; i++) {
            stn = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(stn.nextToken());
            double y = Double.parseDouble(stn.nextToken());

            starsPos[i] = new Star(i, x, y);
        }
    }

    /**
     * 1. 입력으로 들어온 별들의 좌표를 가지고 조합으로 StarLoad(별을 잇는 길) 그래프 생성
     * 2. StarLoad 그래프를 프림 알고리즘으로 MST 계산
     */
    static void solve() {

        starLoads = new ArrayList[n];
        for(int i=0; i<n; i++) starLoads[i] = new ArrayList<>();

        // 1. 조합으로 두 개의 별을 뽑아 길 그래프 생성
        comb(0, 0, new int[2]);

        minDist = 0;
        // 2. 길 그래프를 프림 알고리즘으로 MST 계산
        prim();
    }

    static void prim() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[n];

        pq.add(new StarLoad(0, 0));

        while(!pq.isEmpty()) {

            StarLoad now = pq.poll();

            if(isVisited[now.toIdx]) continue;
            isVisited[now.toIdx] = true;
            minDist += now.dist;

            for(StarLoad next: starLoads[now.toIdx]) {
                if(!isVisited[next.toIdx]) pq.add(next);
            }
        }
    }

    static void comb(int cnt, int start, int[] starsIdx) {

        if(cnt==2) {
            Star starA = starsPos[starsIdx[0]];
            Star starB = starsPos[starsIdx[1]];

            // 두 별 사이의 거리 (두 좌표 사이의 거리 공식)
            double dist = Math.sqrt((Math.pow((starA.x-starB.x),2))+(Math.pow((starA.y-starB.y),2)));
            // 두 별 사이의 관계에 대해 그래프 생성
            starLoads[starA.idx].add(new StarLoad(starB.idx, dist));
            starLoads[starB.idx].add(new StarLoad(starA.idx, dist));

            return;
        }

        for(int i=start; i<starsPos.length; i++) {
            starsIdx[cnt] = i;
            comb(cnt+1, i+1, starsIdx);
        }
    }

    static void output() {
        System.out.println(minDist);
    }
}
