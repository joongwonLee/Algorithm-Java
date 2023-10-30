
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<Integer>[] graph;

    // 각 노드의 진입차수를 기록하는 배열
    static int[] indegree;
    
    // 위상 정렬에 사용될 queue
    // int 배열 첫 번째 요소에 child를, 두 번째 요소에 depth를 저장
    static Queue<int[]> queue;
    
    // 위상 정렬을 이용해 나온 결과를 저장할 배열
    // 데이터가 i인 노드에 대해 result[i]는 그의 깊이를 저장
    static int[] result;

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

        graph = new ArrayList[N+1];
        indegree = new int[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        //(번호가 작은) 선수 과목을 parent로 지정
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(stn.nextToken());
            int child = Integer.parseInt(stn.nextToken());

            graph[parent].add(child);
            // 그래프로 봤을 때, parent -> child이므로 child의 진입차수+1
            indegree[child] += 1;
        }
    }

    static void solve() {
        // queue와 위상정렬 결과를 담을 result 배열 초기화 후
        queue = new LinkedList<>();
        result = new int[N+1];
        // 위상 정렬 
        topologySort();
    }

    // 위상 정렬 함수
    static void topologySort() {

        // 진입 차수가 0인 노드와 그의 시작 깊이 1을 queue에 담고,
        // result 배열에 결과 저장 
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) {
                queue.offer(new int[]{i, 1});
                result[i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            // 현재 노드를 queue에서 빼내고,
            int[] now = queue.poll();

            // 현재 노드의 child 순회
            for(int next: graph[now[0]]) {
                // now 노드를 끊어줌 => child 노드의 진입차수 -1
                indegree[next] -= 1;
                // child 노드의 진입차수가 0일 때 queue에 담음 
                if(indegree[next]==0) {
                    queue.offer(new int[]{next, now[1]+1});
                    result[next] = now[1]+1;
                }
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        // 각 노드의 depth를 출력 
        for(int i=1; i<=N; i++) sb.append(result[i]+" ");
        System.out.println(sb);
    }
}


/*
위상 정렬(topology Sort)이란?
사이클이 없는 방향 그래프(DAG)를 정렬하는 알고리즘 

1. 그래프 생성 시 각 노드의 진입 차수(indegree) 기록 
2. queue 혹은 재귀 호출을 통해 위상 정렬 구현
    2-1. indegree가 0인 노드를 queue에 담고(offer), 
    2-2. 해당 노드를 빼낸 후(pull) 노드를 제거 -> child의 indegree 1 감소
    2-3. queue가 비어있을 때 까지 2-1, 2-2 반복 
 */