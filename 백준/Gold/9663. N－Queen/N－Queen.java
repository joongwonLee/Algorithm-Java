import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static int[] board;

    static int nQueens;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }

    /**
     * 2차원 보드판을 1차원 배열로 선언 가능
     * board[i] = j => i번째 행의 j번째 열에 queen이 놓여있음
     */
    static void solve() {
        board = new int[N];

        backtracking(0);
    }

    static void backtracking(int row) {

        // 마지막 행에 도착했을 때, nQueen의 수+1
        if(row==N) {
            nQueens++;
            return;
        }

        // 각 열을 돌면서 해당 위치가 가능한지 확인
        // 가능하면 다음 행으로
        for(int i=0; i<N; i++) {
            board[row] = i;
            if(canPos(row)) backtracking(row+1);
        }
    }

    // 해당 열에 queen을 놓을 수 있는지 판별
    // 1. 같은 열에 놓여있는 말이 있는지
    // 2. 대각선에 놓여있는 말이 있는지
    static boolean canPos(int row) {
        for(int i=0; i<row; i++) {
            // 같은 열 확인
            if(board[row]==board[i]) return false;
            // 대각선 확인
            if(row-i==Math.abs(board[row]-board[i])) return false;
        }
        return true;
    }

    static void output() {
        System.out.println(nQueens);
    }
}