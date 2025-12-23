/*
  link : https://www.acmicpc.net/problem/1484
  tier : G5
  type : math/two-pointer
*/
import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		long front = 1, back = 2, max = 50000;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		while(front < back) {
			if(max < back) break;
			long tmp = back*back - front*front;
			if(tmp <= G) {
				if(tmp == G) { flag = true; sb.append(back).append('\n'); }
				back++;
			}
			else if (tmp > G) front++;
		}
		System.out.println(flag ? sb : -1);
	}
}
