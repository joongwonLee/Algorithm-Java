
import java.util.*;
import java.io.*;

public class Main {

    static class LANCable implements Comparable<LANCable> {

        int to;
        int length;

        public LANCable(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(LANCable cable) {
            return this.length-cable.length;
        }
    }

    static BufferedReader br;

    static int N;

    static ArrayList<LANCable>[] cables;
    static int[][] cableLengths;

    static int sumOfLAN;
    static int minOfConnectedLAN;
    static int connectedCnt;

    static PriorityQueue<LANCable> pq;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cables = new ArrayList[N+1];
        for(int i=1; i<=N; i++) cables[i] = new ArrayList<>();

        // 다솜이가 가진 전체 랜선 길이
        sumOfLAN = 0;

        // 임시로 랜선 길이를 저장하는 2차원 배열
        cableLengths = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            char[] lengths = br.readLine().toCharArray();

            for(int j=1; j<=N; j++) {
                // 전체 랜선 길이 갱신
                int len = charToLen(lengths[j-1]);
                sumOfLAN += len;

                // 랜선 x
                if(len==0) continue;

                // 같은 컴퓨터면 랜선 필요 x
                if(i==j) continue;

                // 다른 컴퓨터면 랜선 생성
//                cables[i].add(new LANCable(j, len));
//                cables[j].add(new LANCable(i, len));
                cableLengths[i][j] = len;
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                // 컴퓨터 A <-> 컴퓨터 B 끼리도 두 LAN의 길이가 다르기 때문에, MST를 구하기 위해서는 둘 중 작은 값이 필요
                if(cableLengths[i][j]==0) cableLengths[i][j] = cableLengths[j][i];
                else if(cableLengths[j][i]==0) cableLengths[i][j] = cableLengths[i][j];
                else cableLengths[i][j] = Math.min(cableLengths[i][j], cableLengths[j][i]);
            }
        }

        // 입력을 받을 때 랜선 길이만 저장하고, 랜선 생성을 안해줬으므로
        // 랜선 길이를 갱신한 후 랜선 추가 (i, j의 짝이 한 번씩만 나올 수 있게 2차원 순회)
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(cableLengths[i][j]==0||cableLengths[j][i]==0) continue;
                cables[i].add(new LANCable(j, cableLengths[i][j]));
                cables[j].add(new LANCable(i, cableLengths[i][j]));
            }
        }
    }

    // 알파벳을 랜선의 길이로 바꿔주는 함수
    // 소문자 알파벳: 1부터 26까지
    // 대문자 알파벳: 27부터 52까지
    static int charToLen(char c) {

        // '0'은 랜선 x
        if(c=='0') {
            return 0;
        }

        if(c-'A'>=0&&c-'A'<=25) {
            return c-'A'+27;
        } else {
            return c-'A'-31;
        }
    }

    static void solve() {
        prim();
    }

    // 프림 알고리즘으로 MST 계산
    static void prim() {

        pq = new PriorityQueue<>();
        isVisited = new boolean[N+1];

        pq.add(new LANCable(1, 0));
        minOfConnectedLAN = 0; // 모든 컴퓨터를 연결하는 랜선의 최소 길이
        connectedCnt = 0; // 컴퓨터 연결 횟수 -> 모든 컴퓨터가 연결되었는지 판별

        while(!pq.isEmpty()) {

            LANCable now = pq.poll();

            if(isVisited[now.to]) continue;
            isVisited[now.to] = true;
            minOfConnectedLAN += now.length;
            connectedCnt ++;

            for(LANCable next: cables[now.to]) {
                if(!isVisited[next.to]) {
                    pq.add(next);
                }
            }
        }
    }

    static void output() {
//        System.out.println(sumOfLAN+", "+minOfConnectedLAN);

        if(connectedCnt!=N) System.out.println(-1); // 컴퓨터가 모두 연결되지 않았을 때 -1
        else System.out.println(sumOfLAN-minOfConnectedLAN); // 모두 연결되었을 때, 전체 LAN 길이 - 최소 LAN 사용 길이 = 최대 LAN 기부 길이
    }
}
