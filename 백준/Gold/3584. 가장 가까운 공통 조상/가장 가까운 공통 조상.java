
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T, N;
    static Node[] nodes;
    static int firstNode, secondNode;

    static int commonParent;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];

        for(int i=0; i<N+1; i++) {
            nodes[i] = new Node();
            nodes[i].data = i;
            nodes[i].parent = null;
            nodes[i].children = new ArrayList<>();
        }
        for(int i=1; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());

            nodes[A].children.add(nodes[B]);
            nodes[B].parent = nodes[A];
        }

        stn = new StringTokenizer(br.readLine());
        firstNode = Integer.parseInt(stn.nextToken());
        secondNode = Integer.parseInt(stn.nextToken());
    }

    static void solve() {
        commonParent = 0;

        Node firstParent = nodes[firstNode];
        ArrayList<Integer> firstParentList = new ArrayList<>();
        firstParentList.add(firstParent.data);

        while(firstParent!=null) {
            firstParentList.add(firstParent.data);
            firstParent = firstParent.parent;
        }

//        for(int num: firstParentList) {
//            System.out.println(num);
//        }

        Node secondParent = nodes[secondNode];
        while(secondParent!=null) {
            if(firstParentList.contains(secondParent.data)) {
                commonParent = secondParent.data;
                break;
            }
            secondParent = secondParent.parent;
        }
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(commonParent);
        System.out.println(sb);
    }
}

class Node {
    int data;
    Node parent;
    ArrayList<Node> children;
}