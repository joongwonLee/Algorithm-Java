
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N;
    static int X, xIdx;
    static int[] numArr;
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
            if(numArr[i]==-1) xIdx = i;
        }
        X = Integer.parseInt(br.readLine());
        numArr[xIdx] = X;
    }

    static void solve() {
        Arrays.sort(numArr);
        divideAndConquer(0, N-1);
    }

    static void divideAndConquer(int start, int end) {
        if(end==start){
            stack.push(numArr[end]);
            return;
        }

        int mid = (start+end)/2;
        stack.push(numArr[mid]);
        divideAndConquer(mid+1, end);
        divideAndConquer(start, mid-1);
    }

    static void output() {
        sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb);
    }
}
