/*
  link : https://www.acmicpc.net/problem/2533
  tier : G3
  type : tree/dfs(fail)
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
		int a = dfs(1, false, -1);
		int b = dfs(1, true, -1);
		System.out.println(Math.min(a,b));
	}
	
	private static int dfs(int node, boolean flag, int p) {
		int sum = 0;
		if(!flag) {
			for(Integer c : list.get(node)) {
				if(c != p) sum += dfs(c, true, node);
			}
			return sum;
		}
		
		sum = 1;
		for(Integer c : list.get(node)) {
			if(c != p) {
			sum += Math.min(dfs(c, true, node), dfs(c, false, node));
			}
		}
		return sum;
	}
}
