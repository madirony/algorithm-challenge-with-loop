/*
  link : https://www.acmicpc.net/problem/2263
  tier : G1
  type : tree/divide and conquer/recursion
*/

import java.util.*;
import java.io.*;

class Main
{
	static int n;
	static int[][] inpost;
	static boolean[][] visited;
	static Map<Integer, Integer> inmap = new HashMap<>();
	static Map<Integer, Integer> postmap = new HashMap<>();
	static int[] ans;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inpost = new int[2][n]; visited = new boolean[2][n];
		ans = new int[n];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()){
				inpost[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) inmap.put(inpost[i][j], j);
				else postmap.put(inpost[i][j], j);
				j++;
			}
		}

		makePre(0, n-1, 0, inpost[1][n-1]);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ans.length; i++) sb.append(ans[i]).append(" ");
		System.out.println(sb);
	}
  
	private static void makePre(int rangeL, int rangeR, int ansidx, int root) {
		int tmp = inmap.get(root);
		ans[ansidx] = inpost[0][tmp];
		int inRootIdx = inmap.get(root);
		int postRootIdx = postmap.get(root);
		int leftSize = inRootIdx-rangeL;
		int rightSize = rangeR-inRootIdx;
		
		if(leftSize == 1) {
			int leftElement = inpost[0][inRootIdx-1];
			makePre(rangeL, inRootIdx-1, ansidx+1, leftElement);
		}
		else if(1 <= leftSize) {
			int leftElement = inpost[1][postRootIdx-rightSize-1];
			makePre(rangeL, inRootIdx-1, ansidx+1, leftElement);
		}
		
		if(rightSize == 1) {
			int rightElement = inpost[0][inRootIdx+1];
			makePre(inRootIdx+1, rangeR, ansidx+leftSize+1, rightElement);
		}
		else if(1 <= rightSize) {
			int rightElement = inpost[1][postRootIdx-1];
			makePre(inRootIdx+1, rangeR, ansidx+leftSize+1, rightElement);
		}
	}
}
