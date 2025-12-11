/*
  link : https://www.acmicpc.net/problem/22253
  tier : G1
  type : tree/dp/graph/dfs
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[] arr;
	static List<List<Integer>> list = new ArrayList<>();
	static long[][][] dp;
	static final int MOD = 1000000007;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1]; dp = new long[N+1][2][11];
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < 2; j++) Arrays.fill(dp[i][j], -1);
		}
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		long ans = dfs(1, 0, 0, -1);
		ans += dfs(1, 1, arr[1], -1);
		System.out.println(ans%MOD);
		
	}
	
	private static long dfs(int node, int selection, int max, int p) {
		if(dp[node][selection][max] != -1) return dp[node][selection][max];
		long sum = selection == 0 ? 0 : 1;
		for(Integer i : list.get(node)) {
			if(i != p) {
				sum += dfs(i, 0, max, node) % MOD;
				if(max <= arr[i]) sum += dfs(i, 1, arr[i], node) % MOD;
			}
		}
		return dp[node][selection][max] = sum;
	}
}
