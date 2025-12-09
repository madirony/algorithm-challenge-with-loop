/*
  link : https://www.acmicpc.net/problem/14267
  tier : G4
  type : tree/dp
*/
import java.util.*;
import java.io.*;

class Main
{
	static int n, m;
	static int[] superiors;
	static long[] compliments;
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		superiors = new int[n+1]; compliments = new long[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			superiors[i+1] = tmp;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			compliments[num] += w;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(superiors[i] == -1) sb.append("0");
			else {
				compliments[i] += compliments[superiors[i]];
				sb.append(' ').append(compliments[i]);
			}
		}
		System.out.println(sb);
	}
}
