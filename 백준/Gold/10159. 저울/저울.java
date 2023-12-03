import java.util.*;
import java.io.*;


// 삼성 sw 역량테스트 a형 3회차 키 재기랑 완전 똑같은 문제,,
public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] revGraph;

    static Queue<Integer> queue;
    static boolean[] isVisited;

    static boolean[][] canCompare;

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
        revGraph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(stn.nextToken());
            int second = Integer.parseInt(stn.nextToken());

            graph[first].add(second);
            revGraph[second].add(first);
        }
    }

    static void solve() {

        // i번째와 j번째가 연결되어 있는지를 저장하는 2차원 boolean 배열 초기화 
        canCompare = new boolean[N+1][N+1];

        /**
         * 위 문제의 핵심은 각 노드마다 원방향, 역방향 두 번 bfs를 탐색한다는 것
         * 그래야 해당 노드가 자신과의 연결 관계를 모두 확인할 수 있기 때문
         */
        for(int i=1; i<=N; i++) {
            // 원방향, 역방향 두 번 bfs 탐색하는 함수 
            bfsTwice(i);
        }
    }

    static void bfsTwice(int start) {
        queue = new LinkedList<>();
        isVisited = new boolean[N+1];

        isVisited[start] = true;
        queue.add(start);

        // 원방향 bfs 탐색 
        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int next: graph[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    canCompare[start][next] = true;
                    canCompare[next][start] = true;

                    queue.add(next);
                }
            }
        }

        // 원방향 bfs가 끝났으면, 다시 자신을 집어넣고
        queue.add(start);

        // 역방향 bfs 탐색 
        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int next: revGraph[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    canCompare[start][next] = true;
                    canCompare[next][start] = true;

                    queue.add(next);
                }
            }
        }
    }

    static void output() {
        
        for(int i=1; i<=N; i++) {

            int cnt = 0;
            /**
             * 연결관계를 저장한 canCompare 배열을 확인하며
             * false라면 i와 j의 순서를 정확히 모르는 것 -> 카운트 증가
             */
            for(int j=1; j<=N; j++) {
                if(i==j) continue;

                if(!canCompare[i][j]) cnt++;
            }
            System.out.println(cnt);
        }

    }

}
