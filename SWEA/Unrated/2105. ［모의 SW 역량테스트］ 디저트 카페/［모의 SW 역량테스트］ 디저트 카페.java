import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int T, N;
	static int[][] map;
	static int ans = -1;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int StartR, StartC;

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/디저트카페.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = -1;
			N = sc.nextInt();
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// print(map);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					StartR = r;
					StartC = c;
					boolean[] dessert = new boolean[100 + 1];
					dessert[map[r][c]] = true;
					dfs(r, c, 0, 1, dessert);

				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	private static void dfs(int r, int c, int sdir, int cnt, boolean[] dessert) {


		for (int d = sdir; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 지도밖으로 나가면 continue;
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			// 출발점과 같다면 도착한것임 (3칸이상 이동해야 한다)
			if (nr == StartR && nc == StartC && cnt > 2) {
				ans = Math.max(ans, cnt);
				return;
			}

			// 이미먹어본 디저트라면 continue;
			if (dessert[map[nr][nc]])
				continue;

			dessert[map[nr][nc]] = true;
			dfs(nr, nc, d, cnt + 1, dessert);
			dessert[map[nr][nc]] = false;
		}
	}

	private static void print(boolean[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}