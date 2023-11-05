
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	// 도시의 개수 n, 버스의 개수 m
	static int n, m;
	// 각 정점 사이의 비용를 저장하는 int형 배열, 경로가 없으면 0
	static int[][] costMap;
	
	static final int INF = 99999999;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		costMap = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			stn = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(stn.nextToken());
			int end = Integer.parseInt(stn.nextToken());
			int cost = Integer.parseInt(stn.nextToken());
			
			// 기존 경로 비용이 더 길면 갱신, 아님 기존 비용으로 저장 
			if(costMap[start][end]!=0) costMap[start][end] = Math.min(costMap[start][end], cost);
			// 기존 경로 비용이 없을땐 그대로 비용 저장 
			else costMap[start][end] = cost;
		}
	}
	
	static void solve() {
		floydWarshall();
	}
	
	// 플로이드 워샬 알고리즘으로 각 노드들의 최소 비용 계산
	static void floydWarshall() {
		
		// 초기 입력 데이터에서 갈 수 없는 경로는 큰 수로 값 지정
		// 그렇지 않으면 최소 비용을 계산할 때, 0으로 값이 들어가 결과값 이상하게 나옴 
		for(int i=1; i<=costMap.length-1; i++) {
			for(int j=1; j<=costMap.length-1; j++) {
				if(i==j) continue;
				if(costMap[i][j]==0) costMap[i][j] = INF;
			}
		}
		
		// 지나쳐 가는 경로 path
		for(int path=1; path<=costMap.length-1; path++) {
			// 모든 정점을 돌면서 pass를 지나가는 경로와 기존 경로 비교 후 최소 비용 저장 
			for(int i=1; i<=costMap.length-1; i++) {
				if(i==path) continue;
				for(int j=1; j<=costMap.length-1; j++) {
					if(j==i || j==path) continue;
					costMap[i][j] = Math.min(costMap[i][j], (costMap[i][path]+costMap[path][j]));
				}
			}
		}
		
		for(int i=1; i<=costMap.length-1; i++) {
			for(int j=1; j<=costMap.length-1; j++) {
				if(costMap[i][j]==INF) {
					costMap[i][j]=0;
				}
			}
		}
		
	}
	
	static void output() {
		for(int i=1; i<=costMap.length-1; i++) {
			for(int j=1; j<=costMap[0].length-1; j++) {
				System.out.print(costMap[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
