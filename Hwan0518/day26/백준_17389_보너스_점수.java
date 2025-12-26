package Hwan0518.day26;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_17389_보너스_점수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;

	public static void main(String[] args) throws IOException {

		// input
		n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();

		// calc
		int score = 0;
		int bonus = 0;
		for (int i=1; i<=n; i++) {

			boolean collect = arr[i-1] == 'O';

			if (collect) {
				score += (i+bonus);
				bonus ++;
			}
			else {
				bonus = 0;
			}
		}

		// result
		System.out.print(score);
	}

}
