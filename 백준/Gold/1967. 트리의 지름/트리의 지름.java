
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int n;
    static ArrayList<int[]>[] nodeArrList;

    static boolean[] isVisited;

    static int firstMax;
    static int firstMaxNode;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nodeArrList = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) nodeArrList[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            stn = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(stn.nextToken());
            int second = Integer.parseInt(stn.nextToken());
            int dist = Integer.parseInt(stn.nextToken());

            nodeArrList[first].add(new int[]{second, dist});
            nodeArrList[second].add(new int[]{first, dist});
        }
    }

    static void solve() {
        firstMax = Integer.MIN_VALUE;
        isVisited = new boolean[n+1];
        isVisited[1] = true;
        calcDistance(1, 0);
        isVisited = new boolean[n+1];
        isVisited[firstMaxNode] = true;
        calcDistance(firstMaxNode, 0);
    }

    static void calcDistance(int node1, int dist) {

        if(firstMax<dist) {
            firstMax = dist;
            firstMaxNode = node1;
        }
        firstMax = Math.max(firstMax, dist);

        for(int[] node: nodeArrList[node1]) {
            int next = node[0];
            if(!isVisited[next]) {
                isVisited[next] = true;
                calcDistance(next, dist+node[1]);
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(firstMax);
        System.out.println(sb);
    }
}