/*
  link : https://www.acmicpc.net/problem/1174
  tier : G5
  type : dfs
*/
import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (1023 < N) { System.out.println(-1); return; }

        List<Long> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) dfs(i, i, list);
        Collections.sort(list);
        System.out.println(list.get(N-1));
    }

    static void dfs(long num, int last, List<Long> list) {
        list.add(num);
        for (int i = 0; i < last; i++) dfs(num * 10 + i, i, list);
    }
}
