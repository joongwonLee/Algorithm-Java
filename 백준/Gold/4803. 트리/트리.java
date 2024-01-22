
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int n, m;
    static int treeCnt;

    static boolean endFlag;
    static boolean[] cycleFlag;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        endFlag = false; // 0 0이 입력으로 들어왔을 때 종료 플래그

        for(int i=1; ;i++) {
            input();
            if(endFlag) return;
            solve();
            output(i);
        }
    }

    static void input() throws IOException {
        stn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());

        if(n==0&&m==0) {
            endFlag = true; // 종료 선언
            return;
        }

        parents = new int[n+1];
        for(int i=1; i<=n; i++) parents[i] = i;

        cycleFlag = new boolean[n+1];

        for(int i=0; i<m; i++) {
            stn = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(stn.nextToken());
            int nodeB = Integer.parseInt(stn.nextToken());

            // 만약 union이 안되는 경우 -> 사이클 개수+1
            if(!union(nodeA, nodeB)) {
                cycleFlag[find(nodeA)] = true;
            }
        }

    }

    static void solve() {

        treeCnt = 0;
        // 모든 노드에 대해 Union-Find를 실행한 후
        Set<Integer> set = new HashSet<>();

        // 모든 노드에 대한 부모 노드를 set에 저장해 tree의 개수 판별
        for(int i=1; i<=n; i++) {
            int root = find(i);
            if(!cycleFlag[root]) {
                set.add(find(i));
            }
//            System.out.println(find(i));
        }

        // 트리의 개수 = set의 개수
        treeCnt = set.size();
    }

    // Union: 두 노드의 부모 노드가 다르다면, 두 노드의 부모노드를 병합
    // 만약 false가 리턴된다면, 사이클이 형성된다는 뜻
    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return false;

        int min = Math.min(rootA, rootB);
        int max = Math.max(rootA, rootB);
        parents[max] = min;
        if(cycleFlag[max]) cycleFlag[min] = true;
        if(cycleFlag[min]) cycleFlag[max] = true;
        return true;
    }

    // Find: 특정 노드의 부모 노드 반환
    static int find(int x) {

        if(cycleFlag[x]) cycleFlag[parents[x]] = true;

        if(parents[x]==x) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output(int i) {
        if(treeCnt==0) System.out.println("Case "+i+": No trees.");
        else if(treeCnt==1) System.out.println("Case "+i+": There is one tree.");
        else System.out.println("Case "+i+": A forest of "+treeCnt+" trees.");
    }

}
