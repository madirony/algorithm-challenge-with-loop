/*
  link : https://www.acmicpc.net/problem/3584
  tier : G4
  type : tree/graph/dfs/LCA
*/
import java.util.*;
import java.io.*;

class Main
{
	static int T, N, root, n1;
	static int[] tree;
	static boolean[] visited;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++){
			N = Integer.parseInt(br.readLine());
			tree = new int[N+1]; visited = new boolean[N+1];
			n1=0; int n2=0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if(i == N-1) {
					n1 = u; n2 = v; break;
				}
				tree[v] = u;
			}
			for(int i = 1; i <= N; i++) if(tree[i]==0){root = i; break;}
			check(n1, false);
			check(n2, true);
		}
	}
	
	private static void check(int node, boolean flag){
		if(!visited[node]) {
			visited[node] = true;
			check(tree[node], flag);
		}
		else if(flag && visited[node]) {
			// if(node == n1) node = tree[n1];
			if(node == 0) node = root;
			System.out.println(node);
			return;
		}
	}
}
