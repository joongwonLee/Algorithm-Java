import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int[] parents;

    static int[] timelines;

    static int goOutsideCnt;

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

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int buildingA = Integer.parseInt(stn.nextToken());
            int buildingB = Integer.parseInt(stn.nextToken());

            union(buildingA, buildingB);
        }

        timelines = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            timelines[i] = Integer.parseInt(stn.nextToken());
        }
    }

    /**
     * Union-Find를 이용해 두 노드가 연결되어 있는지 확인
     * 강의 시간표가 정해져 있으므로, i번째 강의와 i+1번째 강의의 parent가 같은지 확인
     * 다르다면 밖에 나와야 하는 횟수 + 1
     */
    static void solve() {

        // 해강이가 밖에 나가는 횟수
        goOutsideCnt = 0;

        // 정해진 시간표 순회
        for(int i=0; i<N-1; i++) {

            // 이전 수업의 루트 노드와 이후 수업의 루트 노드 비교
            int preRoot = find(timelines[i]);
            int postRoot = find(timelines[i+1]);

            // 만약 두 루트 노드가 다르다면 건물이 연결이 안되어 있다는 뜻 -> 밖으로 나가는 횟수 +1
            if(preRoot!=postRoot) goOutsideCnt++;
        }
    }

    // Union: 두 노드의 루트 노드가 다르다면, 두 노드의 루트 노드를 병합
    static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    // Find: 노드의 루트 노드 반환
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        System.out.println(goOutsideCnt);
    }

}
