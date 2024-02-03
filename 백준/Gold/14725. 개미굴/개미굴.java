import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, K;
    static Trie trie;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    /**
     * Trie(트라이)라는 자료구조를 이용해 문제 해결
     * 1. Trie: 트리 형태의 자료구조로, 하나의 노드가 map 형태의 childNodes와 마지막 노드를 뜻하는 isLast 변수 가짐
     * 2. map.computeIfAbsent 함수를 이용해 편하게 노드에 해당 키 값이 있는지 판단 후, 새로운 Trie 노드 추가
     * 3. 모든 노드를 추가한 후에 해당 Trie를 출력해주기만 하면 끝!
     */
    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        trie = new Trie();

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            K = Integer.parseInt(stn.nextToken());
            String[] strArr = new String[K];

            for(int j=0; j<K; j++) {
                strArr[j] = stn.nextToken();
            }

            trie.insert(strArr);
        }

        output(0, trie.rootNode);
    }

    // Trie의 childNode를 depth 별로 재귀 호출하며 출력
    static void output(int depth, TrieNode trieNode) {

        // childNode의 사이즈가 0이라면 -> 마지막 노드라는 뜻
        if(trieNode.childNodes.isEmpty()) return;

        // 해당 depth에서 key를 알파벳 오름차순으로 정렬
        List<String> keySet = new ArrayList<>(trieNode.childNodes.keySet());
        Collections.sort(keySet);

        for(String key: keySet) {
            for(int i=0; i<depth; i++) {
                System.out.print("--"); // depth 별로 출력 템플릿 맞추기
            }
            System.out.println(key); // key로 저장되어 있는 string 값 출력
            output(depth+1, trieNode.childNodes.get(key)); // depth+1와 해당 노드의 childNode를 넣고 출력 함수 재귀호출
        }
    }

    // Trie 노드
    static class TrieNode {
        Map<String, TrieNode> childNodes = new HashMap<>(); // map 형태의 childNode
        boolean isLast; // 마지막 노드인가를 의미하는 boolean 데이터
    }

    // Trie 노드를 트리형태로 가지고 있는 Trie 자료구조
    static class Trie {

        TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        // 입력으로 들어온 String 배열을 trie에 삽입
        void insert(String[] strs) {

            TrieNode node = rootNode;
            for(int i=0; i<strs.length; i++) {
                // ChildNode에 해당 string 값이 key 값으로 있는지 확인 후 없으면 새로운 trieNode 생성 후 삽입
                node = node.childNodes.computeIfAbsent(strs[i], s -> new TrieNode());
            }
            node.isLast = true;
        }
    }
}
