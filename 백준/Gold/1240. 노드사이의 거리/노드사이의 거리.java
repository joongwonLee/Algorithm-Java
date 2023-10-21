
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<int[]>[] nodeArrList;

    static boolean[] isVisited;

    static int distResult;


    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        nodeArrList = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) nodeArrList[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stn.nextToken());
            int second = Integer.parseInt(stn.nextToken());
            int dist = Integer.parseInt(stn.nextToken());

            nodeArrList[first].add(new int[]{second, dist});
            nodeArrList[second].add(new int[]{first, dist});
        }

        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stn.nextToken());
            int end = Integer.parseInt(stn.nextToken());

            solve(start, end);
        }
    }

    static void solve(int start, int end) {
        isVisited = new boolean[N+1];
        distResult = 0;
        isVisited[start] = true;
        dfs(start, end, 0);
        sb.append(distResult+"\n");
    }

    static void dfs(int start, int end, int dist) {

        if(start==end) {
            distResult = dist;
            return;
        }

        for(int[] nodeInfo: nodeArrList[start]) {
            int next = nodeInfo[0];
            if(!isVisited[next]) {
                isVisited[next] = true;
                dfs(next, end, dist+nodeInfo[1]);
            }
        }
    }

    static void output() {
        System.out.println(sb);
    }
}
