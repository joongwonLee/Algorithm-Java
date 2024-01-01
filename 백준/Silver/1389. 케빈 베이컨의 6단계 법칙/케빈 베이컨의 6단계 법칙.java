
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static ArrayList<Integer>[] friendship;

    static int minOfKevinBaconValue;
    static int minPerson;

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

        friendship = new ArrayList[N+1];
        for(int i=1; i<=N; i++) friendship[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());

            friendship[A].add(B);
            friendship[B].add(A);
        }
    }

    static void solve() {

        minOfKevinBaconValue = Integer.MAX_VALUE;
        minPerson = 0;
        // 모든 사람에 대해 케빈 베이컨 값을 계산
        // 두 친구의 케빈 베이켠 단계를 2차원 배열에 저장해서 한 번에 계산하는게 더 빠를듯
        for(int i=1; i<=N; i++) {
            calcKevinBacon(i);
        }
    }

    // 특정 사람에 대해 케빈 베이컨 수를 구하는 함수
    // BFS로 친구 관계 돌면서 몇 단계인지 곗간
    static void calcKevinBacon(int start) {

        // 단계를 구해야 하므로 boolean이 아닌, int형으로 방문 체크
        int[] isVisited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();

        // 시작점이 0이므로 나머지 값들은 -1로 초기화
        Arrays.fill(isVisited, -1);
        isVisited[start] = 0;
        queue.add(start);

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int next: friendship[now]) {
                if(isVisited[next]==-1) {
                    queue.add(next);
                    // 이전 친구에 대해 단계+1 해서 isVisited 갱신
                    isVisited[next] = isVisited[now]+1;
                }
            }
        }
        int sumOfKevinBacon = 0;
        // 친구 단계를 다 마쳤다면 모든 단계를 더해 케빈베이컨 단계 계산
        for(int i=1; i<=N; i++) {
            if(i==start) continue;
            sumOfKevinBacon += isVisited[i];
        }

        // 현재 케빈베이컨 수가 작다면 결과값을 그냥 갱신
        if(sumOfKevinBacon<minOfKevinBaconValue) {
            minPerson = start;
            minOfKevinBaconValue = sumOfKevinBacon;
        }
        // 값이 같다면 고유번호가 작은 사람으로 결과값 갱신
        else if(sumOfKevinBacon==minOfKevinBaconValue) {
            minPerson = Math.min(minPerson, start);
        }

//        System.out.println("start: "+start+", sum: "+sumOfKevinBacon);
//        System.out.println(minOfKevinBaconValue);
    }

    static void output() {
        System.out.println(minPerson);
    }
}
