
import java.util.*;
import java.io.*;

public class Main {

    static class Circuit implements Comparable<Circuit> {

        int to;
        int time;

        public Circuit(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Circuit c) {
            return this.time - c.time;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static ArrayList<Circuit>[] circuits;

    static PriorityQueue<Circuit> pq;
    static boolean[] isVisited;
    static int[] minTime;

    static final int INF = Integer.MAX_VALUE;

    static int numOfRecover;
    static ArrayList<int[]> recoverCircuit;

    static int[] path;

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

        circuits = new ArrayList[N+1];
        for(int i=1; i<=N; i++) circuits[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int comA = Integer.parseInt(stn.nextToken());
            int comB = Integer.parseInt(stn.nextToken());
            int commTime = Integer.parseInt(stn.nextToken());

            circuits[comA].add(new Circuit(comB, commTime));
            circuits[comB].add(new Circuit(comA, commTime));
        }
    }

    /**
     * 풀이 생각
     * 모든 회선이 차단되었고, 모든 컴퓨터가 연결되도록 최소한의 회선을 복구해야함 (단, 복구하는 회선이 연결되었을 때, 기존 컴퓨터 연결에 대한 시간보다 덜 걸려야 함)
     * => 기존 모든 회선에서 최단 시간의 회선을 탐색했을 때, 최단 시간 아닌 회선을 없앤다면?
     * => 남는 회선들: 문제 조건에 맞는 복구해야할 회선이 되는 것
     * 반례: 최단 시간이 같은 회선이 여러개 생길 때
     *
     * 방법2. 복구될 회선 개수는 N-1??
     * 그게 보장된다면, 최단 시간이 갱신될 때 path 정보를 저장하고 path를 그대로 출력
     *
     * 1. 다익스트라를 통해 슈퍼컴퓨터(1) -> 다른 컴퓨터 간 최단 시간 계산
     *  1-1. 다익스트라 최단 시간 갱신 중 최단 경로 갱신을 못하는 회선 삭제
     * 2. 최단 경로 계산이 끝났을 때, 다시 한 번 더 남아 있는 모든 회선을 탐색하며 최단 시간보다 큰 회선 삭제
     *  2-1. why? 다익스트라 계산 시 최단 시간은 계속 갱신이 되기 때문에, 큰 시간 값이 남아있을 수 있음
     */
    static void solve() {
        path = new int[N+1];
        // 다익스트라 알고리즘으로 최단 시간 계산
        dijkstra();

//        // 최단 시간 계산 후 남아 있는 회선 탐색
//        for(int i=1; i<=N; i++) {
//
//            // 삭제할 회선 인덱스 저장
//            ArrayList<Integer> removeIdx = new ArrayList<>();
//
//            for(int j=0; j<circuits[i].size(); j++) {
//                Circuit c = circuits[i].get(j);
//                // 계산한 최단 시간보다 회선의 시간이 길다면, 삭제할 인덱스에 추가
//                if(minTime[c.to]<c.time) removeIdx.add(j);
//            }
//
//            // 리스트의 끝부터 삭제하기 위해 내림차순 정렬
//            Collections.sort(removeIdx, Collections.reverseOrder());
//
//            // 리스트 삭제
//            for(int idx: removeIdx) circuits[i].remove(idx);
//        }
    }

    // 다익스트라 알고리즘
    // 최단 시간 갱신이 안되는 회선은 삭제
    static void dijkstra() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];

        minTime = new int[N+1];
        Arrays.fill(minTime, INF);

        pq.add(new Circuit(1, 0));
        minTime[1] = 0;

        while(!pq.isEmpty()) {

            int now = pq.poll().to;

            if(isVisited[now]) continue;
            isVisited[now] = true;

            ArrayList<Integer> removeIdx = new ArrayList<>();

            for(Circuit next: circuits[now]) {

                if(!isVisited[next.to]&&minTime[next.to] > minTime[now]+next.time) {
                    minTime[next.to] = minTime[now]+next.time;
                    path[next.to] = now;
                    pq.add(new Circuit(next.to, minTime[next.to]));
                }
//                else { // 최단 시간 갱신이 안되면 -> 삭제 리스트에 인덱스 추가
//                    removeIdx.add(circuits[now].indexOf(next));
//                }

            }

//            Collections.sort(removeIdx, Collections.reverseOrder());
//
//            // 삭제 인덱스를 통해 회선 삭제
//            for(int idx: removeIdx) {
//                circuits[now].remove(idx);
//            }
        }
    }

    static void output() {

        numOfRecover = 0;
//        recoverCircuit = new ArrayList<>();
//
//        // 최단 시간을 만족하지 못하는 회선을 삭제 후 남은 회선 탐색
//        for(int i=1; i<=N; i++) {
//            // 복구할 회선 수 갱신
//            numOfRecover += circuits[i].size();
//
//            for(int j=0; j<circuits[i].size(); j++) {
//                // 회선 정보 (from -> to) 저장
//                recoverCircuit.add(new int[]{i, circuits[i].get(j).to});
//            }
//        }
//
//        System.out.println(numOfRecover);
//        for(int[] circuit: recoverCircuit) {
//            System.out.println(circuit[0]+" "+circuit[1]);
//        }

        for(int i=2; i<=N; i++) {
            if(path[i]!=0) {
                numOfRecover++;
            }
        }

        System.out.println(numOfRecover);

        for(int i=2; i<=N; i++) {
            if(path[i]!=0) { // path 정보가 0아 아닌, 즉 최단 시간 경로가 정해진 path만 출력 
                System.out.println(path[i]+" "+i);
            }
        }
    }

}
