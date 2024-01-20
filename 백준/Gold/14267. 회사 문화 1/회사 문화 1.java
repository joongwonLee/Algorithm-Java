
import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int data;
        ArrayList<Node> childNode = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }
    }

    static BufferedReader br;
    static StringTokenizer stn;

    static int n, m;
    static ArrayList<Node> tree;

    static int[] directCompliments;
    static boolean[] isVisited;

    static int[] complimentsPerStaff;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        output();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());

        tree = new ArrayList<>();
        tree.add(null); // 0번째 리스트를 null로 채워넣기
        for(int i=1; i<=n; i++) tree.add(new Node(i)); // i번째 리스트 - i번 노드로 채워넣기

        stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int directBoss = Integer.parseInt(stn.nextToken());
            if(directBoss==-1) continue; // -1이면 루트 노드

            Node bossNode = tree.get(directBoss);
            Node staff = tree.get(i);
            bossNode.childNode.add(staff); // 직속 상사와 직원 연결
        }

        complimentsPerStaff = new int[n+1];
        directCompliments = new int[n+1];

        for(int i=0; i<m; i++) {
            stn = new StringTokenizer(br.readLine());

            int staff = Integer.parseInt(stn.nextToken());
            int compliment = Integer.parseInt(stn.nextToken());
            directCompliments[staff] += compliment;
        }

        isVisited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            if(!isVisited[i]) {
                calcCompliment(tree.get(i), directCompliments[i]);
            }
        }
    }

    static void calcCompliment(Node staff, int compliment) {

        isVisited[staff.data] = true;
        complimentsPerStaff[staff.data] += compliment; // 첫 칭찬을 받은 직원의 칭찬 수 갱신

        for(Node child: staff.childNode) {
            if(!isVisited[child.data]) {
                complimentsPerStaff[child.data] += complimentsPerStaff[staff.data];
                calcCompliment(child, directCompliments[child.data]); // 자신의 직원에게 칭찬 넘기기 (재귀 호출)
            }
        }
    }

    static void output() {
        for(int i=1; i<=n; i++) {
            System.out.print(complimentsPerStaff[i]+" ");
        }
    }
}
