
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N;
    static int[][] map;

    static ArrayList<Integer> allPerson;

    static int minDiff;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        allPerson = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            stn = new StringTokenizer(br.readLine());

            // 사람 번호 리스트 초기화 (1~N)
            allPerson.add(i);
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
    }

    static void solve() {
        minDiff = Integer.MAX_VALUE;
        combination(0, 1, new ArrayList<Integer>());
    }

    static void combination(int cnt, int start, ArrayList<Integer> teamStart) {

        if(cnt==(N/2)) {
            minDiff = Math.min(minDiff, calcAbilityDiff(teamStart));
            return;
        }

        for(int i=start; i<=N; i++) {
            teamStart.add(i);
            combination(cnt+1, i+1, teamStart);
            teamStart.remove(teamStart.indexOf(i));
        }
    }

    static int calcAbilityDiff(ArrayList<Integer> teamStart) {

        int teamStartAbilitySum = 0;
        int teamLinkAbilitySum = 0;

        ArrayList<Integer> teamLink = new ArrayList<Integer>();

        for(int person: allPerson) {
            if(!teamStart.contains(person)) {
                teamLink.add(person);
            }
        }

        for(int i=0; i<teamStart.size()-1; i++) {
            for(int j=i; j<teamStart.size(); j++) {
                int iPer = teamStart.get(i);
                int jPer = teamStart.get(j);
                teamStartAbilitySum += (map[iPer][jPer]+map[jPer][iPer]);
            }
        }

        for(int i=0; i<teamLink.size()-1; i++) {
            for(int j=i; j<teamLink.size(); j++) {
                int iPer = teamLink.get(i);
                int jPer = teamLink.get(j);
                teamLinkAbilitySum += (map[iPer][jPer]+map[jPer][iPer]);
            }
        }

        return Math.abs(teamStartAbilitySum - teamLinkAbilitySum);
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(minDiff);
        System.out.println(sb);
    }
}