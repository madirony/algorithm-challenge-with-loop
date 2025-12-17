package Hwan0518.day17;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_23351_물_주기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;


	static int[] arr;
	static int n, k, a, b;

	public static void main(String[] args) throws IOException {

		// input
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		arr = new int[n];
		for (int i=0; i<n; i++) arr[i] = k;

		// dfs
		int die = water();

		// result
		System.out.print(die);
	}


	static int water() {

		int day = 1;
		int die = -1;

		while (die == -1) {

			int minV = 1_000_000_000;
			int minIdx = 0;

			// 최소 수분 찾기
			for (int i = 0; i < n; i++) {
				if (arr[i] < minV) {
					minV = arr[i];
					minIdx = i;
				}
			}

			// minIdx + a만큼 연속으로 물주기
			minIdx = Integer.min(minIdx, n-a);
			for (int i = 0; i < a; i++) arr[minIdx + i] += b;

			// 전체 수분 감소
			for (int i = 0; i < n; i++) {
				arr[i]--;

				// 죽었나?
				if (arr[i] == 0) {
					die = day;
					break;
				}
			}

			// day 증가
			day++;
		}

		// result
		return die;
	}

}
