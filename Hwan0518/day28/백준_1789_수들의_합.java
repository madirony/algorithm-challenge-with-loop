package Hwan0518.day28;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_1789_수들의_합 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// input
		long s = Long.parseLong(br.readLine());

		// find cnt
		int cnt = 0;
		long sum = 0;

		long cur = 1;
		while (sum < s) {
			sum += cur;
			cur++;
			cnt ++;
		}

		if (sum > s) cnt --; // (sum-s)에 해당하는 자연수 빼면 됨

		// result
		System.out.print(cnt);
	}

}
