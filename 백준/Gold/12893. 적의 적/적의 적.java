import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int[] parents;

    static int[] enemy;
    static boolean estabTheory;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        output();
    }

    /**
     * Union-Find로 풀이
     * 여기서 적인 관계를 union하는 것이 아니라, 우호적인 관계만 union 관계로 이루어져 있음
     *
     * 1. 두 적 관계인 사람에 대해 find로 root 탐색
     *  1-1. 만약 root가 같다면, 우호 관계이므로 이론 성립 x
     *  1-2. root가 다르다면, 적대 관계 o 2단계로 디ㅗㅇ
     * 2. a의 적 관계 파악
     *  2-1. 만약 적 관계가 있다면 -> b와 해당 적을 union
     *  2-2. 만약 적 관계가 없다면 -> a의 적 관계를 b로 설정
     * 3. b의 적 관계도 파악
     */
    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        make();
        estabTheory = true;
        enemy = new int[N+1];

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int personA = Integer.parseInt(stn.nextToken());
            int personB = Integer.parseInt(stn.nextToken());

            int rootA = find(personA);
            int rootB = find(personB);

            // 두 적 관계인 사람이 우호 관계라면 -> 이론 성립 x 바로 리턴
            if(rootA==rootB) {
                estabTheory = false;
                return;
            }

            if(enemy[personA]==0) enemy[personA] = rootB; // A의 적 관계가 없을 때 적 관계를 B로 설정 
            else union(enemy[personA], rootB); // A의 적 관계가 있을 때 -> 해당 적 관계와 B를 적 그룹으로 union

            if(enemy[personB]==0) enemy[personB] = rootA;
            else union(enemy[personB], rootA);
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

        parents[rootA] = rootB;
        return true;
    }

    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static void output() {
        if(estabTheory) System.out.println(1);
        else System.out.println(0);
    }

}
