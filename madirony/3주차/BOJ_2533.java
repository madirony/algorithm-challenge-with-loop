/*
  link : https://www.acmicpc.net/problem/2533
  tier : G3
  type : tree/dp
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		dp = new int[N+1][2];
		for(int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);
		dfs(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static int[][] dp;
	private static void dfs(int node, int p) {
		dp[node][0] = 0;
		dp[node][1] = 1;
		
		for(Integer c : list.get(node)) {
			if(c != p) {
				dfs(c, node);
				dp[node][0] += dp[c][1];
				dp[node][1] += Math.min(dp[c][0], dp[c][1]);
			}
		}
	}
}
