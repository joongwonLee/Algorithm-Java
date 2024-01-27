
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int T, N, M;
    static int[] parents;

    static boolean haveCycle;
    static Set<Integer> rootSet;

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
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        make();
        haveCycle = false;

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int edgeA = Integer.parseInt(stn.nextToken());
            int edgeB = Integer.parseInt(stn.nextToken());

            // 사이클이 있다면 -> haveCycle 표시
            if(!union(edgeA, edgeB)) haveCycle = true;
        }
    }

    /**
     * 그래프가 트리인지 아닌지 판별
     * 1. 주어진 모든 노드에 대해 한 노드에서 모든 노드까지 이동 가능 (root 노드를 통해 판별)
     *  1-1. 모든 노드에 대해 루트 노드를 탐색하고 루트 노드의 개수가 1인지 판별 
     * 2. 사이클이 없어야 함 
     *  2-1. union을 할 때 false 값을 뱉으면 사이클이 있음 
     */
    static void solve() {

        // root 노드를 담는 set
        rootSet = new HashSet<>();

        for(int i=1; i<=N; i++) {
            rootSet.add(find(i)); // 모든 노드에 대해 root 노드를 set에 저장 
        }
    }

    // Make: 노드의 parent 초기화 
    static void make() {
        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;
    }

    // Union: 두 노드에 대해 루트 노드가 다르다면, 병합 
    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return false;
        parents[rootA] = rootB;
        return true;
    }

    // Find: 특정 노드의 루트 노드 반환 
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        // 만약 1. 해당 그래프의 로트 노드가 1개이고, 2. 사이클이 없다면 -> tree로 판별 
        if(rootSet.size()==1&&!haveCycle) System.out.println("tree");
        // 아니라면 graph로 판별 
        else System.out.println("graph");
    }
}
