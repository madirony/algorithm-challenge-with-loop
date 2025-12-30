/*
  link : https://www.acmicpc.net/problem/1065
  tier : S4
  type : math
*/
import java.util.*;
import java.io.*;

class Main {
    static int N, ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }
        ans = 99;
        for (int x = 100; x <= N; x++) {
            int a = x / 100;
            int b = (x / 10) % 10;
            int c = x % 10;

            if ((a - b) == (b - c)) ans++;
        }

        System.out.println(ans);
    }
}
