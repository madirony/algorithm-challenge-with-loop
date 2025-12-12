/*
  link : https://www.acmicpc.net/problem/13016
  tier : P5
  type : tree/graph/dfs/dijkstra(?)
*/

import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static class Node {
		int v, len, p = -1;
		Node(int v, int len) {
			this.v = v;
			this.len = len;
		}
		Node(int v, int len, int p) {
			this.v = v;
			this.len = len;
			this.p = p;
		}
	}
	static List<List<Node>> list = new ArrayList<>();
	
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, length));
			list.get(to).add(new Node(from, length));
		}
		
		dfs(1, 0, 0);
		
		arr1 = new int[N+1];
		arr2 = new int[N+1];
		Arrays.fill(arr1, Integer.MAX_VALUE);
		Arrays.fill(arr2, Integer.MAX_VALUE);
		
		dijkstra(max, -1, arr1);
		
		int maxLen = -1;
		for(int i = 1; i <= N; i++) {
			if(arr1[i] != Integer.MAX_VALUE && maxLen < arr1[i]) {
				maxLen = arr1[i];
				max = i;
			}
		}
		
		dijkstra(max, -1, arr2);
        
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(arr1[i] == Integer.MAX_VALUE) sb.append(arr2[i]).append('\n');
			else if(arr2[i] == Integer.MAX_VALUE) sb.append(arr1[i]).append('\n');
			else if(arr1[i] <= arr2[i]) sb.append(arr2[i]).append('\n');
			else sb.append(arr1[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	static int[] arr1, arr2;
	
	private static void dijkstra(int v, int p, int[] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.len - o2.len;
		});
		pq.add(new Node(v, 0, p));
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			for(Node i : list.get(tmp.v)) {
				if(i.v != tmp.p) {
					if(tmp.len + i.len < arr[i.v]) {
						arr[i.v] = tmp.len + i.len;
						pq.add(new Node(i.v, arr[i.v], tmp.v));
					}
				}
			}
		}
	}
	
	static int maxLen = -1, max = -1;
	
	private static void dfs(int node, int d, int p) {
		for(Node i : list.get(node)) {
			if(i.v != p) {
				if(maxLen < d+i.len) {
					maxLen = d+i.len;
					max = i.v;
				}
				dfs(i.v, d+i.len, node);
			}
		}
	}
}
