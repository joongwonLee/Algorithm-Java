import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;
    static int numOfPersonWhoKnowsTruth;
    static int[] personsWhoKnowsTruth;

    static int[] parents;

    static ArrayList<Integer>[] parties;

    static int numOfLies;

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

        stn = new StringTokenizer(br.readLine());

        numOfPersonWhoKnowsTruth = Integer.parseInt(stn.nextToken()); // 진실을 아는 사람 수
        personsWhoKnowsTruth = new int[numOfPersonWhoKnowsTruth]; // 진실을 아는 사람 배열
        for(int i=0; i<numOfPersonWhoKnowsTruth; i++) {
            personsWhoKnowsTruth[i] = Integer.parseInt(stn.nextToken());
        }

        // union-find를 위한 parent 배열
        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        // party에 오는 사람의 정보 저장 배열
        parties = new ArrayList[M];
        for(int i=0; i<M; i++) parties[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());

            int numOfPersonWhoComeParty = Integer.parseInt(stn.nextToken());
            for(int j=0; j<numOfPersonWhoComeParty; j++) {
                int person = Integer.parseInt(stn.nextToken());
                parties[i].add(person);

                if(j==0) continue;
                // 이전 사람과 현재 입력으로 들어온 사람을 union-find로 관계 생성
                int prePerson = parties[i].get(j-1);
                union(person, prePerson);
            }
        }
     }

     static void solve() {

        // 전체 파티 수 M에서 진실을 아는 사람이 있는 파티의 수를 빼서 결과값 도출
        numOfLies = M;

        for(int i=0; i<M; i++) {

            int numOfTruth = 0;

            for(int j=0; j<parties[i].size(); j++) {
                // 해당 파티에서 진실을 아는 사람 카운트
                if(knowTheTruthOrNot(parties[i].get(j))) {
                    numOfTruth++;
                }
            }

            // 진실을 아는 사람이 있다면 -> 거짓말 쳐도 되는 파티의 수 -1
            if(numOfTruth!=0) numOfLies--;
        }
     }

     static boolean knowTheTruthOrNot(int person) {

        // 진실을 아는 사람 리스트 순회
        for(int i=0; i<personsWhoKnowsTruth.length; i++) {
            // 진실을 아는 사람과 비교하려는 사람의 루트 노드 비교
            int kRoot = find(personsWhoKnowsTruth[i]);
            int pRoot = find(person);

//            System.out.println("person: "+person+", personRoot: "+pRoot+", k: "+personsWhoKnowsTruth[i]+" , kRoot: "+kRoot);

            // 루트 노드가 같다면 -> 진실을 알 수 있음
            if(kRoot==pRoot) return true;
        }

        // 진실을 아는 사람 중 루트 노드가 같은 사람이 없다면 -> 진실을 알 수 없음
        return false;
     }

     // Union: 두 노드의 루트 노드가 다르다면, 두 노드의 루트 노드를 병합
     static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
     }

     // Find: 노드의 루트 노드 반환
     static int find(int x) {
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
     }

     static void output() {
        System.out.println(numOfLies);
     }
}
