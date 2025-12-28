/*
  link : https://www.acmicpc.net/problem/1543
  tier : S5
  type : string
*/
import java.util.*;
import java.io.*;

class Main {
    static String doc, word;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        doc = br.readLine();
        word = br.readLine();

        int i = 0;
        while (i <= doc.length() - word.length()) {
            boolean ok = true;
            for (int j = 0; j < word.length(); j++) {
                if (doc.charAt(i + j) != word.charAt(j)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans++;
                i += word.length();
            } else {
                i++;
            }
        }

        System.out.println(ans);
    }
}
