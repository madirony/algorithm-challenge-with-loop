package Hwan0518.day36;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 백준_5363_요다 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static List<String[]> list;

	public static void main(String[] args) throws IOException {

		// input
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i=0; i<n; i++) list.add(br.readLine().split(" "));

		// yoda
		sb = new StringBuilder();
		for (String[] s : list) {
			for (int i=2; i<s.length; i++) sb.append(s[i]).append(" ");
			sb.append(s[0]).append(" ");
			sb.append(s[1]);
			sb.append("\n");
		}

		// result
		System.out.print(sb);
	}

}
