
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int t;
    static int n;
    static String[] strArr;

//    static ArrayList<Node> nodeList;
    static Node rootNode;

    static boolean isConsistent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        strArr = new String[n];

        for(int i=0; i<n; i++) strArr[i] = br.readLine();
    }

    static void solve() {
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        rootNode = new Node(-1, false);

//        nodeList = new ArrayList<>();
        for(int i=0; i<strArr.length; i++) {
            useTrie(strArr[i]);
            if(!isConsistent) return;
        }
    }

    static void useTrie(String str) {
        char[] charArr = str.toCharArray();
        boolean isInnodeList = false;
        Node nowNode = rootNode;
        isConsistent = true;

//        if(nodeList.size()==0) {
//            if(charArr.length==1) nodeList.add(new Node(charArr[0]-'0', true));
//            else nodeList.add(new Node(charArr[0]-'0', false));
//            nowNode = nodeList.get(0);
//        }
//        else {
//            for(Node node: nodeList) {
//                if(node.data==charArr[0]-'0') {
//                    isInnodeList = true;
//                    nowNode = node;
//                }
//            }
//            if(!isInnodeList) {
//                if(charArr.length==1) nodeList.add(new Node(charArr[0]-'0', true));
//                else nodeList.add(new Node(charArr[0]-'0', false));
//                nowNode = nodeList.get(nodeList.size()-1);
//            }
//        }

        for(int i=0; i<charArr.length; i++) {
            if(charArr[i]==' ') continue;
            int data = charArr[i]-'0';
            if(nowNode.children.containsKey(data)) {
                nowNode = nowNode.children.get(data);
                if (nowNode.isEnd) {
                    isConsistent = false;
                    return;
                }
            }
            else {
                if(i==charArr.length-1) nowNode.children.put(data, new Node(data, true));
                else nowNode.children.put(data, new Node(data, false));
                nowNode = nowNode.children.get(data);
            }
        }
    }

    static void output() {
        sb = new StringBuffer();
        if(isConsistent) sb.append("YES");
        else sb.append("NO");

        System.out.println(sb);
    }

    static class Node {
        int data;
        boolean isEnd;
        Map<Integer, Node> children = new HashMap<>();

        public Node(int data, boolean isEnd) {
            this.data = data;
            this.isEnd = isEnd;
        }
    }
}
