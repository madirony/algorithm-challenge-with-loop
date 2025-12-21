/*
  link : https://www.acmicpc.net/problem/12947
  tier : G4
  type : tree
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[] cnt;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); cnt = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCnt = 1;
		for(int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			nodeCnt += cnt[i];
		}
		for(int i = 0; i <= nodeCnt; i++) list.add(new ArrayList<>());

		int one = cnt[1];
		int root = 1, num = 1;
		List<Integer> tmpList = new ArrayList<>();
		for(int i = 1; i <= one; i++) {
			list.get(root).add(root+i);
			list.get(root+i).add(root);
			tmpList.add(root+i); num = root+i;
			cnt[1]--;
		}
		for(int i = 2; i <= N; i++) {
			List<Integer> nextList = new ArrayList<>();
			if(!tmpList.isEmpty()) {
				int size = tmpList.size();
				int j = 0;
				while(0 < cnt[i]) {
					num++;
					list.get(tmpList.get(j%size)).add(num);
					list.get(num).add(tmpList.get(j%size));
					nextList.add(num);
					j++; cnt[i]--;
				}
			}
			tmpList = new ArrayList<>(nextList);
		}
		visited = new boolean[nodeCnt+1];
		visited[1] = true;
		dfs(1, -1, 0);
		visited = new boolean[nodeCnt+1];
		visited[ans] = true;
		dfs(ans, -1, 0);
		System.out.println(ansValue);
	}
	
	static int ans = 0;
	static int ansValue = Integer.MIN_VALUE;
	static boolean[] visited; 
	
	private static void dfs(int node, int p, int sum) {
		if(ansValue < sum) {
			ans = node; ansValue = sum;
		}
		for(Integer i : list.get(node)) {
			if(i != p) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i, node, sum+1);
				}
			}
		}
	}
}
