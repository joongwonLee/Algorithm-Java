import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static boolean[][] friendShip;
    static int[] numOfFriend;

    static int minOfFriend;

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

        friendShip = new boolean[N+1][N+1];
        numOfFriend = new int[N+1];

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(stn.nextToken());
            int second = Integer.parseInt(stn.nextToken());

            friendShip[first][second] = true;
            friendShip[second][first] = true;

            numOfFriend[first] ++;
            numOfFriend[second] ++;
        }
    }

    /**
     * 문제의 핵심은 세 사람이 모두 친구여야 한다는 것
     * 고려하지 않고 조합으로 모두 뽑아냈을 때 -> 시간초과
     * 
     * 3중 for 문으로 조건 가지치기 
     */
    static void solve() {
        minOfFriend = Integer.MAX_VALUE;

        for(int A = 1; A <= N; A++) {

            for(int B = A+1; B<=N; B++) {
                // A와 B가 친구가 아닐 때 넘어가기
                if(!friendShip[A][B]) continue;
                
                for(int C = B+1; C<=N; C++) {
                    // A와 C가 친구가 아니거나, B와 C가 친구가 아닐 때 넘어가기 
                    if(!friendShip[A][C] || !friendShip[B][C]) continue;
                    // 모두 친구일 때 min 값 갱신 
                    minOfFriend = Math.min(minOfFriend, (numOfFriend[A] + numOfFriend[B] + numOfFriend[C] - 6));
                }
            }
        }
    }

    static void output() {
        if(minOfFriend == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minOfFriend);
    }
}