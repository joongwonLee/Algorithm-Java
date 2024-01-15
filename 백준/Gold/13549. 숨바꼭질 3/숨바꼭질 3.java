import java.util.*;
import java.io.*;

public class Main {

    static class Point implements Comparable<Point> {
        int pos;
        int time;

        public Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, K;
    static PriorityQueue<Point> pq;
    static boolean[] isVisited;

    static int maxPos;

    static int fastTime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        dijkstra();
    }

    static void dijkstra() {

        maxPos = Math.max(N, K)*2+1;

        pq = new PriorityQueue<>();
        isVisited = new boolean[maxPos];

        pq.add(new Point(N, 0));

        while(!pq.isEmpty()) {

            Point now = pq.poll();

            if(now.pos == K) {
                fastTime = now.time;
                return;
            }

            if(isVisited[now.pos]) continue;
            isVisited[now.pos] = true;

            if(now.pos*2>=0&&now.pos*2<maxPos&&!isVisited[now.pos*2]) pq.add(new Point(now.pos*2, now.time));
            if(now.pos+1>=0&&now.pos+1<maxPos&&!isVisited[now.pos+1]) pq.add(new Point(now.pos+1, now.time+1));
            if(now.pos-1>=0&&now.pos-1<maxPos&&!isVisited[now.pos-1]) pq.add(new Point(now.pos-1, now.time+1));
        }
    }

    static void output() {
        System.out.println(fastTime);
    }
}
