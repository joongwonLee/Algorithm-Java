import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int N;
    static Trie trie;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    /**
     * Trie를 이용해 디렉토리 구조 출력
     * 1. 입력을 String으로 받고, "\"를 기준으로 split 하여 String 배열로 저장
     * 2. trie 자료구조에 String 배열을 insert
     * 3. 입력을 다 받고 나면 루트 노드에서 자식 노드를 순회하며 출력
     */
    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        trie = new Trie();

        for(int i=0; i<N; i++) {
            String dir = br.readLine();
            String[] dirs = dir.split("\\\\"); // "\"를 나누는걸 \\\\ 이런식으로 한다,, why??

            trie.insert(dirs);
        }

        sb = new StringBuffer();
        output(0, trie.rootNode);
        System.out.println(sb);
    }


    static void output(int depth, TrieNode node) {

        // 자식 노드가 비어있다면 리턴 (가장 하단 노드)
        if(node.childNodes.isEmpty()) return;

        List<String> keySet = new ArrayList(node.childNodes.keySet());
        Collections.sort(keySet); // 같은 depth의 노드들에 대해 key를 오름차순으로 정렬

        for(String key: keySet) {
            for(int i=0; i<depth; i++) {
//                System.out.print(" "); // 디렉토리 깊이 표현
                sb.append(" ");
            }
            sb.append(key+"\n");
//            System.out.println(key);
            output(depth+1, node.childNodes.get(key)); // depth+1, 해당 노드의 자식 노드에 대해 출력 함수 재귀호출
        }
    }

    // Trie 자료구조에 쓰이는 Trie 노드
    static class TrieNode {
        Map<String, TrieNode> childNodes; // 자식 노드를 String:TrieNode 형태의 Map으로 저장

        public TrieNode() {
            childNodes = new HashMap<>();
        }
    }

    // 루트 노드(TrieNode)를 가지고 있는 Trie 자료구조
    static class Trie {
        TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        // 해당 Trie에 String 배열을 삽입하는 함수
        public void insert(String[] dirs) {
            TrieNode node = rootNode;
            for(int i=0; i<dirs.length; i++) {
                node = node.childNodes.computeIfAbsent(dirs[i], s->new TrieNode()); // Map에 해당 key가 없다면, 해당 key에 대한 Trie Node 생성 후 삽입
            }
        }
    }
}
