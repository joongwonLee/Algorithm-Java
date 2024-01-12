import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static int[] numOfPlanet;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        output();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        numOfPlanet = new int[N+1];

        for(int i=1; i<=N; i++) {
            int planet = Integer.parseInt(br.readLine());
            numOfPlanet[i] = planet;
        }

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        sb = new StringBuffer();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int planetA = Integer.parseInt(stn.nextToken());
            int planetB = Integer.parseInt(stn.nextToken());

            // 이어져 있지 않은 은하라면, 은하를 잇고 행성 수를 더해줌 
            union(planetA, planetB);

            // 두 은하는 이미 이어져 있거나, 직전에 이어졌기 때문에 둘 중 하나의 루트 노드(은하)의 행성 수가 곧 이어진 모든 행성 수 
            int rootNumOfPlanet = numOfPlanet[find(planetA)];

            // 출력 수가 클 수 있기 때문에 StringBuffer에 담음 
            sb.append(rootNumOfPlanet).append("\n");

        }
    }

    // Find: 노드의 루트 노드를 반환
    static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    // Union: 두 노드의 루트 노드가 다르다면, 루트 노드끼리 병합
    // 병합이 되었을 때, 루트 노드의 행성 수에 (병합이 되는 루트 노드의 행성 수)를 더해줌 -> 이어져 있는 모든 행성 수가 더해짐
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        numOfPlanet[aRoot] += numOfPlanet[bRoot];
        return true;
    }

    static void output() {
        System.out.println(sb);
    }
}
