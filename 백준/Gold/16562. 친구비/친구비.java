import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M, K;
    static int[] friendCosts;

    static int[] parents;

    static int minCostToMakeFriend;

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
        K = Integer.parseInt(stn.nextToken());

        friendCosts = new int[N+1];
        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) friendCosts[i] = Integer.parseInt(stn.nextToken());

        make();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int studentV = Integer.parseInt(stn.nextToken());
            int studentW = Integer.parseInt(stn.nextToken());

            union(studentV, studentW);
        }
    }

    /**
     * 모든 사람을 친구로 만드는데 드는 최소 비용
     * 1. union을 할 때 친구 비용을 기준으로 root 결정 (친구 비용이 작은 노드가 root 노드가 됨)
     * 2. 1~N까지 모든 노드에 대해 root 노드를 set에 저장
     * 3. set을 순회하면서 root 노드들의 친구 비용을 더하기
     */
    static void solve() {

        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++) {
            // 모든 관계가 형성된 노드에 대해
            // 각 노드 별 루트 노드를 set에 저장
            set.add(find(i));
        }

        minCostToMakeFriend = 0;

        for(int roots: set) {
            // root 노드들의 친구 비용 추가 
            minCostToMakeFriend += friendCosts[roots];
        }
    }

    static void make() {
        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;
    }

    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return false;

        int friendCostA = friendCosts[rootA];
        int friendCostB = friendCosts[rootB];

        // 친구 비용이 작은 노드가 parent 노드가 됨
        if(friendCostA<friendCostB) parents[rootB] = rootA;
        else parents[rootA] = rootB;

        return true;
    }

    static int find(int x) {
        if (x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        if(minCostToMakeFriend<=K) System.out.println(minCostToMakeFriend);
        else System.out.println("Oh no");
    }

}
