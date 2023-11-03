
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N;
    static int[] popul; // 각 도시의 인구 수
    static ArrayList<Integer>[] graph; // 인접한 도시 정보

    static boolean[] isSelected; // powerset 만들기 위한 int형 배열

    static int minDiff;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        popul = new int[N+1];

        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) popul[i] = Integer.parseInt(stn.nextToken());

        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            stn = new StringTokenizer(br.readLine());

            int connCnt = Integer.parseInt(stn.nextToken());
            for(int j=0; j<connCnt; j++) {
                int connCity = Integer.parseInt(stn.nextToken());
                graph[i].add(connCity);
            }
        }
    }

    static void solve() {
        isSelected = new boolean[N+1];
        minDiff = 1000;

        powerset(1);
    }

    static void powerset(int cnt) {

        if(cnt==N) {

            ArrayList<Integer> cities1 = new ArrayList<>();
            ArrayList<Integer> cities2 = new ArrayList<>();

            for(int i=1; i<=N; i++) {
                if(isSelected[i]) cities1.add(i);
                else cities2.add(i);
            }


            if(cities1.size()!=0&&cities2.size()!=0&&isConnected(cities1, cities2)) {
                int sumOfCities1 = 0; int sumOfCities2 = 0;

                for(int city: cities1) sumOfCities1 += popul[city];
                for(int city: cities2) sumOfCities2 += popul[city];

                minDiff = Math.min(minDiff, Math.abs(sumOfCities1-sumOfCities2));
            }

            return;
        }

        isSelected[cnt] = true;
        powerset(cnt+1);

        isSelected[cnt] = false;
        powerset(cnt+1);

    }

    // powerset을 통해 나뉜 두 지역에서 각 지역 내 도시들이 모두 인접한지 체크하는 함수
    static boolean isConnected(ArrayList<Integer> cities1, ArrayList<Integer> cities2) {

//        for(int city: cities1) System.out.print(city+" ");
//        System.out.println();
//        for(int city: cities2) System.out.print(city+" ");
//        System.out.println();

//        for(int i=0; i<cities1.size(); i++) {
//            int now = cities1.get(i);
//            boolean flag = false;
//            for(int j=0; j<cities1.size(); j++) {
//                if(i==j) continue;
//                if(graph[cities1.get(j)].contains(now)) flag = true;
//            }
//            if(!flag) return false;
//        }
//
//        for(int i=0; i<cities2.size(); i++) {
//            int now = cities2.get(i);
//            boolean flag = false;
//            for(int j=0; j<cities2.size(); j++) {
//                if(i==j) continue;
//                if(graph[cities2.get(j)].contains(now)) flag = true;
//            }
//            if(!flag) return false;
//        }
//
//        return true;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[cities1.size()];
        int cnt = 1;

        isVisited[0] = true;
        queue.offer(cities1.get(0));

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int next: graph[now]) {
                int idx = cities1.indexOf(next);
                if(cities1.contains(next)&&!isVisited[idx]) {
                    isVisited[idx] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }

        if(cnt!=cities1.size()) return false;

        queue = new LinkedList<>();
        isVisited = new boolean[cities2.size()];
        cnt = 1;

        isVisited[0] = true;
        queue.offer(cities2.get(0));

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int next: graph[now]) {
                int idx = cities2.indexOf(next);
                if(cities2.contains(next)&&!isVisited[idx]) {
                    isVisited[idx] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }

        if(cnt!=cities2.size()) return false;

        return true;

    }

    static void output() {
        sb = new StringBuffer();
        if(minDiff==1000) sb.append(-1);
        else sb.append(minDiff);
        System.out.println(sb);
    }
}
