
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	
	static Queue<Integer> queue;
	
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
		
		graph = new ArrayList[N+1];
		indegree = new int[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			stn = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(stn.nextToken());
			int second = Integer.parseInt(stn.nextToken());
			
			graph[first].add(second);
			indegree[second]++;
		}
		
	}
	
	static void solve() {
		queue = new LinkedList<>();
		result = new ArrayList<>();
		
		topologySort();
	}
	
	static void topologySort() {
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
				result.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for(int next: graph[now]) {
				indegree[next]--;
				
				if(indegree[next]==0) {
					queue.offer(next);
					result.add(next);
				}
			}
		}
	}
	
	static void output() {
		sb = new StringBuffer();
		for(int i=0; i<result.size(); i++) sb.append(result.get(i)+" ");
		System.out.println(sb);
	}

}
