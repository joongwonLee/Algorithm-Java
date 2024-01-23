
import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int data;
        Node parent;
        ArrayList<Node> childs;

        public Node(int data) {
            this.data = data;
            parent = null;
            childs = new ArrayList<>();
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, W;
    static Node[] tree;
    static ArrayList<Node>[] nodes;

    static int lowestNodeCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        W = Integer.parseInt(stn.nextToken());

        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new ArrayList<>();

        tree = new Node[N+1];
        for(int i=1; i<=N; i++) tree[i] = new Node(i);

        for(int i=0; i<N-1; i++) {
            stn = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(stn.nextToken());
            int v = Integer.parseInt(stn.nextToken());

            nodes[u].add(tree[v]);
            nodes[v].add(tree[u]);
        }
    }

    /**
     * 물이 고여 움직이지 않는 상태가 된다? -> 루트 노드에 있던 물들이 다 가장 하위 노드로 고였을 때의 상태
     * 결국 가장 하위 노드의 개수를 구하느 문제
     */
    static void solve() {
        lowestNodeCnt = 0;
        makeTree(1, -1); // 루트 노드 1로부터 트리 만들기
    }

    // depth 및 관계성이 정해지지 않은 그래프에 대해 트리를 만들어주는 함수
    // 트리의 모든 노드는 부모가 0개 or 1개인 점을 이용
    static void makeTree(int curNode, int parent) {

        int cnt = 0; // 자식 세는 카운트

        // 연결 노드 모두 확인
        for(Node node: nodes[curNode]) {
            // 부모가 아니라면 -> 자식이라는 뜻
            if(node.data!=parent) {
                cnt++; // 자식 카운트
                tree[curNode].childs.add(node); // 현 노드의 자식에 추가
                tree[node.data].parent = tree[curNode]; // 자식의 부모에 현 노드 추가
                makeTree(node.data, curNode);
            }
        }

        if(cnt==0) lowestNodeCnt++; // 만약 자식이 0이라면 가장 하위노드 수 증가
    }

    static void output() {
        System.out.println((double)W/(double)lowestNodeCnt);
    }

}
