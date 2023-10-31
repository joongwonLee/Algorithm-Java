
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	static StringBuffer sb;
	
	static int N, M;
	static String king;
	
//	static Map<String, String[]> graph;
	static Map<String, ArrayList<String>> parentToChild;
	static Map<String, String[]> childToParent;
	static Map<String, Integer> indegree;
	static Map<String, Double> bloodClass;
	
	static Set<String> persons;
	
	static Queue<String> queue;
	
	static String[] claims;

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
		
		king = br.readLine();
		
		parentToChild = new HashMap<>();
		childToParent = new HashMap<>();
		indegree = new HashMap<>();
		
		persons = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			stn = new StringTokenizer(br.readLine());
			
			String child = stn.nextToken();
			String firstParent = stn.nextToken();
			String secondParent = stn.nextToken();
			
			persons.add(child);
			persons.add(firstParent);
			persons.add(secondParent);
			
			ArrayList<String> firstChildList; 
			ArrayList<String> secondChildList;
			
//			graph.put(child, new String[] {firstParent, secondParent});
			if(parentToChild.get(firstParent)==null)firstChildList = new ArrayList<>();
			else firstChildList = parentToChild.get(firstParent);
			
			if(parentToChild.get(secondParent)==null)secondChildList = new ArrayList<>();
			else secondChildList = parentToChild.get(secondParent);
			
			firstChildList.add(child);
			secondChildList.add(child);
			
			parentToChild.put(firstParent, firstChildList);
			parentToChild.put(secondParent, secondChildList);
			
			childToParent.put(child, new String[] {firstParent, secondParent});
			
			indegree.put(child, indegree.getOrDefault(child, 0)+2);
		}
		
		claims = new String[M];
		
		for(int i=0; i<M; i++) {
			claims[i] = br.readLine();
		}
	}
	
	static void solve() {
		queue = new LinkedList<>();
		bloodClass = new HashMap<>();
	
		topologySort();
	}
	
	static void topologySort() {
		
//		queue.offer(king);
		bloodClass.put(king, 1.0);
		
		for(String person: persons) {
			if(indegree.get(person)==null) {
				queue.offer(person);
			}
		}
		
		
		while(!queue.isEmpty()) {
			String parent = queue.poll();
			
			if(parentToChild.get(parent)!=null) {
				
				for(String child: parentToChild.get(parent)) {
					indegree.put(child, indegree.get(child)-1);
					
					String firstParent = childToParent.get(child)[0];
					String secondParent = childToParent.get(child)[1];
					
					double firstParentBloodClass = (bloodClass.get(firstParent)==null) ? 0 : bloodClass.get(firstParent);
					double secondParentBloodClass = (bloodClass.get(secondParent)==null) ? 0 : bloodClass.get(secondParent);

					
					if(indegree.get(child)==0) {
						indegree.replace(child, -1);
						queue.offer(child);
						bloodClass.put(child, (firstParentBloodClass+secondParentBloodClass)/2);
					}
				}
			}
		}
	}
	
	static void output() {
		sb = new StringBuffer();
		
		double maxBlood = Double.MIN_VALUE;
		int maxBloodIdx=0;
		
		
		for(int i=0; i<claims.length; i++) {
			double bClass; 
			
			if(bloodClass.get(claims[i])!=null) {
				bClass = bloodClass.get(claims[i]);
				if(bClass > maxBlood) {
					maxBloodIdx = i;
					maxBlood = bClass;
				}
			}
		}
		
		
		sb.append(claims[maxBloodIdx]);
		
		System.out.println(sb);
	}

}
