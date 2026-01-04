/*
  link : https://www.acmicpc.net/problem/1544
  tier : S4
  type : string
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            set.add(canon(w));
        }

        System.out.println(set.size());
    }

    static String canon(String w) {
        int L = w.length();
        String ww = w + w;

        String best = null;
        for (int i = 0; i < L; i++) {
            String cand = ww.substring(i, i + L);
            if (best == null || cand.compareTo(best) < 0) best = cand;
        }
        return best;
    }
}
