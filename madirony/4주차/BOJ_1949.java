/*
  link : https://www.acmicpc.net/problem/1949
  tier : G2
  type : tree/dp
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N, res = 0;
	static int[] pop, ans;
	static List<List<Integer>> list = new ArrayList<>();
	static int[][] arr;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pop = new int[N+1]; ans = new int[N+1];
		arr = new int[N+1][2];
		for(int i = 1; i <= N; i++) pop[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		dfs(1, 0, -1);
		dfs(1, 1, -1);
		System.out.println(res);
		
	}
	private static int dfs(int node, int select, int p) {
		if(0 < arr[node][select]) return arr[node][select];
		int sum = select == 1 ? pop[node] : 0;
		for(Integer i : list.get(node)) {
			if(i != p) {
				if(select == 1) sum += dfs(i, 0, node);
				else sum += Math.max(dfs(i, 0, node), dfs(i, 1, node));
			}
		}
		res = Math.max(res, sum);
		return arr[node][select] = sum;
	}
}
