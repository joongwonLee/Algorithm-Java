
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int vertNum ;
    static int edgeNum ;
    static int startNum ;

    static List<List<MyNode>> graph;

    static int[] answerList;

    public static void main(String[] args) throws IOException{
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        vertNum = Integer.parseInt(stn.nextToken());
        edgeNum = Integer.parseInt(stn.nextToken());

        graph = new ArrayList();

        stn = new StringTokenizer(br.readLine());
        startNum  = Integer.parseInt(stn.nextToken());

        for (int i = 0; i < vertNum+1; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i <edgeNum; i++) {
            stn = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stn.nextToken());
            int end = Integer.parseInt(stn.nextToken());
            int weight = Integer.parseInt(stn.nextToken());

            graph.get(start).add(new MyNode(end, weight));
        }
    }

    static void solve() {
        answerList = dijkstra(startNum);
    }

    static int[] dijkstra(int startNum) {
        PriorityQueue<MyNode> q = new PriorityQueue<>();
        q.add(new MyNode(startNum, 0));
        int[] bestshortList = new int[vertNum+1];
        boolean[] isVisitedList = new boolean[vertNum+1];
        Arrays.fill(bestshortList, Integer.MAX_VALUE);
        bestshortList[startNum] = 0;
        while(!q.isEmpty()) {
            MyNode curNode = q.poll();//Node에서 정의된 기준의 따라 우선순위를 결정한다.
            // 그 순서대로 뺀다.
            int curPos = curNode.end;

            if (isVisitedList[curPos]) continue;
            isVisitedList[curPos] = true;
            for (MyNode nextNode : graph.get(curPos)) {
                //현재 포즈의 있는 노드 값들을 싹 다 가져온다.
                //!isVisitedList[nextNode.end]&&
                if (bestshortList[nextNode.end]>bestshortList[curPos]+nextNode.weight) {
                    bestshortList[nextNode.end] = bestshortList[curPos]+nextNode.weight;
                    q.add(new MyNode(nextNode.end, bestshortList[nextNode.end]));
                }
            }
        }
        return bestshortList;
    }

    static void output(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answerList.length; i++) {
            if (answerList[i]==Integer.MAX_VALUE) {

                sb.append("INF").append("\n");
            }else {
                sb.append(answerList[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}


class MyNode implements Comparable<MyNode>{

    int end ;
    int weight;

    public MyNode(int end, int weight) {
        super();
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(MyNode o) {
        // 작은 것들을 기준으로
        return this.weight - o.weight;
    }
}