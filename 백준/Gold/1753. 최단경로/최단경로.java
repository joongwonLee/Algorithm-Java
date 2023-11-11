import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end ;
    int weight;
    public Node(int end, int weight) {
        super();
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        // 작은 것들을 기준으로 
        return this.weight - o.weight;
    }
}
public class Main {
    static int vertNum ;
    static int edgeNum ;
    static int startNum ;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException{
        graph = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startNum  = Integer.parseInt(st.nextToken());
        for (int i = 0; i < vertNum+1; i++) {
            graph.add(new ArrayList());
        }
        for (int i = 0; i <edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }
        int[] answerList = dijkstra(startNum);
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
    static int[] dijkstra(int startNum) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(startNum, 0));
        int[] bestshortList = new int[vertNum+1];
        boolean[] isVisitedList = new boolean[vertNum+1];
        Arrays.fill(bestshortList, Integer.MAX_VALUE);
        bestshortList[startNum] = 0;
        while(!q.isEmpty()) {
            Node curNode = q.poll();//Node에서 정의된 기준의 따라 우선순위를 결정한다. 
            // 그 순서대로 뺀다. 
            int curPos = curNode.end;

            if (isVisitedList[curPos]) continue;
            isVisitedList[curPos] = true;
            for (Node nextNode : graph.get(curPos)) {
                //현재 포즈의 있는 노드 값들을 싹 다 가져온다.
                //!isVisitedList[nextNode.end]&&
                if (bestshortList[nextNode.end]>bestshortList[curPos]+nextNode.weight) {
                    bestshortList[nextNode.end] = bestshortList[curPos]+nextNode.weight;
                    q.add(new Node(nextNode.end, bestshortList[nextNode.end]));
                }
            }
        }
        return bestshortList;
    }
}