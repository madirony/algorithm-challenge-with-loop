/*
  link : https://www.acmicpc.net/problem/9885
  tier : G4
  type : tree/graph/dfs
*/

import java.util.*;
import java.io.*;

class Main
{
	static int n, ans = 0;
	static List<List<Node>> list = new ArrayList<>();
	static class Node {
		int v, w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int[] grades;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		boolean[] rootcheck = new boolean[n+1];
		grades = new int[n+1];
		for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int thisnode = Integer.parseInt(st.nextToken());
			int parnode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(parnode).add(new Node(thisnode, weight));
			rootcheck[thisnode] = true;
		}
		int root = 0;
		for(int i = 1; i <= n; i++) if(!rootcheck[i]) { root = i; break; }
		getGrade(root, 0);
		dfs(root, grades[root]);
		System.out.println(ans);
	}
	
	private static void dfs(int node, int sum) {
		for(Node i : list.get(node)) {
			ans = Math.max(ans, sum+grades[i.v]);
			dfs(i.v, sum+grades[i.v]);
		}
	}
	
	private static int getGrade(int node, int pv) {
		int sv = 0;
		for(Node i : list.get(node)) {
			int cv = getGrade(i.v, pv+i.w);
			sv += cv + i.w;
		}
		grades[node] = sv+pv;
		return sv;
	}
}
