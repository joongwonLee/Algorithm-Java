
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int islandA, islandB;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        for(int i=0; i<N-2; i++) {
            stn = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());

            union(a, b);
        }
    }

    /**
     * Union-Find로 각 노드의 관계를 정의하고, 
     * 한 개의 다리만 끊어졌음이 보장됐으므로 노드 1과 나머지 노드 중 루트 노드가 다른 노드를 찾음 (무조건 다른 노드가 있음이 보장)
     */
    static void solve() {
        islandA = 1; islandB = 2;
        if(N==2) return;

        int root = find(1);

        for(int i=2; i<=N; i++) {
            int otherRoot = find(i);

            if(root!=otherRoot) {
                islandB = i;
                return;
            }
        }
    }

    // Union: 두 노드의 root 노드가 다르다면 root 노드 병합 
    static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    // Find: 노드의 root 노드 반환 
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        System.out.print(islandA+" "+islandB);
    }
}
