/*
  link : https://www.acmicpc.net/problem/3020
  tier : G5
  type : Prefix Sum
*/
import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] arr = new int[H+1];
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			if(i%2 == 0) {
				arr[1]++; arr[1+h]--;
			}
			else {
				arr[H-h+1]++;
			}
		}
		int height = 0;
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1; i <= H; i++) {
			height += arr[i];
			if(height < min) {
				cnt = 1; min = height;
			}
			else if(height == min) cnt++;
		}
		System.out.println(min + " " + cnt);
	}
}
