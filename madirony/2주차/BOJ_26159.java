/*
  link : https://www.acmicpc.net/problem/26159
  tier : G2
  type : tree/dp/graph/dfs
*/
import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] weights;
	static final long MOD = 1000000007;
	static PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
	
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weights = new int[N-1];
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		StringTokenizer st;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) weights[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(weights);
		countC(1, -1);
		
		long ans = 0;
        for (int i = 0; i < N - 1; i++) {
            long w = weights[i] % MOD;
            long c = pq.poll() % MOD;
            ans = (ans + w*c) % MOD;
        }
		System.out.println(ans);
	}
	
	private static long countC(int num, int p){
		List<Integer> tmp = list.get(num);
		long sum = 1;
		for(Integer i : tmp){
			if(i != p){
				long sub = countC(i, num);
				pq.add(sub*(N-sub));
				sum += sub;
			}
		}
		return sum;
	}
}
