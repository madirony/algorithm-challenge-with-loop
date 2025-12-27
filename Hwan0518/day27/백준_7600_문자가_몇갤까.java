package Hwan0518.day27;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_7600_문자가_몇갤까 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;

	public static void main(String[] args) throws IOException {

		// input
		String input = br.readLine().replace(" ", "");

		// calc
		boolean[] visited = new boolean[26];
		while (!input.equals("#")) {

			// set-up
			int cnt = 0;
			input = input.toLowerCase();

			// count
			for (char c : input.toCharArray()) {

				if (c < 'a') continue;

				if (!visited[c-'a']) {
					visited[c-'a'] = true;
					cnt ++;
				}
			}

			// add cnt
			sb.append(cnt).append("\n");

			// re-input
			visited = new boolean[26];
			input = br.readLine().replace(" ", "");
		}

		// result
		System.out.print(sb);
	}

}
