
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	static int N, L, R;
	static int[][] popul;
	
	static boolean[][] isVisited;
	static Queue<int[]> queue;
	
	// 국경선이 바뀌었는지 체크 
	// changed==0이면, while문 break;후 결과 출력 
	static int changed;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	
	static int movingDay;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stn = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stn.nextToken());
		L = Integer.parseInt(stn.nextToken());
		R = Integer.parseInt(stn.nextToken());
		
		popul = new int[N][N];
		for(int i=0; i<N; i++) {
			stn = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				popul[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
	}
	
	static void solve() {
		
		movingDay = 0;
		
		while(true) {
			isVisited = new boolean[N][N];
			changed = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!isVisited[i][j]) {
						BFS(i, j);
					}
				}
			}
			
			if(changed!=0) movingDay++;
			else break;
		}
		
	}
	
	static void BFS(int x, int y) {
		queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		isVisited[x][y] = true;
		
		int sumPopul = 0;
		int cnt = 1;
		
		ArrayList<int[]> opened = new ArrayList<>();
		opened.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			
			int[] now = queue.poll();
			sumPopul += popul[now[0]][now[1]];
			
			for(int i=0; i<dx.length; i++) {
				int nX = now[0]+dx[i];
				int nY = now[1]+dy[i];
				
				if(inRange(nX, nY)&&!isVisited[nX][nY]) {
					int diff = Math.abs(popul[now[0]][now[1]]-popul[nX][nY]);
//					System.out.println("now[0]: "+now[0]+", now[1]: "+now[1]+", nX: "+nX+", nY: "+nY+", diff: "+diff);
					if(diff>=L&&diff<=R) {
						isVisited[nX][nY] = true;
						queue.offer(new int[] {nX, nY});
						opened.add(new int[] {nX,nY});
						cnt++;
					}
				}
			}
		}
		
		int changedPopul;
		if(cnt!=1) {
			changed++;
			changedPopul = sumPopul/cnt;
			
			for(int[] pos: opened) {
				popul[pos[0]][pos[1]] = changedPopul;
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	static void output() {
		sb = new StringBuffer();
		sb.append(movingDay);
		System.out.println(sb);
	}

}
