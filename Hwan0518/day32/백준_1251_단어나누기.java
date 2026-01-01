package Hwan0518.day32;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class 백준_1251_단어나누기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {

		// input
		String s = br.readLine();
		int len = s.length();

		// separate section
		List<String> list = new ArrayList<>();
		for (int i1=0; i1<len-2; i1++) {
			for (int i2=i1+1; i2<len-1; i2++) {

				sb = new StringBuilder();

				for (int i=i1; i>=0; i--) sb.append(s.charAt(i));
				for (int i=i2; i>i1; i--) sb.append(s.charAt(i));
				for (int i=len-1; i>i2; i--) sb.append(s.charAt(i));

				list.add(sb.toString());
			}
		}

		// sort
		Collections.sort(list);

		// result
		System.out.print(list.get(0));
	}

}
