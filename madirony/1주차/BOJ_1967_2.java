/*
  link : https://www.acmicpc.net/problem/1967
  tier : G4
  type : tree/graph/dfs
*/

import java.util.*;
import java.io.*;

class Main
{
	static class Node {
		int v, w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	static List<List<Node>> list = new ArrayList<>();
	static boolean[] visited;
	static int farthestSum = -1, farthestIdx = -1;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
		for(int i = 0; i < n-1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Node(v, w));
			list.get(v).add(new Node(u, w));
		}
		
		int ans = -1;
		visited = new boolean[n+1];
		int res = dfs(1, 0);
		ans = Math.max(ans, res);
		
		visited = new boolean[n+1];
		farthestSum = -1; ans = -1;
		res = dfs(farthestIdx, 0);
		ans = Math.max(ans, res);
		
		System.out.println(ans);
	}
	
	private static int dfs(int p, int sum){
	    visited[p] = true;
	    int best = sum;
	    boolean hasChild = false;
	
	    for (Node tmp : list.get(p)){
	        if (visited[tmp.v]) continue;
	        hasChild = true;
	        int val = dfs(tmp.v, sum + tmp.w);
	        best = Math.max(best, val);
	    }
	
		if(farthestSum < sum) {
			farthestSum = sum;
			farthestIdx = p;
		}
	    if (!hasChild) return sum;
	    return best;
	}
}
