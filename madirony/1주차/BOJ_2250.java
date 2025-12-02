/*
  link : https://www.acmicpc.net/problem/2250
  tier : G2
  type : tree/graph/dfs
*/

import java.util.*;
import java.io.*;

class Main
{
	static int N, root;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>(2));
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++) set.add(i);
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			list.get(num).add(c1);
			set.remove(c1);
			list.get(num).add(c2);
			set.remove(c2);
		}
		//1
		for(Integer i : set) {
			root = i;
			break;
		}
		//2
		childArr = new int[N+1][2];
		childCal(root);
		
		//3
		idxArr = new int[N+1];
		idxCal(root, 0, 0, false, 0);
		
		int idx = 1, ans = 1;
		for(Integer i : map.keySet()){
			List<Integer> list = map.get(i);
			int max = Collections.max(list);
			int min = Collections.min(list);
			int sum = max-min+1;
			if(ans < sum) {
				idx = i+1;
				ans = sum;
			}
		}
		System.out.println(idx + " " + ans);
	}
	
	static int[][] childArr;
	static int[] idxArr;
	static Map<Integer, List<Integer>> map = new TreeMap<>();
	
	
	static void idxCal(int v, int pi, int pv, boolean flag, int level) {
		List<Integer> tmp = list.get(v);
		int left = list.get(v).get(0), right = list.get(v).get(1);
		if(root == v) {
			if(left != -1) idxCal(left, 0, childArr[v][0], false, level+1);
			if(right != -1) idxCal(right, 0, childArr[v][1], true, level+1);
		}
		else {
			if(flag) idxArr[v] = pi + pv - childArr[v][1];
			else idxArr[v] = pi - pv + childArr[v][0];
			if(!map.containsKey(level)) {
				List<Integer> tmpList = new ArrayList<>();
				tmpList.add(idxArr[v]);
				map.put(level, tmpList);
			}
			else{
				List<Integer> tmpList = map.get(level);
				tmpList.add(idxArr[v]);
				map.put(level, tmpList);
			}

			if(right != -1) idxCal(right, idxArr[v], childArr[v][1], true, level+1);
			if(left != -1) idxCal(left, idxArr[v], childArr[v][0], false, level+1);
		}
	}
	
	static int childCal(int v) {
		List<Integer> tmp = list.get(v);
		if(tmp.isEmpty()) return 1;
		for(int i = 0; i < tmp.size(); i++) {
			if(tmp.get(i) == -1) continue;
			childArr[v][i] = childCal(tmp.get(i));
		}
		return childArr[v][0] + childArr[v][1] + 1;
	}
}
