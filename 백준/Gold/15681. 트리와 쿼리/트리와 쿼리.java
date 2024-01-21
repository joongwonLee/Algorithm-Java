import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int data;
        Node parent;
        ArrayList<Node> childs;

        public Node(int data) {
            this.data = data;
            this.parent = null;
            this.childs = new ArrayList<>();
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, R, Q;

    static ArrayList<Node>[] tree;
    static Node[] nodes;

    static int[] subtreeNodesCnt;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        R = Integer.parseInt(stn.nextToken());
        Q = Integer.parseInt(stn.nextToken());

        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();

        nodes = new Node[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new Node(i);

        for(int i=0; i<N-1; i++) {
            stn = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(stn.nextToken());
            int V = Integer.parseInt(stn.nextToken());

            tree[U].add(nodes[V]);
            tree[V].add(nodes[U]);
        }

        makeTree(R, -1); // 루트 노드와 -1(부모 노드 x)로 트리 생성

        subtreeNodesCnt = new int[N+1]; // 각 노드 당 가지고 있는 subtree 노드들의 개수 (자신 포함)
        calcSubTreeNodes(R);

        for(int i=0; i<Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(subtreeNodesCnt[query]);
        }
        
    }

    /**
     * 입력으로 들어온 노드 간 관계를 루트 노드를 기준으로 정의
     * 1. 현재 노드와 연결되어 있는 노드를 모두 확인
     *  1-1. 트리의 특성 상 특정 노드의 부모는 0개 or 1개, 나머지는 모두 자식들
     * 2. 연결되어 있는 노드가 부모가 아니라면
     *  2-1. 해당 노드의 자식들에 추가, 자식들의 부모에 해당 노드 추가
     * 3. 연결된 자식들을 현재 노드로, 현재 노드를 부모 노드로 하여 함수 재귀 호출
     */
    static void makeTree(int curNode, int parent) {

        // 1. 연결된 노드 모두 확인
        for(Node child: tree[curNode]) {
            // 인자로 들어온 부모 값이 아니라면,
            if(child.data!=parent) {
                nodes[curNode].childs.add(child); // 현재 노드의 자식들 추가
                child.parent = nodes[curNode]; // 현재 노드를 자식들의 부모로 추가
                makeTree(child.data, curNode); // 자식 -> 현재 노드, 현재 노드 -> 부모 노드로 하여 함수 재귀 호출
            }
        }
    }

    /**
     * 해당 노드에 대해 그의 서브 트리 노드 개수 계산
     * 1. 자신의 서브트리 노드 개수를 1로 초기화 (자기 자신을 포함하기 때문)
     * 2. 자신의 자식들을 돌면서 calcSubTreeNodes(자식 번호) 재귀 호출
     * 3. 서브트리 노드 개수가 1인 노드부터 계산되며 그 계산된 값을 자신의 개수 값에 추가
     */
    static void calcSubTreeNodes(int curNode) {
        subtreeNodesCnt[curNode] = 1;

        // 1. 자신의 자식 노드 순회
        for(Node child: nodes[curNode].childs) {
            calcSubTreeNodes(child.data); // 2. 자식 노드의 서브 트리 개수 계산
            subtreeNodesCnt[curNode] += subtreeNodesCnt[child.data]; // 3. 계산한 값을 자신의 값에 추가
        }
    }

}
