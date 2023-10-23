
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N;
    // 대체될 수 X와 -1로 입력받을 위치인 xIdx
    static int X, xIdx;
    static int[] numArr;

    // 후위순회한 결과를 넣을 stack
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        xIdx = 0;

        stack = new Stack<>();

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(stn.nextToken());
            // -1이 들어왔을 때 해당 인덱스 저장 
            if(numArr[i]==-1) xIdx = i;
        }
        
        // 대체할 수 입력받은 후
        X = Integer.parseInt(br.readLine());
        // -1이 들어온 인덱스에 대체 
        numArr[xIdx] = X;
    }

    static void solve() {
        // 배열 정렬 후
        Arrays.sort(numArr);
        // 분할 정복 
        divideAndConquer(0, N-1);
    }
    
    // 트리 문제이지만, 분할 정복으로 해결할 수 있는 규칙 존재 
    static void divideAndConquer(int start, int end) {
        
        // 마지막 leaf node가 들어왔을 때 stack에 push
        if(end==start){
            stack.push(numArr[end]);
            return;
        }

        // 중간 인덱스의 값(root node)이 맨 뒤로 가는 구조 
        int mid = (start+end)/2;
        stack.push(numArr[mid]);
        // 뒤쪽부터 분할 정복 함수 재귀 호출 
        divideAndConquer(mid+1, end);
        divideAndConquer(start, mid-1);
    }

    static void output() {
        sb = new StringBuffer();
        // 뒤쪽 요소부터 push했고, 
        // 앞쪽부터 출력해야 하므로 stack pop하면서 출력 
        while(!stack.isEmpty()) {
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb);
    }
}
