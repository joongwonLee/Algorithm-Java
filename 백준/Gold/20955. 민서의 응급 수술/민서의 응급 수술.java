
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int[] parents;

    static int minOperCnt;

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

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        minOperCnt = 0;

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(stn.nextToken());
            int v = Integer.parseInt(stn.nextToken());

            // union의 리턴 값이 false인 경우: 사이클이 생긴 경우
            // 연산 횟수+1을 하며 간선을 끊어내기
            if(!union(u, v)) minOperCnt++;
        }
    }

    static void solve() {

        Set<Integer> set = new HashSet<>();

        // 모든 노드의 부모 노드를 set에 저장 -> 나뉘는 트리 개수 카운트
        for(int i=1; i<=N; i++) {
            set.add(find(i));
        }

        // 트리를 합치는 연산 횟수 = 나뉘는 트리 개수 -1
        minOperCnt += set.size()-1;
    }

    // Union: 두 노드에 대해 부모 노드가 다르다면, 두 노드의 부모 노드 병합
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return false;
        parents[rootA] = rootB;
        return true;
    }

    // Find: 특정 노드의 부모 노드 반환
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        System.out.println(minOperCnt);
    }
}
