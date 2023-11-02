
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	static int N, M;
	static int[][] map;
	
	static ArrayList<int[]> virusList; // 바이러스(2)의 위치를 담고 있는 배열
	static int wallCnt; // 벽(1)의 개수
	static ArrayList<int[]> emptyList; // 빈 칸(0)의 위치를 담고 있는 배열 
	
	static Queue<int[]> queue;
	static boolean[][] isVisited;
	static ArrayList<int[]> spread;

	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	
	static int maxSafeArea;
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stn = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stn.nextToken());
		M = Integer.parseInt(stn.nextToken());
		
		virusList = new ArrayList<>();
		wallCnt = 0;
		emptyList = new ArrayList<>();
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			stn = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
				if(map[i][j]==1) wallCnt++;
				else if(map[i][j]==2) virusList.add(new int[] {i, j});
				else emptyList.add(new int[] {i, j});
			}
		}
	}
	
	static void solve() {
		maxSafeArea = Integer.MIN_VALUE;
		
		combination(0, 0, new ArrayList<>());
	}
	
	static void combination(int cnt, int start, ArrayList<int[]> changeList) {
		
		if(cnt==3) {
			for(int[] change: changeList) map[change[0]][change[1]] = 1;
			
			queue = new LinkedList<>();
			isVisited = new boolean[N][M];
			spread = new ArrayList<>();
			BFS();
			maxSafeArea = Math.max(maxSafeArea, calcSafeArea());
			for(int[] spr: spread) {
				map[spr[0]][spr[1]] = 0;
			}
			
			for(int[] change: changeList) map[change[0]][change[1]] = 0;
			
			return;
		}
		
		for(int i=start; i<emptyList.size(); i++) {
			changeList.add(emptyList.get(i));
			combination(cnt+1, i+1, changeList);
			changeList.remove(changeList.indexOf(emptyList.get(i)));
		}
		
	}
	
	static void BFS() {
		
		for(int[] virus: virusList) {
			queue.add(new int[] {virus[0], virus[1]});
			isVisited[virus[0]][virus[1]] = true;
		}
		
		while(!queue.isEmpty()) {
			int[] nowV = queue.poll();
			
			for(int i=0; i<dx.length; i++) {
				int nextVX = nowV[0]+dx[i];
				int nextVY = nowV[1]+dy[i];
				
				if(inRange(nextVX, nextVY)&&!isVisited[nextVX][nextVY]&&map[nextVX][nextVY]==0) {
					isVisited[nextVX][nextVY] = true;
					map[nextVX][nextVY] = 2;
					queue.add(new int[] {nextVX, nextVY});
					spread.add(new int[] {nextVX, nextVY});
				}
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		
		return x>=0&&x<N&&y>=0&&y<M;
	}
	
	static int calcSafeArea() {
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static void output() {
		sb = new StringBuffer();
		sb.append(maxSafeArea);
		
		System.out.println(sb);
	}

}
