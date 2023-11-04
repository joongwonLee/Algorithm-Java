
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	
	static int[] indegree;
	static PriorityQueue<Integer> queue;
	
	static ArrayList<Integer> result;

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
		
		indegree = new int[N+1];
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) graph[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			stn = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(stn.nextToken());
			int second = Integer.parseInt(stn.nextToken());
			
			graph[first].add(second);
			indegree[second]++;
		}
	}
	
	static void solve() {
		queue = new PriorityQueue<>();
		result = new ArrayList<>();
		
		topologySort();
	}
	
	static void topologySort() {
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			
			int nPro = queue.poll();
			result.add(nPro);
			
			for(int xPro: graph[nPro]) {
				indegree[xPro]--;
				if(indegree[xPro]==0) {
					queue.offer(xPro);
				}
			}
		}
		
	}
	
	static void output() {
		sb = new StringBuffer();
		for(int pro: result) sb.append(pro+" ");
		System.out.println(sb);
	}

}
