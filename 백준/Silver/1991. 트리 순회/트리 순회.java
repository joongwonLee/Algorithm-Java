import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            char parent = stn.nextToken().charAt(0);
            char leftChild = stn.nextToken().charAt(0);
            char rightChild = stn.nextToken().charAt(0);

            insertNode(head, parent, leftChild, rightChild);
        }
    }

    static void solve() {
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }

    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        Node(char data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    // 노드 삽입 함수
    static void insertNode(Node temp, char parent, char leftChild, char rightChild) {

        /**
         * 첫 Head(비교) 노드와 parent 노드를 비교
         * 만약 비교 노드와 parent가 같으면 -> left child와 right child를 생성
         * 다르면 -> 비교 노드를 leftChild와 rightChild로 하여 함수 재귀 호출 
         *      결국 비교 노드와 parent가 일치하면서 노드가 삽입됨 
         */
        if(temp.data == parent) {
            temp.leftChild = (leftChild == '.') ? null : new Node(leftChild, null, null);
            temp.rightChild = (rightChild == '.') ? null : new Node(rightChild, null, null);
        }
        else {
            if(temp.leftChild != null) insertNode(temp.leftChild, parent, leftChild, rightChild);
            if(temp.rightChild != null) insertNode(temp.rightChild, parent, leftChild, rightChild);
        }
    }

    // 트리 전위 순회
    static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
    // 트리 중위 순회
    static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.leftChild);
        System.out.print(node.data);
        inOrder(node.rightChild);
    }
    // 트리 후위 순회
    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data);
    }

}
