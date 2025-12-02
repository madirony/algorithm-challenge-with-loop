package Hwan0518.day2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_5622_다이얼 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;



	public static void main(String[] args) throws IOException {

		// input
		char[] word = br.readLine().toCharArray();

		// find
		int time = 0;
		for (char c : word) {

			// index 계산
			int idx = c - 'A';

			// 예외
			if (c == 'S' || c == 'V' || c == 'Y') idx --;
			else if (c == 'Z') idx -=2;

			// 시간 계산
			time += 3 + (idx / 3);
		}

		// result
		System.out.print(time);

	}

}
