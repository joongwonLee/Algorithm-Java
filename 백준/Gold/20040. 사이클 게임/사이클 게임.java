
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int n, m;
    static int[] parents;

    static int cycleOrder;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        output();
    }

    // Union-Find를 이용해 사이클이 있는지 확인
    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());

        parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i; // 자기 자신을 부모로 초기화

        cycleOrder = 0;

        for(int i=1; i<=m; i++) {
            stn = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());

            /**
             * union 함수 호출
             * 만약 두 점의 루트노드가 같다면? -> 사이클이 있다는 뜻
             * 다르다면 -> 사이클은 없는 상태이고, union 함수를 호출함으로서 두 노드를 병합
             */
            if(!union(a, b)) {
                cycleOrder = i;
                return;
            }
        }
    }

    // Union: 두 노드에 대해 루트 노드가 다르다면 루트 노트 병합
    static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    // Find: 특정 노드에 대해 루트 노드를 반환
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        System.out.println(cycleOrder);
    }

}
